package com.renu.friendstock.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class User extends TimeEntity<Long>{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
		@OneToOne(cascade=CascadeType.ALL)
		private Friends friends;
public User() {}
@Override
public Long getId() {
	// TODO Auto-generated method stub
	return id;
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








}
