package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User.UserBuilder()
				.setId(2L)
				.setName("Maria")
				.setEmail("maria@gmail.com")
				.setPassword("123456B")
				.setPhone("51912234512")
				.build();
		return ResponseEntity.ok().body(user);
	}

}
