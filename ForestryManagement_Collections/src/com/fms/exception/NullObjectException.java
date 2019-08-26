package com.fms.exception;

@SuppressWarnings("serial")
public class NullObjectException extends RuntimeException{
	public NullObjectException(String message) {
		System.out.println("something went Wrong; object returns NULL @  "+ message);
	}
	
}
