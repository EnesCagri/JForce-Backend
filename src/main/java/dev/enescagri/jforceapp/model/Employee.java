package dev.enescagri.jforceapp.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;

    @Column(name = "TCKN")
    private Long tckn;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "enterance_date")
    private LocalDate enteranceDate;

    @Column(name = "leave_date")
    private LocalDate leaveDate;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "profile_pic")
    private String profilePic;

    @Column(name = "is_working")
    private String isWorking;

    @Column(name = "department")
    private String department;

    @Column(name = "mission")
    private String mission;

    @Column(name = "enterance_department")
    private String enteranceDepartment;

    public LocalDate getEnteranceDate() {
        return enteranceDate;
    }

    public void setEnteranceDate(LocalDate enteranceDate) {
        this.enteranceDate = enteranceDate;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getEnteranceDepartment() {
        return enteranceDepartment;
    }

    public void setEnteranceDepartment(String enteranceDepartment) {
        this.enteranceDepartment = enteranceDepartment;
    }

    public String getEnteranceMission() {
        return enteranceMission;
    }

    public void setEnteranceMission(String enteranceMission) {
        this.enteranceMission = enteranceMission;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    @Column(name = "enterance_mission")
    private String enteranceMission;
    @Column(name = "graduation_status")
    private String isGraduated;

    @Column(name = "leave_reason")
    private String leaveReason;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ei_fid", referencedColumnName = "id")
    @Column(name = "inventories")
    private List<Inventory> inventories = new ArrayList<>();


    public Employee() {
    }

    public Employee(String firstName, String lastName, String emailId, String gender, LocalDate birthDate, String maritalStatus, String profilePic, String isWorking, String department, String mission, String isGraduated, Long tckn, LocalDate enteranceDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.gender = gender;
        this.birthDate = birthDate;
        this.maritalStatus = maritalStatus;
        this.profilePic = profilePic;
        this.isWorking = isWorking;
        this.department = department;
        this.mission = mission;
        this.isGraduated = isGraduated;
        this.tckn = tckn;
        this.enteranceDate = enteranceDate;
        this.enteranceMission = mission;
        this.enteranceDepartment = department;
        this.leaveReason = "";
        this.leaveDate = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(String working) {
        isWorking = working;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getIsGraduated() {
        return isGraduated;
    }

    public void setGraduated(String graduated) {
        isGraduated = graduated;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getTckn() {
        return tckn;
    }

    public void setTckn(Long tckn) {
        this.tckn = tckn;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }


}
