package com.mehmetpekdemir.lion.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

	private static final Logger LOG = LoggerFactory.getLogger(FieldMatchValidator.class);

	private String errorMessage;
	private String firstFieldName;
	private String secondFieldName;

	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		errorMessage = constraintAnnotation.message();
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		final BeanWrapperImpl bean = new BeanWrapperImpl(value);
		final Object firstObj = bean.getPropertyValue(firstFieldName);
		final Object secondObj = bean.getPropertyValue(secondFieldName);

		boolean returnValue = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
		try {
			if (!returnValue) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(secondFieldName)
						.addConstraintViolation();
			}
			return returnValue;
		} catch (final Exception ignore) {
			LOG.info(ignore.getMessage());
		}

		return true;
	}

}
