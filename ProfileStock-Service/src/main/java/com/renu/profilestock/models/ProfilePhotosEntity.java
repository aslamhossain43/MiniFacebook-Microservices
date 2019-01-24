package com.renu.profilestock.models;

public class ProfilePhotosEntity {
private String uid;
private String photoCode;
public ProfilePhotosEntity() {}
public String getUid() {
	return uid;
}

public ProfilePhotosEntity(String uid, String photoCode) {
	super();
	this.uid = uid;
	this.photoCode = photoCode;
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
@Override
public String toString() {
	return "ProfilePhotosEntity [uid=" + uid + ", photoCode=" + photoCode + "]";
}




}
