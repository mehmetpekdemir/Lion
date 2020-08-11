package com.mehmetpekdemir.lion.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.lion.dto.UserCreateDTO;
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

	@PostMapping("v1/users")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
		userService.createUser(userCreateDTO);
		return ResponseEntity.ok(new GenericResponse("User Created"));
	}
}
