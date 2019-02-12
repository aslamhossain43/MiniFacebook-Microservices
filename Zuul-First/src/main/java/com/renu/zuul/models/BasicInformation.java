package com.renu.zuul.models;

public class BasicInformation {

	private Long id;
	private String uid;
	private String basicInformation;
    private String createdDate;
    private String lastModifiedDate;

	public BasicInformation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBasicInformation() {
		return basicInformation;
	}

	public void setBasicInformation(String basicInformation) {
		this.basicInformation = basicInformation;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	

}
