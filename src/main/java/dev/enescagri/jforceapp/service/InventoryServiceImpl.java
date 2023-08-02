package dev.enescagri.jforceapp.service;


import dev.enescagri.jforceapp.dto.InventoryDTO;
import dev.enescagri.jforceapp.dto.InventoryDetailsDTO;
import dev.enescagri.jforceapp.model.Inventory;
import dev.enescagri.jforceapp.repository.InventoryRepository;
import dev.enescagri.jforceapp.service_interface.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory createInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    @Override
    public Optional<Inventory> getInventoryById(Long id){
        return inventoryRepository.findById(id);
    }

    @Override
    public Optional<Inventory> updateInventory(Long id, Inventory employeeDetails){
        Optional<Inventory> inventoryOptional = getInventoryById(id);

        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();
            inventory.setType(employeeDetails.getType());
            inventory.setStatus(employeeDetails.getStatus());
            inventory.setBrand(employeeDetails.getBrand());
            inventory.setModel(employeeDetails.getModel());
            inventory.setDate(employeeDetails.getDate());

            inventoryRepository.save(inventory);
            return Optional.of(inventory);
        }
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteInventory(Long id){
        Optional<Inventory> inventoryOptional = getInventoryById(id);
        Map<String, Boolean> response = new HashMap<>();
        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();

            inventoryRepository.delete(inventory);

            response.put("deleted", Boolean.TRUE);

            return ResponseEntity.ok(response);
        }
        response.put("deleted", Boolean.FALSE);

        return ResponseEntity.notFound().build();
    }

    //  DTO
    private InventoryDTO convertEntityToDTO(Inventory inventory){
        return modelMapper.map(inventory, InventoryDTO.class);
    }

    public List<InventoryDTO> getAllInventoryDTOs(){
        return inventoryRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private InventoryDetailsDTO convertEntityToDetailsDTO(Inventory inventory){
        return modelMapper.map(inventory, InventoryDetailsDTO.class);
    }

    public Optional<InventoryDetailsDTO> getInventoryDTOById(Long id) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);

        return optionalInventory.map(this::convertEntityToDetailsDTO);
    }

}
