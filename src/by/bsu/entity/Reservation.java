package by.bsu.entity;

import by.bsu.entity.enums.Status;
import lombok.*;

import java.time.LocalDate;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Reservation {
    private Long id;
    private Long userId;
    private Long roomId;
    private Date arrival;
    private Date checkout;
    private Status status;
}
