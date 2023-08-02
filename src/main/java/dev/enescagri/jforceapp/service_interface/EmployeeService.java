package dev.enescagri.jforceapp.service_interface;

import dev.enescagri.jforceapp.dto.EmployeeDTO;
import dev.enescagri.jforceapp.dto.EmployeeDetailsDTO;
import dev.enescagri.jforceapp.dto.InventoryDTO;
import dev.enescagri.jforceapp.model.Employee;
import dev.enescagri.jforceapp.model.Inventory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Long id);

    Optional<Employee> updateEmployee(Long id, Employee employeeDetails);

    Optional<Employee> resignEmployee(Long id, Employee employeeDetails);

    ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id);

    List<Optional<Inventory>> getAllInventories(Long employeeId);

    Employee addInventoryById(Long employeeId, Long inventoryId);

    ResponseEntity<Map<String, Boolean>> discardInventoryFromEmployee(Long employeeId, Long inventoryId);

    Optional<EmployeeDetailsDTO> getEmployeeDTOById(Long id);

    List<EmployeeDTO> getAllEmployeeDTOs();
    List<InventoryDTO> getAllInventoryDTOs(Long employeeId);

}
