package com.example.employee_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (employee_id, first_name, last_name, location) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getEmployeeId(), emp.getFirstName(), emp.getLastName(), emp.getLocation());
    }

    public List<Employee> getEmployeesByLocation(String location) {
        String sql = "SELECT * FROM employees WHERE location = ?";
        return jdbcTemplate.query(sql, new Object[]{location}, new BeanPropertyRowMapper<>(Employee.class));
    }

    public int removeEmployee(String employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        return jdbcTemplate.update(sql, employeeId);
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }
}
