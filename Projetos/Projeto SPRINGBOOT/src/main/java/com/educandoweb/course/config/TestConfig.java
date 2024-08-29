package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User.UserBuilder()
				.setId(null)
				.setName("Maria Brown")
				.setEmail("maria@gmail.com")
				.setPhone("988888888")
				.setPassword("123456")
				.build();
		
		User u2 = new User.UserBuilder()
				.setId(null)
				.setName("Alex Green")
				.setEmail("alex@gmail.com")
				.setPhone("977777777")
				.setPassword("123456")
				.build();
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}
