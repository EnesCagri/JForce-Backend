package dev.enescagri.jforceapp.dto;

import dev.enescagri.jforceapp.enums.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDetailsDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String tckn;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate enteranceDate;
    private LocalDate leaveDate;
    private MartialStatus martialStatus;
    private String profilePic;
    private WorkingStatus workingStatus;
    private Department department;
    private Position mission;
    private Department enteranceDepartment;
    private Position enteranceMission;
    private GraduationStatus graduationStatus;
    private String leaveReason;
}
