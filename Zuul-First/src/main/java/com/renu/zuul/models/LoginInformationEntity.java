package com.renu.zuul.models;


public class LoginInformationEntity {
	private Long id;
	private String uid;
	private String userName;
	private String email;
	private String photoUrl;
	private String createdDate;
	private String lastModifiedDate;
	private String lastActivitiesTime;
	public LoginInformationEntity() {}
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
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
	public String getLastActivitiesTime() {
		return lastActivitiesTime;
	}
	public void setLastActivitiesTime(String lastActivitiesTime) {
		this.lastActivitiesTime = lastActivitiesTime;
	}
	
	
	
}
