package dev.enescagri.jforceapp.model;

import dev.enescagri.jforceapp.enum_converter.InventoryStatusConverter;
import dev.enescagri.jforceapp.enum_converter.InventoryTypeConverter;
import dev.enescagri.jforceapp.enums.InventoryStatus;
import dev.enescagri.jforceapp.enums.InventoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


import java.time.LocalDate;

@Entity
@Table(name = "inventories")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Convert(converter = InventoryTypeConverter.class)
    @Column(name = "type")
    private InventoryType type;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "brand")
    private String brand;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "model")
    private String model;

    @NotNull
    @Convert(converter = InventoryStatusConverter.class)
    @Column(name = "status")
    private InventoryStatus status;

    @NotNull
    @PastOrPresent
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "last_owner")
    private String lastOwner;

    @Column(name = "current_owner")
    private String currentOwner;



}
