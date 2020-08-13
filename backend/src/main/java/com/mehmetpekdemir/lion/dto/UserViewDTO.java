package com.mehmetpekdemir.lion.dto;

import java.io.Serializable;

import com.mehmetpekdemir.lion.entity.User;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public final class UserViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Long id;
	private final String username;
	private final String displayName;

	private UserViewDTO(Long id, String username, String displayName) {
		this.id = id;
		this.username = username;
		this.displayName = displayName;
	}

	public static UserViewDTO of(User user) {
		return new UserViewDTO(user.getId(), user.getUsername(), user.getDisplayName());
	}

}
