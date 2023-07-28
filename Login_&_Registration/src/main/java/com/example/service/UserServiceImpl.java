package com.example.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUSer(UserDto user) {
		// TODO Auto-generated method stub
		User u = this.modelMapper.map(user, User.class);
	   User addUser = 	this.repo.save(u);
	   return this.modelMapper.map(addUser,UserDto.class );
	}

}
