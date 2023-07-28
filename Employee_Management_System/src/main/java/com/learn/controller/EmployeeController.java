package com.learn.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.exception.ResourceNotFoundException;
import com.learn.model.Employee;
import com.learn.repository.EmployeeRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	//get all employees
	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	//create employee rest api
	@PostMapping("/saveEmp/")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	
	//update the employee by id
	@PutMapping("/updateEmpId/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee emp = employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));
		emp.setFirstName(employeeDetails.getFirstName());
		emp.setLastName(employeeDetails.getLastName());
		emp.setEmailId(employeeDetails.getEmailId());
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}
	

	//get the employee by id
	@GetMapping("/getEmpById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee emp = employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deltEmp(@PathVariable Long id) {
		employeeRepo.deleteById(id);
		return "Employee has been successfully deleted...!!!";
	}
}
