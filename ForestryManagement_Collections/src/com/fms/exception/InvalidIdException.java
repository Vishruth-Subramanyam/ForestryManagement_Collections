package com.fms.exception;

@SuppressWarnings("serial")
public class InvalidIdException extends RuntimeException {
	
	public InvalidIdException(){
		System.out.println("Invalid, Only  positive numbers are allowed");
	}
	
	

}
