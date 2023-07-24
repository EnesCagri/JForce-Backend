package dev.enescagri.jforceapp.controller;

import dev.enescagri.jforceapp.model.Employee;
import dev.enescagri.jforceapp.model.Inventory;
import dev.enescagri.jforceapp.repository.EmployeeRepository;
import dev.enescagri.jforceapp.service.EmployeeService;
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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<Optional<Employee>>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id, @RequestBody Employee employeeDetails){
        return new ResponseEntity<Optional<Employee>>(employeeService.updateEmployee(id, employeeDetails), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/{employeeId}/inventories")
    public List<Optional<Inventory>> getAllInventories(@PathVariable Long employeeId) {
        return employeeService.getAllInventories(employeeId);
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
        return new ResponseEntity<Optional<Employee>>(employeeService.resignEmployee(id, employeeDetails), HttpStatus.OK);
    }

}
