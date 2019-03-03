package com.renu.about.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OtherPlacesLived extends TimeEntity<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String uid;
	private String otherPlacesLived;
	
	public OtherPlacesLived() {}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getOtherPlacesLived() {
		return otherPlacesLived;
	}

	public void setOtherPlacesLived(String otherPlacesLived) {
		this.otherPlacesLived = otherPlacesLived;
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
