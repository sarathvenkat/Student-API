/**
 * 
 */
package com.jpmc.crs.model;

/**
 * @author Administrator
 *
 */
public class Address {

	private String doorNo;
	private String street;
	private Long pinCode;
	
	/**
	 * @param doorNo
	 * @param street
	 * @param pinCode
	 */
	public Address(String doorNo, String street, Long pinCode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.pinCode = pinCode;
	}
	/**
	 * @return the doorNo
	 */
	public String getDoorNo() {
		return doorNo;
	}
	/**
	 * @param doorNo the doorNo to set
	 */
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the pinCode
	 */
	public Long getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}	
	
}
