package dev.enescagri.jforceapp.controller;

import dev.enescagri.jforceapp.dto.InventoryDTO;
import dev.enescagri.jforceapp.dto.InventoryDetailsDTO;
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

    private final InventoryServiceImpl inventoryService;

    @Autowired
    public InventoryController(InventoryServiceImpl inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventories")
    public List<InventoryDTO> getAllInventories(){
        return inventoryService.getAllInventoryDTOs();
    }

    @GetMapping("/inventories/details")
    public List<InventoryDetailsDTO> getAllInventoriesDetails(){
        return inventoryService.getAllInventoryDetailDTOs();
    }

    @PostMapping("/inventories")
    public Inventory createInventory(@Valid @RequestBody Inventory inventory){
        return inventoryService.createInventory(inventory);
    }

    @GetMapping("/inventories/{id}")
    public ResponseEntity<Optional<InventoryDetailsDTO>> getInventoryById(@PathVariable Long id){
        return new ResponseEntity<>(inventoryService.getInventoryDTOById(id), HttpStatus.OK);
    }

    @PutMapping("/inventories/{id}")
    public ResponseEntity<Optional<Inventory>> updateInventoryById(@PathVariable Long id, @RequestBody Inventory inventoryDetails){
        return new ResponseEntity<>(inventoryService.updateInventory(id, inventoryDetails), HttpStatus.OK);
    }

    @DeleteMapping("/inventories/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteInventory(@PathVariable Long id){
        return inventoryService.deleteInventory(id);
    }
}
