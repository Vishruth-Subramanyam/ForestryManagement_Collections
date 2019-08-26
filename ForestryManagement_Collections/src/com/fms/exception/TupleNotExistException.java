package com.fms.exception;
@SuppressWarnings("serial")
public class TupleNotExistException extends RuntimeException{

	public TupleNotExistException() {
		System.out.println("Sorry No data found,Check provided Credentials May not be correct ");
	}
}
