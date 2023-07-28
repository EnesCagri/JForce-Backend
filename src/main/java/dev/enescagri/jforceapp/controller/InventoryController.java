package dev.enescagri.jforceapp.controller;

import dev.enescagri.jforceapp.model.Inventory;
import dev.enescagri.jforceapp.service.InventoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class InventoryController {

    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @GetMapping("/inventories")
    public List<Inventory> getAllInventories(){
        return inventoryServiceImpl.getAllInventory();
    }

    @PostMapping("/inventories")
    public Inventory createInventory(@Valid @RequestBody Inventory inventory){
        return inventoryServiceImpl.createInventory(inventory);
    }

    @GetMapping("/inventories/{id}")
    public ResponseEntity<Optional<Inventory>> getInventoryById(@PathVariable Long id){
        return new ResponseEntity<>(inventoryServiceImpl.getInventoryById(id), HttpStatus.OK);
    }

    @PutMapping("/inventories/{id}")
    public ResponseEntity<Optional<Inventory>> getInventoryById(@PathVariable Long id, @RequestBody Inventory inventoryDetails){
        return new ResponseEntity<>(inventoryServiceImpl.updateInventory(id, inventoryDetails), HttpStatus.OK);
    }

    @DeleteMapping("/inventories/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteInventory(@PathVariable Long id){
        return inventoryServiceImpl.deleteInventory(id);
    }
}
