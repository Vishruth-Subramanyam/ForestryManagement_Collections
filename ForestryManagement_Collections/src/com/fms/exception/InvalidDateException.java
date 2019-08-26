package com.fms.exception;

@SuppressWarnings("serial")
public class InvalidDateException extends RuntimeException {
	
	public InvalidDateException(){
		System.out.println("Invalid date or wrong date format, date should be in 'dd/MM/yyyy' format");
		
	}

	public InvalidDateException(String message){
		System.out.println("Something went wrong while accepting/Parsing @ "+message+ "date should be in 'dd/MM/yyyy' format");
		
	}

}
