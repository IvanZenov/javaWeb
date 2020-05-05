package by.bsu.entity;
import by.bsu.entity.enums.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private Role role;
    private String phoneNumber;
    private double money;

    public User(String firstName, String secondName, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.money = 0;
        this.role = Role.USER;
    }


}
