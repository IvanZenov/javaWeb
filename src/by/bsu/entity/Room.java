package by.bsu.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Long id;
    private int places;
    private double dailyPrice;
    private String imageUrl;
    private String name;
    private String description;
    private boolean free;

    public Room(int places, double dailyPrice, String imageUrl, String name, String description, boolean isFree) {
        this.places = places;
        this.dailyPrice = dailyPrice;
        this.imageUrl = imageUrl;
        this.name = name;
        this.description = description;
        this.free = isFree;
    }
}
