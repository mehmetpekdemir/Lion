package com.mehmetpekdemir.lion.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.lion.dto.UserCreateDTO;
import com.mehmetpekdemir.lion.dto.UserViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface UserService {

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	List<UserViewDTO> sliceForUsers(Pageable pageable);
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	UserViewDTO getUserById(Long id);

	UserViewDTO createUser(UserCreateDTO userCreateDTO);

	

}
