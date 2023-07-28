package dev.enescagri.jforceapp.model;


import dev.enescagri.jforceapp.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zÇçĞğİıÖöŞşÜü\\s]+$")
    @Size(min = 2, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zÇçĞğİıÖöŞşÜü\\s]+$")
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(min = 11, max = 11)
    @Digits(integer = 11, fraction = 0)
    @Column(name = "tckn")
    private String tckn;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotNull
    @Column(name = "enterance_date")
    private LocalDate enteranceDate;


    @Column(name = "leave_date")
    private LocalDate leaveDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MartialStatus martialStatus;

    @Lob
    @Column(name = "profile_pic")
    private Byte[] profilePic;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "working_status")
    private WorkingStatus workingStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    private Department department;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "mission")
    private Position mission;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "enterance_department")
    private Department enteranceDepartment;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "enterance_mission")
    private Position enteranceMission;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "graduation_status")
    private GraduationStatus graduationStatus;

    @Column(name = "leave_reason")
    private String leaveReason;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ei_fid", referencedColumnName = "id")
    @Column(name = "inventories")
    private List<Inventory> inventories = new ArrayList<>();


}
