package com.fms.beans;

public class Address {
	private String flatNumber;
	private String streetAddress;
	private String townCity;
	private String State;
	private Integer postCode;
	private String country;
	
	
	public String getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getTownCity() {
		return townCity;
	}
	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Integer getPostCode() {
		return postCode;
	}
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [flatNumber=" + flatNumber + ", streetAddress=" + streetAddress + ", townCity=" + townCity
				+ ", State=" + State + ", postCode=" + postCode + ", country=" + country + "]";
	}
	
	

}
