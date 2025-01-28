package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Optional<Employee> findByPartyId(String partyId);
    String  deleteByPartyId(String partyId);
}
