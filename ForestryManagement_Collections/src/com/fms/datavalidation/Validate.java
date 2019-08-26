package com.fms.datavalidation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fms.exception.InvalidDateException;
import com.fms.exception.InvalidEmailException;
//import com.fms.exception.InvalidIdException;
import com.fms.exception.InvalidNameException;
import com.fms.exception.InvalidPasswordException;
import com.fms.exception.InvalidTelephoneException;
import com.fms.exception.NullObjectException;


public class Validate {

	public Boolean IdValidation(String id) {
		Pattern pat = Pattern.compile("\\d+"); 
		Matcher mat = pat.matcher(id);
		if(mat.matches() && (Integer.parseInt(id)>=0)) {
			return true;
		}
		return false;
		

	}

	public Boolean telephoneValidation(Long id) throws InvalidTelephoneException {
		Pattern pat = Pattern.compile("[0-9]{1,10}"); 
		Matcher mat = pat.matcher(id.toString());
		if(mat.matches()) {
			return true;
		}
		throw new InvalidTelephoneException();

	}

	public Boolean NameValidation(String name) throws InvalidNameException {
		Pattern pat = Pattern.compile("[A-Za-z]{1,25}"); 
		Matcher mat = pat.matcher(name);
		if(mat.matches()) {
			return true;
		}
		throw new InvalidNameException();

	}



	public Boolean PasswordValidation(String password)throws InvalidPasswordException {
		Pattern pat = Pattern.compile("\\w+\\W+\\w+"); 
		Matcher mat = pat.matcher(password);
		if(mat.matches()) {
			return true;
		}
		throw new InvalidPasswordException();


	}

	public Boolean emailValidation(String email)throws InvalidEmailException {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+"); 
		Matcher mat = pat.matcher(email);
		if(mat.matches()) { 
			return true;
		}
		throw new InvalidEmailException();


	}

	public Boolean dateValidation(String date) throws InvalidDateException {
		Pattern pat = Pattern.compile("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"); 
		Matcher mat = pat.matcher(date);
		if(mat.matches()) { 
			return true;
		}
		throw new InvalidDateException();
	}

	public Boolean nullObjectValidation(Object object)  throws NullObjectException{
		
		if(object.equals(null)) {
			throw new NullObjectException(object.getClass().getSimpleName());
			
		}

		return true;

	}


}


