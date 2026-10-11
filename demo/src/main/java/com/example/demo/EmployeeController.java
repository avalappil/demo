package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

	@Value("${depoyment.env:}")
	private String s2;
	
	@GetMapping("/employees")
	public List<String> all() {
		List<String> employees = new ArrayList<>();
		for (int i =0;i<50;i++) {
			employees.add(UUID.randomUUID().toString());
		}
		return employees;
	}
	
	@GetMapping("/environment")
	public String environment() {
		return s2;
	}
	
	@GetMapping("/down")
	public String down() {
		TestHealthLoader.isHealthUp = false;
		return s2;
	}
}
