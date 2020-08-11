package com.mehmetpekdemir.lion.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.lion.dto.UserViewDTO;
import com.mehmetpekdemir.lion.entity.User;
import com.mehmetpekdemir.lion.util.CurrentUser;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
public class AuthController {

	@PostMapping("v1/auth")
	public ResponseEntity<?> handleAuthentication(@CurrentUser User user) {
		return ResponseEntity.ok().body(UserViewDTO.of(user));
	}

}
