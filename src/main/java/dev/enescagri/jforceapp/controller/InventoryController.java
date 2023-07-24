package dev.enescagri.jforceapp.controller;

import dev.enescagri.jforceapp.model.Employee;
import dev.enescagri.jforceapp.model.Inventory;
import dev.enescagri.jforceapp.service.EmployeeService;
import dev.enescagri.jforceapp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventories")
    public List<Inventory> getAllInventories(){
        return inventoryService.getAllInventory();
    }

    @PostMapping("/inventories")
    public Inventory createInventory(@RequestBody Inventory inventory){
        return inventoryService.createInventory(inventory);
    }

    @GetMapping("/inventories/{id}")
    public ResponseEntity<Optional<Inventory>> getInventoryById(@PathVariable Long id){
        return new ResponseEntity<Optional<Inventory>>(inventoryService.getInventoryById(id), HttpStatus.OK);
    }

    @PutMapping("/inventories/{id}")
    public ResponseEntity<Optional<Inventory>> getInventoryById(@PathVariable Long id, @RequestBody Inventory inventoryDetails){
        return new ResponseEntity<Optional<Inventory>>(inventoryService.updateInventory(id, inventoryDetails), HttpStatus.OK);
    }

    @DeleteMapping("/inventories/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteInventory(@PathVariable Long id){
        return inventoryService.deleteInventory(id);
    }
}
