package com.example.demo;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				version = "v1.0",
				description = "My_Project",
				title = "My_Stu",
				contact = @Contact(
						email = "Mydear@gmail.com",
						url = "https:/1011/hi"

				)
				,
				license = @License(
						name = "boss",
						url = "boss//1010.com"
				)


		),
		externalDocs = @ExternalDocumentation(
				url = "http:1010/2022.com",
				description = "My_D"
		)
)
public class DemoProjectForEmploymentServiceApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectForEmploymentServiceApplication.class, args);
	}

}
