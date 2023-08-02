package dev.enescagri.jforceapp.dto;

import dev.enescagri.jforceapp.enums.InventoryStatus;
import dev.enescagri.jforceapp.enums.InventoryType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InventoryDetailsDTO {
    private Long id;
    private InventoryType type;
    private String brand;
    private String model;
    private InventoryStatus status;
    private LocalDate date;
    private String lastOwner;
    private String currentOwner;

}
