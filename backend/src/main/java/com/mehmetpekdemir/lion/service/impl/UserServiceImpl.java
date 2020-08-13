package com.mehmetpekdemir.lion.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mehmetpekdemir.lion.dto.UserCreateDTO;
import com.mehmetpekdemir.lion.dto.UserViewDTO;
import com.mehmetpekdemir.lion.entity.User;
import com.mehmetpekdemir.lion.error.NotFoundException;
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
	public List<UserViewDTO> sliceForUsers(Pageable pageable) {
		return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
	}

	@Override
	public UserViewDTO getUserById(Long id) {
		final User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("User not found with id %d", id)));
		return UserViewDTO.of(user);
	}

	@Override
	public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
		encodeThePassword(userCreateDTO); // Password encoded
		final User user = userRepository.save(
				new User(userCreateDTO.getUsername(), userCreateDTO.getDisplayName(), userCreateDTO.getPassword()));

		return UserViewDTO.of(user);
	}

	private void encodeThePassword(UserCreateDTO userCreateDTO) {
		userCreateDTO.setPassword(this.passwordEncoder.encode(userCreateDTO.getPassword()));
	}

}
