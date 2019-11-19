package com.examples.empapp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.examples.empapp.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Object>{

}
