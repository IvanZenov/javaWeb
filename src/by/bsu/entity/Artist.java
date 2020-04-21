package by.bsu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Artist {
    private Long id;
    private String name;

    public Artist(String name){
        this.name = name;
    }

}
