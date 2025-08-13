package com.example.employee_management_system;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    public EmployeeControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee(0, "E003", "Alice", "Brown", "Chicago");
        when(employeeService.addEmployee(emp)).thenReturn(1);
        ResponseEntity<String> response = employeeController.addEmployee(emp);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Employee added successfully", response.getBody());
    }

    @Test
    void testGetEmployeesByLocation() {
        List<Employee> employees = Arrays.asList(
                new Employee(0, "E001", "John", "Doe", "New York"),
                new Employee(0, "E002", "Jane", "Smith", "New York")
        );
        when(employeeService.getEmployeesByLocation("New York")).thenReturn(employees);
        List<Employee> result = employeeController.getEmployees("New York");
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
    }

    @Test
    void testRemoveEmployee() {
        when(employeeService.removeEmployee("E001")).thenReturn(1);
        ResponseEntity<String> response = employeeController.removeEmployee("E001");
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Employee removed successfully", response.getBody());
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(0, "E001", "John", "Doe", "New York"),
                new Employee(0, "E002", "Jane", "Smith", "San Francisco")
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);
        List<Employee> result = employeeController.getEmployees(null);
        assertEquals(2, result.size());
    }
}
