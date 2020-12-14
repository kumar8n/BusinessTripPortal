package com.portal.business.tripplan.BusinessExceptions;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.portal.business.tripplan.util.BusinessContacts;


/**
 * Business Exceptions
 * @author kumar
 *
 */
@ControllerAdvice(basePackages = "com.portal.business.tripplan")
public class BusinessExceptions extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Business exception if input file not found
	 * @param location
	 * @return String
	 */
	@ExceptionHandler(FileNotFoundException.class)
	public String  citiesFileNotFoundException(String location) {
		return BusinessContacts.INPUT_FILE_NOT_FOUND;
		
    }
}
