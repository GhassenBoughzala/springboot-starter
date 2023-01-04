package com.example.mdbspringboot.controller;

import com.example.mdbspringboot.model.Employee;
import com.example.mdbspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee emp){
        return service.addEmployee(emp);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return service.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId){
        return service.getEmployeeById(employeeId);
    }

    @GetMapping("/email/{email}")
    public List<Employee> findEmployeeEmail(@PathVariable String email){
        return service.getEmployeeByEmail(email);
    }

    @PutMapping
    public Employee modifyEmployee(@RequestBody Employee emp){
        return service.updateEmployee(emp);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId){
        return service.deleteEmployee(employeeId);
    }

}
