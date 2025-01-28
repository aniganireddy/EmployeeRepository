package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PrivateKey;
import java.util.Random;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")

public class Employee {
    @Id
    private String id;
    private String partyId;
    private String firstName;
    private String lastName;
    private String email;





    public static String getParties(){
        Random random = new Random();
      int id= 100000000+ random.nextInt(900000000);
      return String.valueOf(id);
    }
}
