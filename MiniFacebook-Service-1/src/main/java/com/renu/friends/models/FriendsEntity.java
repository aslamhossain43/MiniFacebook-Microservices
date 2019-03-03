package com.renu.friends.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class FriendsEntity extends TimeEntity<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String fromUid;
   private String toUid;
	private String fromAgree;
	private String toAgree;
	public FriendsEntity() {}
	@Override
	public Long getId() {
		return id;
	}
	public String getFromUid() {
		return fromUid;
	}
	public void setFromUid(String fromUid) {
		this.fromUid = fromUid;
	}
	public String getToUid() {
		return toUid;
	}
	public void setToUid(String toUid) {
		this.toUid = toUid;
	}
	public String getFromAgree() {
		return fromAgree;
	}
	public void setFromAgree(String fromAgree) {
		this.fromAgree = fromAgree;
	}
	public String getToAgree() {
		return toAgree;
	}
	public void setToAgree(String toAgree) {
		this.toAgree = toAgree;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
