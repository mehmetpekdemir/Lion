package com.mehmetpekdemir.lion.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mehmetpekdemir.lion.dto.UserCreateDTO;
import com.mehmetpekdemir.lion.dto.UserViewDTO;
import com.mehmetpekdemir.lion.entity.User;
import com.mehmetpekdemir.lion.repository.UserRepository;
import com.mehmetpekdemir.lion.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor // Constructor Injection with lombok
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
		encodeThePassword(userCreateDTO); // Password encoded

		User user = userRepository.save(
				new User(userCreateDTO.getUsername(), userCreateDTO.getDisplayName(), userCreateDTO.getPassword()));

		return UserViewDTO.of(user);
	}

	private void encodeThePassword(UserCreateDTO userCreateDTO) {
		userCreateDTO.setPassword(this.passwordEncoder.encode(userCreateDTO.getPassword()));
	}
}
