package by.bsu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private Long userId;
    private Long reservationId;
    private double money;
    private String description;

}
