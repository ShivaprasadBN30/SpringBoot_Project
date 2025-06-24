package com.project.Theatre_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String addressPlotNumber;
	private String addressStreet;
	private String addressLandmark;
	private String addressState;
	private int addressPincode;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressPlotNumber() {
		return addressPlotNumber;
	}
	public void setAddressPlotNumber(String addressPlotNumber) {
		this.addressPlotNumber = addressPlotNumber;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressLandmark() {
		return addressLandmark;
	}
	public void setAddressLandmark(String addressLandmark) {
		this.addressLandmark = addressLandmark;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public int getAddressPincode() {
		return addressPincode;
	}
	public void setAddressPincode(int addressPincode) {
		this.addressPincode = addressPincode;
	}
	
}
