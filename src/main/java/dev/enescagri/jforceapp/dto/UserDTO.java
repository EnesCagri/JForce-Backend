package dev.enescagri.jforceapp.dto;

import dev.enescagri.jforceapp.enums.Role;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private Role role;

}
