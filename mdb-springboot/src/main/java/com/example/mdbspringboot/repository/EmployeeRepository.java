package com.example.mdbspringboot.repository;

import com.example.mdbspringboot.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByEmail(String email);
}
