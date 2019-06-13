package com.example.demo.validators;

import org.springframework.util.StringUtils;

public class ValidationsAddNewUser {

	private static String errorMessage;
	private static boolean isOk;

	public static boolean validate(long id, String name, String lastName, String age) {
		isOk = true;
		errorMessage = "";
		
		if (StringUtils.isEmpty(name)) {
			isOk = false;
			errorMessage += "The field name can not be empty or blank \r\n";
		} else {
			isOk = true;
		}
		if (StringUtils.isEmpty(lastName)) {
			isOk = false;
			errorMessage += "The field lasName can not be empty or blank \r\n";
		} else {
			isOk =  true;
		}
		if (StringUtils.isEmpty(age)) {
			isOk = false;
			errorMessage += "The field age can not be empty or blank \r\n";
		} else {
			isOk = true;
		}
		
		if (isOk) { 
			return true;
			}
			else {
				throw new NullPointerException(errorMessage);
			}
	}
	
	

}
