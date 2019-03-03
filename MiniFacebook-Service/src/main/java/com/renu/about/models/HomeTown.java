package com.renu.about.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HomeTown extends TimeEntity<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String uid;
	private String homeTown;
	public HomeTown() {}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
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
	
	
	
}
