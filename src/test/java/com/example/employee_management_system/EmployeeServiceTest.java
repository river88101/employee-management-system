package com.example.employee_management_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee(0, "E004", "Bob", "White", "Boston");
        when(repository.addEmployee(emp)).thenReturn(1);
        int result = service.addEmployee(emp);
        assertEquals(1, result);
        verify(repository, times(1)).addEmployee(emp);
    }

    @Test
    void testGetEmployeesByLocation() {
        List<Employee> employees = Arrays.asList(
                new Employee(0, "E001", "John", "Doe", "New York"),
                new Employee(0, "E002", "Jane", "Smith", "New York")
        );
        when(repository.getEmployeesByLocation("New York")).thenReturn(employees);
        List<Employee> result = service.getEmployeesByLocation("New York");
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
    }

    @Test
    void testRemoveEmployee() {
        when(repository.removeEmployee("E001")).thenReturn(1);
        int result = service.removeEmployee("E001");
        assertEquals(1, result);
        verify(repository, times(1)).removeEmployee("E001");
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(0, "E001", "John", "Doe", "New York"),
                new Employee(0, "E002", "Jane", "Smith", "San Francisco")
        );
        when(repository.getAllEmployees()).thenReturn(employees);
        List<Employee> result = service.getAllEmployees();
        assertEquals(2, result.size());
    }
}
