package dev.enescagri.jforceapp.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String tckn;
    private String workingStatus;
    private String department;
    private String mission;
}
