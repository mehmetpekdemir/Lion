package com.mehmetpekdemir.lion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.lion.entity.User;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	boolean existsUserByUsername(String username);

}
