package com.farhad.crud.controller;

import com.farhad.crud.model.Employee;
import com.farhad.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;;

    @GetMapping("/")
    public ResponseEntity home() {
        String message = "Hello World";
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<> (updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }
}










