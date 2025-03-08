package com.farhad.crud.service;

import com.farhad.crud.model.Employee;
import com.farhad.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee, Long id);
    public void deleteEmployee(Long id);
}
