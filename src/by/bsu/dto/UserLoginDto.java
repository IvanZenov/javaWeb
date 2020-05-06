package by.bsu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto implements Serializable {
    public static final long serialVersionUID = 638259155572140275L;
    private String password;
    private String email;
}
