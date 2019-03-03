package com.renu.zuul.friends.models;

public class Friends{
	private Long id;
    private String fromUid;
   private String toUid;
	private String fromAgree;
	private String toAgree;
	private User user;
	public Friends() {}

	

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



	public Long getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
	
}
