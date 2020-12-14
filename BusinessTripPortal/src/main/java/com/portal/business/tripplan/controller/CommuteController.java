/**
 * Copyright ...
 */
package com.portal.business.tripplan.controller;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.business.tripplan.BusinessExceptions.BusinessExceptions;
import com.portal.business.tripplan.util.BusinessContacts;
import com.portal.business.tripplan.util.CommonUtility;


/**
 * This class has end point which sends a response with the status based on origin and destination  
 * @author kumar
 *
 */

@RestController
public class CommuteController {
	
	Logger logger = LoggerFactory.getLogger(CommuteController.class);
	
	@Value("${spring.profiles.active}")
	String pipeline;
	
	@Value("${source.content}")
	String inputFile;

	/**
	 * end point for destination search
	 * @param origin
	 * @param destination
	 * @return String
	 */
	@ExceptionHandler(value = BusinessExceptions.class)
	@RequestMapping(path = "/connected", method = RequestMethod.GET)
	public String search(@RequestParam String origin,@RequestParam String destination) {
		
		logger.info("environment::"+pipeline+":input file::"+inputFile);
		Boolean isMatch = Boolean.FALSE;
		
		String response = "";
		try {
			Map<String, String> sourceDestMap = CommonUtility.loadLocations(inputFile);
		
			isMatch = 	 sourceDestMap.entrySet().stream().anyMatch(entry -> {
	                String aKey= entry.getKey();
		            String aValue = entry.getValue();
	                if (aKey.equalsIgnoreCase(origin.trim()) && aValue.equalsIgnoreCase(destination.trim())
	                		|| aKey.equalsIgnoreCase(destination.trim()) && aValue.equalsIgnoreCase(origin.trim())) {//check for source to destination and vice versa
	                     return  true;
	                  }
	                  return false;
	                  }
	             );
			if(isMatch) {
				response = BusinessContacts.RESPONSE_YES;
			}else {
				response = BusinessContacts.RESPONSE_NO;
			}
		    }catch (IOException e) { 
		    	return new BusinessExceptions().citiesFileNotFoundException(inputFile);
		   }
		return response;
	
	}
   
}
