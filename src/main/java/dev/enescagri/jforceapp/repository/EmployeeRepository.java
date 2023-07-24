package dev.enescagri.jforceapp.repository;

import dev.enescagri.jforceapp.model.Employee;
import dev.enescagri.jforceapp.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.inventories FROM Employee e WHERE e.id = :employeeId")
    List<Optional<Inventory>> findInventoriesById(@Param("employeeId") Long employeeId);
}
