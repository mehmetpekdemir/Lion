package com.mehmetpekdemir.lion.util;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Retention(RUNTIME)
@Target(ElementType.PARAMETER)
@AuthenticationPrincipal
public @interface CurrentUser {

}
