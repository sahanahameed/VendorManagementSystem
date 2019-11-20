/*BEAN VENDOR*/

package com.ust.model;

//Bean representing Class Vendor
public class Vendor {

	// instance variables
	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorLocation;
	private String vService;
	private int vPincode;
	private String vIsActive;

	// default constructor
	public Vendor() {
		super();
	}

	// parameterized constructor
	public Vendor(int vendorId, String vendorName, String vendorAddress,
			String vendorLocation, String vService, int vPincode,
			String vIsActive) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorLocation = vendorLocation;
		this.vService = vService;
		this.vPincode = vPincode;
		this.vIsActive = vIsActive;
	}

	// getters and setters
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorLocation() {
		return vendorLocation;
	}

	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}

	public String getvService() {
		return vService;
	}

	public void setvService(String vService) {
		this.vService = vService;
	}

	public int getvPincode() {
		return vPincode;
	}

	public void setvPincode(int vPincode) {
		this.vPincode = vPincode;
	}

	public String getvIsActive() {
		return vIsActive;
	}

	public void setvIsActive(String vIsActive) {
		this.vIsActive = vIsActive;
	}

	// toString method
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", vendorAddress=" + vendorAddress + ", vendorLocation="
				+ vendorLocation + ", vService=" + vService + ", vPincode="
				+ vPincode + ", vIsActive=" + vIsActive + "]";
	}

}
