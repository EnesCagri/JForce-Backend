package dev.enescagri.jforceapp.controller;

import dev.enescagri.jforceapp.dto.EmployeeDTO;
import dev.enescagri.jforceapp.dto.EmployeeDetailsDTO;
import dev.enescagri.jforceapp.dto.InventoryDetailsDTO;
import dev.enescagri.jforceapp.model.Employee;
import dev.enescagri.jforceapp.service.EmployeeServiceImpl;
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
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployeeDTOs();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<EmployeeDetailsDTO>> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeDTOById(id), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employeeDetails){
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeDetails), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/{employeeId}/inventories")
    public List<InventoryDetailsDTO> getAllInventories(@PathVariable Long employeeId) {
        return employeeService.getAllInventoryDTOs(employeeId);
    }

    @PostMapping("/employees/{employeeId}/inventories/{inventoryId}")
    public Employee addInventoryToEmployee(
            @PathVariable Long employeeId,
            @PathVariable Long inventoryId
    ) {
        return employeeService.addInventoryById(employeeId, inventoryId);
    }

    @DeleteMapping("/employees/{employeeId}/inventories/{inventoryId}")
    public ResponseEntity<Map<String, Boolean>> discardInventoryFromEmployee(
            @PathVariable Long employeeId,
            @PathVariable Long inventoryId
    ) {
        return employeeService.discardInventoryFromEmployee(employeeId, inventoryId);
    }

    @PutMapping("/employees/{id}/resign")
    public ResponseEntity<Optional<Employee>> resignEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return new ResponseEntity<>(employeeService.resignEmployee(id, employeeDetails), HttpStatus.OK);
    }

}
