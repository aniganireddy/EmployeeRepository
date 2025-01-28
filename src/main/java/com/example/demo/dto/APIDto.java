package com.example.demo.dto;

import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIDto {
    public DepartmentDto departmentDto;
    public EmployeeDto employeeDto;
}
