/*JOINED BEAN*/

package com.ust.model;

//Bean representing Class VendorContactPerson
public class VendorContactPerson {

	//instance variables
	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorLocation;
	private String vService;
	private int vPincode;
	private String vIsActive;
	private int contactId;
	private String contactName;
    private String pDepartment;
	private String pEmail;
	private String pPhone;
	private String pIsActive;
	
	//default constructor
	public VendorContactPerson() {
		super();
	}
	
	//parameterized constructor
	public VendorContactPerson(int vendorId, String vendorName,
			String vendorAddress, String vendorLocation, String vService,
			int vPincode, String vIsActive, int contactId, String contactName,
			String pDepartment, String pEmail, String pPhone, String pIsActive) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorLocation = vendorLocation;
		this.vService = vService;
		this.vPincode = vPincode;
		this.vIsActive = vIsActive;
		this.contactId = contactId;
		this.contactName = contactName;
		this.pDepartment = pDepartment;
		this.pEmail = pEmail;
		this.pPhone = pPhone;
		this.pIsActive = pIsActive;
	}
	
	//getters and setters
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
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getpDepartment() {
		return pDepartment;
	}
	public void setpDepartment(String pDepartment) {
		this.pDepartment = pDepartment;
	}
	public String getpEmail() {
		return pEmail;
	}
	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}
	public String getpPhone() {
		return pPhone;
	}
	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}
	public String getpIsActive() {
		return pIsActive;
	}
	public void setpIsActive(String pIsActive) {
		this.pIsActive = pIsActive;
	}
	
	//toString method
	@Override
	public String toString() {
		return "VendorContactPerson [vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", vendorAddress=" + vendorAddress
				+ ", vendorLocation=" + vendorLocation + ", vService="
				+ vService + ", vPincode=" + vPincode + ", vIsActive="
				+ vIsActive + ", contactId=" + contactId + ", contactName="
				+ contactName + ", pDepartment=" + pDepartment + ", pEmail="
				+ pEmail + ", pPhone=" + pPhone + ", pIsActive=" + pIsActive
				+ "]";
	}

	
}
