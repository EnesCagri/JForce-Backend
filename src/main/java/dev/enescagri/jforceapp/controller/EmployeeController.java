package dev.enescagri.jforceapp.controller;

import dev.enescagri.jforceapp.model.Employee;
import dev.enescagri.jforceapp.model.Inventory;
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
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeServiceImpl.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeServiceImpl.createEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeServiceImpl.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id, @RequestBody Employee employeeDetails){
        return new ResponseEntity<>(employeeServiceImpl.updateEmployee(id, employeeDetails), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        return employeeServiceImpl.deleteEmployee(id);
    }

    @GetMapping("/employees/{employeeId}/inventories")
    public List<Optional<Inventory>> getAllInventories(@PathVariable Long employeeId) {
        return employeeServiceImpl.getAllInventories(employeeId);
    }

    @PostMapping("/employees/{employeeId}/inventories/{inventoryId}")
    public Employee addInventoryToEmployee(
            @PathVariable Long employeeId,
            @PathVariable Long inventoryId
    ) {
        return employeeServiceImpl.addInventoryById(employeeId, inventoryId);
    }

    @DeleteMapping("/employees/{employeeId}/inventories/{inventoryId}")
    public ResponseEntity<Map<String, Boolean>> discardInventoryFromEmployee(
            @PathVariable Long employeeId,
            @PathVariable Long inventoryId
    ) {
        return employeeServiceImpl.discardInventoryFromEmployee(employeeId, inventoryId);
    }

    @PutMapping("/employees/{id}/resign")
    public ResponseEntity<Optional<Employee>> resignEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return new ResponseEntity<>(employeeServiceImpl.resignEmployee(id, employeeDetails), HttpStatus.OK);
    }

}
