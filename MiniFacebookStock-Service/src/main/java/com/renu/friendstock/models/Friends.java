package com.renu.friendstock.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Friends extends TimeEntity<Long>{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String fromUid;
   private String toUid;
	private String fromAgree;
	private String toAgree;
	@OneToOne(mappedBy="friends")
	private User user;
	public Friends() {}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	
	
	
}
