package com.fms.exception;

@SuppressWarnings("serial")
public class InvalidEmailException extends RuntimeException {
	public InvalidEmailException(){
		System.out.println("Invalid E-mail, email should be like alphaNumeric@domainName.com");
	}

}
