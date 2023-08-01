package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> fingByLoginAndPassword(String login, String Password);
	Optional<User> findByFirstbyLogin(String login);
	
}
