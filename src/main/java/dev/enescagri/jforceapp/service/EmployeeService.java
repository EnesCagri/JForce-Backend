package dev.enescagri.jforceapp.service;

import dev.enescagri.jforceapp.exception.ResourceNotFoundException;
import dev.enescagri.jforceapp.model.Employee;
import dev.enescagri.jforceapp.model.Inventory;
import dev.enescagri.jforceapp.repository.EmployeeRepository;
import dev.enescagri.jforceapp.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public Optional<Employee> updateEmployee(Long id, Employee employeeDetails){
        Optional<Employee> employeeOptional = getEmployeeById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmailId(employeeDetails.getEmailId());
            employee.setBirthDate(employeeDetails.getBirthDate());
            employee.setGender(employeeDetails.getGender());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setMission(employeeDetails.getMission());
            employee.setGraduated(employeeDetails.getIsGraduated());
            employee.setMaritalStatus(employeeDetails.getMaritalStatus());
            employee.setProfilePic(employeeDetails.getProfilePic());
            employee.setTckn(employeeDetails.getTckn());

            employee.setEnteranceDate(employeeDetails.getEnteranceDate());
            employee.setEnteranceDepartment(employeeDetails.getEnteranceDepartment());
            employee.setEnteranceMission(employeeDetails.getEnteranceMission());

            employeeRepository.save(employee);
            return Optional.of(employee);
        }

        return Optional.empty();
    }

    public Optional<Employee> resignEmployee(Long id, Employee employeeDetails){
        Optional<Employee> employeeOptional = getEmployeeById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            employee.setLeaveDate(employeeDetails.getLeaveDate());
            employee.setLeaveReason(employeeDetails.getLeaveReason());
            employee.setIsWorking("Çalışmıyor");

            for (Inventory inventory : employee.getInventories()) {
                inventory.setStatus("Depoda");
                inventory.setDate(LocalDate.now());
                inventory.setLastOwner(employee.getFirstName() + " " + employee.getLastName());
                inventory.setCurrentOwner("Boşta");
            }

            employee.getInventories().clear();

            employeeRepository.save(employee);
            return Optional.of(employee);
        }

        return Optional.empty();
    }

    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id){
        Optional<Employee> employeeOptional = getEmployeeById(id);
        Map<String, Boolean> response = new HashMap<>();
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            for (Inventory inventory : employee.getInventories()) {
                inventory.setStatus("Personalde");
                inventory.setDate(LocalDate.now());
            }

            employee.getInventories().clear();

            employeeRepository.delete(employee);

            response.put("deleted", Boolean.TRUE);

            return ResponseEntity.ok(response);
        }
        response.put("not found", Boolean.FALSE);

        return ResponseEntity.notFound().build();
    }

    public List<Optional<Inventory>> getAllInventories(Long employeeId) {
        return employeeRepository.findInventoriesById(employeeId);
    }

    public Employee addInventoryById(Long employeeId, Long inventoryId){
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(inventoryId);

        if (employeeOptional.isPresent() && inventoryOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Inventory inventory = inventoryOptional.get();

            inventory.setStatus("Personalde");
            inventory.setDate(LocalDate.now());
            inventory.setCurrentOwner(employee.getFirstName() + " " + employee.getLastName());

            List<Inventory> inventories = employee.getInventories();
            inventories.add(inventory);

            employee.setInventories(inventories);

            return employeeRepository.save(employee);
        }

        throw new RuntimeException();
    }

    public ResponseEntity<Map<String, Boolean>> discardInventoryFromEmployee(Long employeeId, Long inventoryId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(inventoryId);
        Map<String, Boolean> response = new HashMap<>();

        if (employeeOptional.isPresent() && inventoryOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Inventory inventory = inventoryOptional.get();

            inventory.setDate(LocalDate.now());
            inventory.setStatus("Depoda");

            inventory.setLastOwner(employee.getFirstName() + " " + employee.getLastName());
            inventory.setCurrentOwner("Boşta");

            List<Inventory> inventories = employee.getInventories();
            inventories.remove(inventory);
            employee.setInventories(inventories);

            employeeRepository.save(employee);

            response.put("discarded", Boolean.TRUE);

            return ResponseEntity.ok(response);
        }

        response.put("not found", Boolean.TRUE);
        return ResponseEntity.notFound().build();
    }



}
