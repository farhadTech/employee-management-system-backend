package com.farhad.crud.service;

import com.farhad.crud.model.Employee;
import com.farhad.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPassword(employee.getPassword());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setAddress(employee.getAddress());

        return employeeRepository.save(newEmployee);
    }


    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if(employee.getFirstName() != null) {
            existingEmployee.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName() != null) {
            existingEmployee.setLastName(employee.getLastName());
        }
        if(employee.getEmail() != null) {
            existingEmployee.setEmail(employee.getEmail());
        }
        if(employee.getPassword() != null) {
            existingEmployee.setPassword(employee.getPassword());
        }
        if(employee.getPhone() != null) {
            existingEmployee.setPhone(employee.getPhone());
        }
        if(employee.getAddress() != null) {
            existingEmployee.setAddress(employee.getAddress());
        }
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }
}

