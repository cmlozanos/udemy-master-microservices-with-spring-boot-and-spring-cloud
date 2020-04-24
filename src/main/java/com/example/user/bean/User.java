package com.example.user.bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.example.post.bean.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2, message="Name should have atleast 2 characters")
	private String name;
	
	@Past
	private LocalDate birthDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;
}
