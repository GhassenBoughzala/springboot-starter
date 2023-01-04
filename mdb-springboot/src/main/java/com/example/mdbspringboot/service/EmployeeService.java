package com.example.mdbspringboot.service;

import com.example.mdbspringboot.model.Employee;
import com.example.mdbspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository EmpRepo;

    public Employee addEmployee(Employee emp){
        emp.setId(UUID.randomUUID().toString().split("-")[0]);
        return EmpRepo.save(emp);
    }

    public List<Employee> findAll(){
        return EmpRepo.findAll();
    }

    public Employee getEmployeeById(String Id){
        return EmpRepo.findById(Id).get();
    }

    public List<Employee> getEmployeeByEmail(String Email){
        return EmpRepo.findByEmail(Email);
    }

    public Employee updateEmployee(Employee empReq){
        Employee existing = EmpRepo.findById(empReq.getId()).get();
        existing.setName(empReq.getName());
        existing.setEmail(empReq.getEmail());
        existing.setJob(empReq.getJob());
        existing.setPhone(empReq.getPhone());
        existing.setImgurl(empReq.getImgurl());

        return EmpRepo.save(existing);
    }

    public String deleteEmployee(String Id){
        EmpRepo.deleteById(Id);
        return Id+ "Employee deleted successfully ";
    }



}
