package com.example.employee_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public int addEmployee(Employee emp) {
        return repository.addEmployee(emp);
    }

    public List<Employee> getEmployeesByLocation(String location) {
        return repository.getEmployeesByLocation(location);
    }

    public int removeEmployee(String employeeId) {
        return repository.removeEmployee(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }
}
