package com.fms.exception;

@SuppressWarnings("serial")
public class TupleExistsException  extends RuntimeException{
	public TupleExistsException(String message) {
		System.out.println("Sorry, Entered ID"+ message +" already in USE, Try something other");
	}

}
