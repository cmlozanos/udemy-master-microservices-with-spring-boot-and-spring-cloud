package com.example.user.bean;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id;
	
	@Size(min = 2, message="Name should have atleast 2 characters")
	private String name;
	
	@Past
	private LocalDate birthDate;
}
