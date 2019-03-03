package com.renu.zuul.friends.models;

public class User{
	private Long id;
	//------------------------------------------------------------------------------------------------------------
	private String uid;
	private String userName;
	private String email;
	private String photoUrl;
	//-------------------------------------------------------------------------------------------------------------
	private String photoCode;
	//-------------------------------------------------------------------------------------------------------------
		private String workPlace;
		private Friends friends;
public User() {}

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
public String getPhotoCode() {
	return photoCode;
}
public void setPhotoCode(String photoCode) {
	this.photoCode = photoCode;
}
public String getWorkPlace() {
	return workPlace;
}
public void setWorkPlace(String workPlace) {
	this.workPlace = workPlace;
}
public Friends getFriends() {
	return friends;
}
public void setFriends(Friends friends) {
	this.friends = friends;
}
public void setId(Long id) {
	this.id = id;
}

public Long getId() {
	return id;
}








}
