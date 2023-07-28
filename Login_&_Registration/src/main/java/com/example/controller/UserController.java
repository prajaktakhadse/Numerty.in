package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/Register/")
	public ResponseEntity<UserDto> RegisterUser(@Valid @RequestBody UserDto userDto){
		UserDto createUSer = this.service.createUSer(userDto);
		return new ResponseEntity<UserDto>(createUSer , HttpStatus.OK);
	}
}

