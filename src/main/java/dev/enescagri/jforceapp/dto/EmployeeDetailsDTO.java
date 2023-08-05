package dev.enescagri.jforceapp.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDetailsDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String tckn;
    private String gender;
    private LocalDate birthDate;
    private LocalDate enteranceDate;
    private LocalDate leaveDate;
    private String martialStatus;
    private String profilePic;
    private String workingStatus;
    private String department;
    private String mission;
    private String enteranceDepartment;
    private String enteranceMission;
    private String graduationStatus;
    private String leaveReason;
}
