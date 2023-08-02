package dev.enescagri.jforceapp.dto;

import dev.enescagri.jforceapp.enums.InventoryStatus;
import dev.enescagri.jforceapp.enums.InventoryType;
import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private InventoryType type;
    private String brand;
    private InventoryStatus status;

}
