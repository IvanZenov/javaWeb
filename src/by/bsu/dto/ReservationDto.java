package by.bsu.dto;

import by.bsu.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReservationDto {
    private String reservationId;
    private Status status;
}
