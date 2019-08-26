package com.fms.exception;
@SuppressWarnings("serial")
public class InvalidTelephoneException extends RuntimeException {
	public InvalidTelephoneException() {
		// TODO Auto-generated constructor stub
		System.out.println("Invalid ID, only Numbers are allowed");
	}
}
