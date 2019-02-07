package com.renu.zuul.models;

public class ContactInformation {

	private String uid;
	private String contactInformation;

	public ContactInformation() {
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
