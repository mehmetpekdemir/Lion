package com.mehmetpekdemir.lion.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mehmetpekdemir.lion.validator.FieldMatch;

import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@FieldMatch(first = "password", second = "confirmPassword", message = "{lion.constraint.password.FieldMatch.message}")
public class UserUpdateDTO {

	@NotNull(message = "{lion.constraint.displayname.NotNull.message}")
	@Size(min = 3, max = 32, message = "{lion.constraint.displayname.Size.message}")
	private String displayName;

	@NotNull(message = "{lion.constraint.password.NotNull.message}")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{lion.constraint.password.Pattern.message}")
	private String password;

	@NotNull(message = "{lion.constraint.confirmpassword.NotNull.message}")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{lion.constraint.confirmpassword.Pattern.message}")
	private String confirmPassword;

}
