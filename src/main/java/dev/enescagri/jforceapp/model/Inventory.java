package dev.enescagri.jforceapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;
    @Column(name = "status")
    private String status;
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "last_owner")
    private String lastOwner;

    @Column(name = "current_owner")
    private String currentOwner;


    public Inventory(){

    }

    public Inventory(String type, String brand, String model, String status, LocalDate date, String lastOwner, String currentOwner) {
        super();
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.status = status;
        this.date = date;
        this.lastOwner = "-";
        this.currentOwner = "Boşta";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLastOwner() {
        return lastOwner;
    }

    public void setLastOwner(String lastOwner) {
        this.lastOwner = lastOwner;
    }

    public String getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(String currentOwner) {
        this.currentOwner = currentOwner;
    }
}
