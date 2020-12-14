/**
 * Copyright ...
 */
package com.portal.business.tripplan.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import com.portal.business.tripplan.BusinessExceptions.BusinessExceptions;


/**
 * class contains common utility methods
 * @author kumar
 *
 */
public class CommonUtility extends BusinessExceptions{
    
	private static final long serialVersionUID = 1L;

	public static Map<String, String> loadLocations(String file) throws IOException {
	
		return  Files.lines(Paths.get(file))
			        .map(line -> line.split(BusinessContacts.COMMA_SEPERATOR))
			        .collect(Collectors.toMap(line -> line[0], line -> line[1]));		
		
	}
}
