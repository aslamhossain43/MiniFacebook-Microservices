package com.renu.profilestock.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ProfilePhotosEntity extends BaseProfilePhotosEntity<Long> {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String uid;
private String photoCode;

public ProfilePhotosEntity() {}

@Override
public Long getId() {
	return id;
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

public void setId(Long id) {
	this.id = id;
}




}
