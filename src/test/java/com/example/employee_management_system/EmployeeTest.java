package com.example.employee_management_system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void testNoArgsConstructorAndSetters() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setEmployeeId("E100");
        emp.setFirstName("Test");
        emp.setLastName("User");
        emp.setLocation("TestCity");

        assertEquals(1, emp.getId());
        assertEquals("E100", emp.getEmployeeId());
        assertEquals("Test", emp.getFirstName());
        assertEquals("User", emp.getLastName());
        assertEquals("TestCity", emp.getLocation());
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        Employee emp = new Employee(2, "E101", "Jane", "Doe", "New York");
        assertEquals(2, emp.getId());
        assertEquals("E101", emp.getEmployeeId());
        assertEquals("Jane", emp.getFirstName());
        assertEquals("Doe", emp.getLastName());
        assertEquals("New York", emp.getLocation());
    }
}
