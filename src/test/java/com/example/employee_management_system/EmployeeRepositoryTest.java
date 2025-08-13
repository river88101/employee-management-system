package com.example.employee_management_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(EmployeeRepository.class)
class EmployeeRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeRepository repository;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("DELETE FROM employees");
        jdbcTemplate.execute("INSERT INTO employees (employee_id, first_name, last_name, location) VALUES ('E001', 'John', 'Doe', 'New York')");
        jdbcTemplate.execute("INSERT INTO employees (employee_id, first_name, last_name, location) VALUES ('E002', 'Jane', 'Smith', 'San Francisco')");
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee(0, "E003", "Alice", "Brown", "Chicago");
        int result = repository.addEmployee(emp);
        assertEquals(1, result);
        List<Employee> all = repository.getAllEmployees();
        assertEquals(3, all.size());
    }

    @Test
    void testGetEmployeesByLocation() {
        List<Employee> nyEmployees = repository.getEmployeesByLocation("New York");
        assertEquals(1, nyEmployees.size());
        assertEquals("John", nyEmployees.get(0).getFirstName());
    }

    @Test
    void testRemoveEmployee() {
        int result = repository.removeEmployee("E001");
        assertEquals(1, result);
        List<Employee> all = repository.getAllEmployees();
        assertEquals(1, all.size());
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> all = repository.getAllEmployees();
        assertEquals(2, all.size());
    }

    @Test
    void testRemoveNonExistentEmployee() {
        int result = repository.removeEmployee("E999");
        assertEquals(0, result);
    }
}
