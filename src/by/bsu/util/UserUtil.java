package by.bsu.util;

import by.bsu.entity.User;
import by.bsu.entity.enums.Role;

public class UserUtil {
    private Role getPageRole(String uri) {
        for (Role role : Role.values()) {
            if (uri.contains(role.name().toLowerCase())) {
                return role;
            }
        }
        return Role.USER;
    }

}
