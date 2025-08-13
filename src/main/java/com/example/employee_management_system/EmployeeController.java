package com.example.employee_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
        int result = service.addEmployee(emp);
        if (result > 0) {
            return ResponseEntity.ok("Employee added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add employee");
        }
    }

    @GetMapping
    public List<Employee> getEmployees(@RequestParam(required = false) String location) {
        if (location != null && !location.isEmpty()) {
            return service.getEmployeesByLocation(location);
        } else {
            return service.getAllEmployees();
        }
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> removeEmployee(@PathVariable String employeeId) {
        int result = service.removeEmployee(employeeId);
        if (result > 0) {
            return ResponseEntity.ok("Employee removed successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to remove employee");
        }
    }
}
