package by.bsu.service;

import by.bsu.dao.ArtistDao;
import by.bsu.dto.ArtistDto;
import by.bsu.entity.Artist;

public class ArtistService {
    private static ArtistService INSTANCE;

    public ArtistDto save(Artist artist){
        Artist savedArtist = ArtistDao.getInstance().save(artist);
        return new ArtistDto(savedArtist.getId(),savedArtist.getName());
    }

    public ArtistDto findOne(Long id) {
        Artist foundArtist = ArtistDao.getInstance().findOne(id);
        if (foundArtist == null) {
            return null;
        }
        return new ArtistDto(foundArtist.getId(), foundArtist.getName());
    }
    public static ArtistService getInstance() {
        if (INSTANCE == null) {
            synchronized (ArtistService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ArtistService();
                }
            }
        }
        return INSTANCE;
    }
}
