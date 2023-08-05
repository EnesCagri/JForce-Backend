package dev.enescagri.jforceapp.dto;


import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private String type;
    private String brand;
    private String status;

}
