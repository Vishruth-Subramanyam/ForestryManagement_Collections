package com.fms.exception;
@SuppressWarnings("serial")
public class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException(){
		System.out.println("Invalid Password, special characters are not allowed at the begin and end of password");
		
	}
}
