/**
 * Copyright ...
 */
package com.portal.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.portal.business.tripplan.controller.CommuteController;
/**
 * springboot application for connecting series of roads that can be traveled from one city to another 
 * @author kumar
 *
 */
@SpringBootApplication
public class BusinessTripPortalApplication {
	
	Logger logger = LoggerFactory.getLogger(BusinessTripPortalApplication.class);

	@Autowired
	CommuteController  commuteController;	
	
	public static void main(String[] args) {
		SpringApplication.run(BusinessTripPortalApplication.class, args);
	}
}
