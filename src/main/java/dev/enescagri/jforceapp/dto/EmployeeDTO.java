package dev.enescagri.jforceapp.dto;

import dev.enescagri.jforceapp.enums.*;
import lombok.Data;

@Data
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String tckn;
    private WorkingStatus workingStatus;
    private Department department;
    private Position mission;
}
