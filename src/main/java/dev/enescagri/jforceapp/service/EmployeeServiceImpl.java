package dev.enescagri.jforceapp.service;

import dev.enescagri.jforceapp.enums.InventoryStatus;
import dev.enescagri.jforceapp.enums.WorkingStatus;
import dev.enescagri.jforceapp.model.Employee;
import dev.enescagri.jforceapp.model.Inventory;
import dev.enescagri.jforceapp.repository.EmployeeRepository;
import dev.enescagri.jforceapp.repository.InventoryRepository;
import dev.enescagri.jforceapp.service_interface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> updateEmployee(Long id, Employee employeeDetails){
        Optional<Employee> employeeOptional = getEmployeeById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setBirthDate(employeeDetails.getBirthDate());
            employee.setGender(employeeDetails.getGender());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setMission(employeeDetails.getMission());
            employee.setGraduationStatus(employeeDetails.getGraduationStatus());
            employee.setMartialStatus(employeeDetails.getMartialStatus());
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

    @Override
    public Optional<Employee> resignEmployee(Long id, Employee employeeDetails){
        Optional<Employee> employeeOptional = getEmployeeById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            employee.setLeaveDate(employeeDetails.getLeaveDate());
            employee.setLeaveReason(employeeDetails.getLeaveReason());
            employee.setWorkingStatus(WorkingStatus.NOT_WORKING);

            for (Inventory inventory : employee.getInventories()) {
                inventory.setStatus(InventoryStatus.DEPOT);
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

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id){
        Optional<Employee> employeeOptional = getEmployeeById(id);
        Map<String, Boolean> response = new HashMap<>();
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            for (Inventory inventory : employee.getInventories()) {
                inventory.setStatus(InventoryStatus.USING);
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

    @Override
    public List<Optional<Inventory>> getAllInventories(Long employeeId) {
        return employeeRepository.findInventoriesById(employeeId);
    }

    @Override
    public Employee addInventoryById(Long employeeId, Long inventoryId){
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(inventoryId);

        if (employeeOptional.isPresent() && inventoryOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Inventory inventory = inventoryOptional.get();

            inventory.setStatus(InventoryStatus.USING);
            inventory.setDate(LocalDate.now());
            inventory.setCurrentOwner(employee.getFirstName() + " " + employee.getLastName());

            List<Inventory> inventories = employee.getInventories();
            inventories.add(inventory);

            employee.setInventories(inventories);

            return employeeRepository.save(employee);
        }

        throw new RuntimeException();
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> discardInventoryFromEmployee(Long employeeId, Long inventoryId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(inventoryId);
        Map<String, Boolean> response = new HashMap<>();

        if (employeeOptional.isPresent() && inventoryOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Inventory inventory = inventoryOptional.get();

            inventory.setDate(LocalDate.now());
            inventory.setStatus(InventoryStatus.DEPOT);
            inventory.setLastOwner(employee.getFirstName() + " " + employee.getLastName());
            inventory.setCurrentOwner("-");

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
