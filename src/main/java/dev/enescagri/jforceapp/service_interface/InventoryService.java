package dev.enescagri.jforceapp.service_interface;

import dev.enescagri.jforceapp.dto.InventoryDTO;
import dev.enescagri.jforceapp.dto.InventoryDetailsDTO;
import dev.enescagri.jforceapp.model.Inventory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public interface InventoryService {

    List<Inventory> getAllInventory();

    Inventory createInventory(Inventory inventory);

    Optional<Inventory> getInventoryById(Long id);

    Optional<Inventory> updateInventory(Long id, Inventory employeeDetails);

    ResponseEntity<Map<String, Boolean>> deleteInventory(Long id);

    List<InventoryDTO> getAllInventoryDTOs();
    List<InventoryDetailsDTO> getAllInventoryDetailDTOs();


}
