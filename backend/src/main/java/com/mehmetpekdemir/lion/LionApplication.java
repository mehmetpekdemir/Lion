package com.mehmetpekdemir.lion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mehmetpekdemir.lion.dto.UserCreateDTO;
import com.mehmetpekdemir.lion.service.UserService;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootApplication
public class LionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LionApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
			UserCreateDTO user = new UserCreateDTO();
			user.setUsername("User1");
			user.setDisplayName("Display1");
			user.setPassword("P4ssword");
			user.setConfirmPassword("P4ssword");
			userService.createUser(user);

			UserCreateDTO user2 = new UserCreateDTO();
			user2.setUsername("User2");
			user2.setDisplayName("Display2");
			user2.setPassword("P4ssword2");
			user2.setConfirmPassword("P4ssword2");
			userService.createUser(user2);

			UserCreateDTO user3 = new UserCreateDTO();
			user3.setUsername("User3");
			user3.setDisplayName("Display3");
			user3.setPassword("P4ssword3");
			user3.setConfirmPassword("P4ssword3");
			userService.createUser(user3);
		};

	}

}
