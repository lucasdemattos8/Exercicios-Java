package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.OrderStatus;
import com.educandoweb.course.entities.Payment;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderItemRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

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
		
		Product p1 = new Product.ProductBuilder()
				.setId(null)
				.setName("The Lord of the Rings")
				.setDescription("Lorem ipsum dolor sit amet, consectetur.")
				.setPrice(90.5)
				.setImgUrl("")
				.build();
		
		Product p2 = new Product.ProductBuilder()
				.setId(null)
				.setName("Smart TV")
				.setDescription("Nulla eu imperdiet purus. Maecenas ante.")
				.setPrice(2190.0)
				.setImgUrl("")
				.build();
		
		Product p3 = new Product.ProductBuilder()
				.setId(null)
				.setName("Macbook Pro")
				.setDescription("Nam eleifend maximus tortor, at mollis.")
				.setPrice(1250.0)
				.setImgUrl("")
				.build();
		
		Product p4 = new Product.ProductBuilder()
				.setId(null)
				.setName("PC Gamer")
				.setDescription("Donec aliquet odio ac rhoncus cursus.")
				.setPrice(1200.0)
				.setImgUrl("")
				.build();
		
		Product p5 = new Product.ProductBuilder()
				.setId(null)
				.setName("Rails for Dummies")
				.setDescription("Cras fringilla convallis sem vel faucibus.")
				.setPrice(100.99)
				.setImgUrl("")
				.build();
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
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
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem.OrderItemBuilder()
				.setOrder(o1)
				.setProduct(p1)
				.setQuantity(2)
				.setPrice(p1.getPrice())
				.build();
		
		OrderItem oi2 = new OrderItem.OrderItemBuilder()
				.setOrder(o1)
				.setProduct(p3)
				.setQuantity(1)
				.setPrice(p3.getPrice())
				.build();
		
		OrderItem oi3 = new OrderItem.OrderItemBuilder()
				.setOrder(o2)
				.setProduct(p3)
				.setQuantity(2)
				.setPrice(p3.getPrice())
				.build();
		
		OrderItem oi4 = new OrderItem.OrderItemBuilder()
				.setOrder(o3)
				.setProduct(p5)
				.setQuantity(2)
				.setPrice(p5.getPrice())
				.build();
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment.PaymentBuilder()
				.setId(null)
				.setMoment(Instant.parse("2019-06-20T21:53:07Z"))
				.setOrder(o1)
				.build();
		
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	}
}
