package com.example.demo.controller;

import com.example.demo.dto.APIDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createNewEmp(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmp=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);

    }

    @GetMapping("/get/{partyId}")
    public ResponseEntity<APIDto> getEmp(@PathVariable String partyId){
        APIDto savedEmp=employeeService.getEmployee(partyId);
        return new ResponseEntity<>(savedEmp, HttpStatus.ACCEPTED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmp( ){
        List<EmployeeDto> savedEmp=employeeService.getAllEmp();
        return new ResponseEntity<>(savedEmp, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{partyId}")
    public ResponseEntity<EmployeeDto> updateEmps(@PathVariable String partyId, @RequestBody EmployeeDto employeeDto ){
     employeeDto.setPartyId(partyId);
        EmployeeDto emp=employeeService.updateEmp(employeeDto);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

@DeleteMapping("/delete/{partyId}")
    public ResponseEntity<String> deleteEmps( @PathVariable String partyId){
        employeeService.deleteEmployee(partyId);
        return new ResponseEntity<>("deleted succesfully dear",HttpStatus.OK);
    }



}
