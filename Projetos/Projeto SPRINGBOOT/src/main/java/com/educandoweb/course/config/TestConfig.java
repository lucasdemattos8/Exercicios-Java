package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.OrderStatus;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category.CategoryBuilder()
				.setId(null)
				.setName("Eletronics")
				.build();
		
		Category cat2 = new Category.CategoryBuilder()
				.setId(null)
				.setName("Books")
				.build();
		
		Category cat3 = new Category.CategoryBuilder()
				.setId(null)
				.setName("Computers")
				.build();
				
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
		
		Order o1 = new Order.OrderBuilder()
				.setId(null)
				.setMoment(Instant.parse("2019-06-20T19:53:07Z"))
				.setOrderStatus(OrderStatus.PAID)
				.setClient(u1)
				.build();
		
		Order o2 = new Order.OrderBuilder()
				.setId(null)
				.setMoment(Instant.parse("2019-07-21T03:42:10Z"))
				.setOrderStatus(OrderStatus.WAITING_PAYMENT)
				.setClient(u2)
				.build();
		
		Order o3 = new Order.OrderBuilder()
				.setId(null)
				.setMoment(Instant.parse("2019-07-22T15:21:22Z"))
				.setOrderStatus(OrderStatus.WAITING_PAYMENT)
				.setClient(u1)
				.build();
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
}
