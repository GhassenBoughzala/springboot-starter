package com.getarrays.employeemanager.service;

import com.getarrays.employeemanager.exception.UserNotFoundException;
import com.getarrays.employeemanager.model.Employee;
import com.getarrays.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo empRep;

    @Autowired
    public EmployeeService(EmployeeRepo empRep){
        this.empRep = empRep;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return empRep.save(employee);
    }

    public List<Employee> findAll(){
        return empRep.findAll();
    }

    public Employee updateEmp(Employee employee){
        return empRep.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return empRep.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("user by id" + id +"was not found"));
    }

    public void deleteEmployee(Long id){
        empRep.deleteEmployeeById(id);
    }
}
