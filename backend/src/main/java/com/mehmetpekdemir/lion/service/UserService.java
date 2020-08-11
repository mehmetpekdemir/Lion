package com.mehmetpekdemir.lion.service;

import com.mehmetpekdemir.lion.dto.UserCreateDTO;
import com.mehmetpekdemir.lion.dto.UserViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface UserService {

	UserViewDTO createUser(UserCreateDTO userCreateDTO);

}
