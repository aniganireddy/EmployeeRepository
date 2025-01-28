package com.example.demo.service;

import com.example.demo.dto.APIDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.image.RescaleOp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

   @Autowired
   private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setPartyId(Employee.getParties());
        Employee savedEmp=employeeRepository.save(employee);
        return modelMapper.map(savedEmp, EmployeeDto.class);


    }

    @Override
    public APIDto getEmployee(String partyId) {
        Optional<Employee> existingEmp=employeeRepository.findByPartyId(partyId);
        if(!existingEmp.isPresent()){
            throw new EmployeeNotFoundException("Employee Not exists buddy");
        }

        ResponseEntity<DepartmentDto>responseEntity=restTemplate.getForEntity("http://localhost:8083/department/" + partyId, DepartmentDto.class);
        DepartmentDto departmentDto=  responseEntity.getBody();

       EmployeeDto employeeDto=modelMapper.map(existingEmp,EmployeeDto.class);
        APIDto apiDto = new APIDto();
        apiDto.setEmployeeDto(employeeDto);
        apiDto.setDepartmentDto(departmentDto);
        return  apiDto;

    }

    @Override
    public List<EmployeeDto> getAllEmp() {
        List<Employee> existing =employeeRepository.findAll();
       return existing.stream().map(e -> modelMapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmp(EmployeeDto employeeDto) {
       Optional<Employee> existing= employeeRepository.findByPartyId(employeeDto.getPartyId());
        if(!existing.isPresent()){
            throw new EmployeeNotFoundException("Employee Not exists buddy");
        }
        existing.get().setFirstName(employeeDto.getFirstName());
        existing.get().setLastName(employeeDto.getLastName());
        existing.get().setEmail(employeeDto.getEmail());
        Employee saved=employeeRepository.save(existing.get());
        return modelMapper.map(saved, EmployeeDto.class);

    }

    @Override
    public String deleteEmployee(String partyId) {
        Optional<Employee> existing= employeeRepository.findByPartyId(partyId);
        if(!existing.isPresent()){
            throw new EmployeeNotFoundException("Employee Not exists buddy");
        }
        employeeRepository.deleteByPartyId(partyId);
        return null;
    }
}
