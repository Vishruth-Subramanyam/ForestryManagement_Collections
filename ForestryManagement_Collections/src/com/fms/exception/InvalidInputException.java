package com.fms.exception;
@SuppressWarnings("serial")
public class InvalidInputException extends RuntimeException {

	public InvalidInputException() {
		System.out.println("Invalid input: only numbers are allowed");
	}
	
	public InvalidInputException(String message) {
		System.out.println("Invalid input: something went Wrong while accepting/parsing input @ "+ message);
	}
	
	
	
}
