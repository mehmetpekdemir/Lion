package com.mehmetpekdemir.lion.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.lion.dto.UserCreateDTO;
import com.mehmetpekdemir.lion.dto.UserViewDTO;
import com.mehmetpekdemir.lion.service.UserService;
import com.mehmetpekdemir.lion.util.GenericResponse;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor // Constructor Injection with lombok
public class UserController {

	private final UserService userService;

	// More Performance
	@GetMapping("v1/users/slice")
	public ResponseEntity<List<UserViewDTO>> sliceForUsers(Pageable pageable) {
		final List<UserViewDTO> users = userService.sliceForUsers(pageable);
		return ResponseEntity.ok(users);
	}

	@GetMapping("v1/user/{id}")
	public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) {
		final UserViewDTO user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping("v1/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
		userService.createUser(userCreateDTO);
		return ResponseEntity.ok(new GenericResponse("User Created"));
	}

}
