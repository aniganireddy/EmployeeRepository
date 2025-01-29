package com.example.demo.clients;

import com.example.demo.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8083/",value = "my-project")
public interface APIClients {

    @GetMapping("/department/{partyId}")
    public DepartmentDto getDepartmentRecord(@PathVariable String partyId);

}
