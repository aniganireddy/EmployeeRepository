package com.example.demo.service;

import com.example.demo.dto.APIDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    APIDto getEmployee(String partyId);
    List<EmployeeDto> getAllEmp();
    EmployeeDto updateEmp(EmployeeDto employeeDto);
    String deleteEmployee(String partyId);
}
