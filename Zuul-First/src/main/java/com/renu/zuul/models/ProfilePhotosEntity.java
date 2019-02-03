package com.renu.zuul.models;

public class ProfilePhotosEntity  {

private Long id;
private String uid;
private String photoCode;
private String createdDate;
private String lastModifiedDate;

public ProfilePhotosEntity() {}

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

public String getPhotoCode() {
	return photoCode;
}

public void setPhotoCode(String photoCode) {
	this.photoCode = photoCode;
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
