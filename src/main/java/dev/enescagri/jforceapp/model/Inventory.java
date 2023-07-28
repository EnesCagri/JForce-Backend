package dev.enescagri.jforceapp.model;

import dev.enescagri.jforceapp.enums.InventoryStatus;
import dev.enescagri.jforceapp.enums.InventoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Enumerated(EnumType.STRING)
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
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InventoryStatus status;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "last_owner")
    private String lastOwner;

    @Column(name = "current_owner")
    private String currentOwner;



}
