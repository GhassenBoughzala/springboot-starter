package com.example.mdbspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.mdbspringboot.repository.EmployeeRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringbootApplication implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository EmployeeRepo;
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MdbSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
