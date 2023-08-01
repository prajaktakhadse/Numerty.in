package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.User;
import com.example.model.UserNotFoundException;
import com.example.repo.UserRepo;


public class UserService {
	
	@Autowired
	private UserRepo repo;

	User createUSer(User user) {
		return  repo.save(user) ;
		
	}
	
	
	User loginUSer(Integer id , String email, String password) {
		Optional<User> uid = repo.findById(id);
		if(uid.isPresent()) {
			
		}
	}
}
