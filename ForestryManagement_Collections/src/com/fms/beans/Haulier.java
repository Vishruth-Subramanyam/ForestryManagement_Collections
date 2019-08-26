package com.fms.beans;

public class Haulier {
	private Integer haulierId;
	private String haulierName;
	private Address address;
	private Long telephoneNo;
	private String email;
	
	
	@Override
	public String toString() {
		return "Haulier [haulierId=" + haulierId + ", haulierName=" + haulierName + ", address=" + address
				+ ", telephoneNo=" + telephoneNo + ", email=" + email + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(Integer haulierId) {
		this.haulierId = haulierId;
	}
	public String getHaulierName() {
		return haulierName;
	}
	public void setHaulierName(String haulierName) {
		this.haulierName = haulierName;
	}
	
	public Long getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(Long telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
