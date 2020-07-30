package com.mehmetpekdemir.lion.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mehmetpekdemir.lion.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RequiredArgsConstructor //Constructor Injection with lombok
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

	private final UserRepository userRepository;

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return !userRepository.existsUserByUsername(username);
	}

}
