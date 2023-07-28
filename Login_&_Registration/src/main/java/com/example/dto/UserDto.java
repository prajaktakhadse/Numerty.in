package com.example.dto;

import org.hibernate.annotations.NotFound;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
	
	private Long uid;
	
	@NotFound
	@NotEmpty(message = "Name should not be empty or null, please provide valid name")
	private  String name;
	
	@Email(message = "Email address is not valid !!")
	@NotEmpty
	@Column(unique = true)
	private String email;
	
	@NotEmpty
	//@Size(min = 6 , max = 15 , message = "Password must be min of 6 chars and max of 15 chars !!") 
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}$")
	/**
	 where:
			^ represents starting character of the string.
			(?=.*[0-9]) represents a digit must occur at least once.
			(?=.*[a-z]) represents a lower case alphabet must occur at least once.
			(?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
			(?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
			(?=\\S+$) white spaces don’t allowed in the entire string.
			.{8, 20} represents at least 8 characters and at most 20 characters.
			$ represents the end of the string.
	**/
	private String password;
	
//	@Pattern(regexp = "\\\\d{10}|(?:\\\\d{3}-){2}\\\\d{4}|\\\\(\\\\d{3}\\\\)\\\\d{3}-?\\\\d{4}")
//	/*
//	 * \d{10} matches 1234567890
//	 *(?:\d{3}-){2}\d{4} matches 123-456-7890
//	 *\(\d{3}\)\d{3}-?\d{4} matches (123)456-7890 or (123)4567890
//    */
	private String contact;
}
