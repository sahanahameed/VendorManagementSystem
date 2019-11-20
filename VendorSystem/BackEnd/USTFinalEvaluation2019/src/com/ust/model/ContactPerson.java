/*BEAN CONTACTPERSON*/

package com.ust.model;

//Bean representing ContactPerson
public class ContactPerson {

	// instance variables
	private int contactId;
	private String contactName;
	private int vendorId;
	private String pDepartment;
	private String pEmail;
	private String pPhone;
	private String pIsActive;

	// default constructor
	public ContactPerson() {
		super();
	}

	// parameterized constructor
	public ContactPerson(int contactId, String contactName, int vendorId,
			String pDepartment, String pEmail, String pPhone, String pIsActive) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.vendorId = vendorId;
		this.pDepartment = pDepartment;
		this.pEmail = pEmail;
		this.pPhone = pPhone;
		this.pIsActive = pIsActive;
	}

	// getters and setters
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

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
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

	// toString Method
	@Override
	public String toString() {
		return "ContactPerson [contactId=" + contactId + ", contactName="
				+ contactName + ", vendorId=" + vendorId + ", pDepartment="
				+ pDepartment + ", pEmail=" + pEmail + ", pPhone=" + pPhone
				+ ", pIsActive=" + pIsActive + "]";
	}

}
