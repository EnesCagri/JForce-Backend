package dev.enescagri.jforceapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InventoryDetailsDTO {
    private Long id;
    private String type;
    private String brand;
    private String model;
    private String status;
    private LocalDate date;
    private String lastOwner;
    private String currentOwner;

}
