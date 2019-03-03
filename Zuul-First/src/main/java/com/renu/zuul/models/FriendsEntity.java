package com.renu.zuul.models;


public class FriendsEntity{
	private Long id;
    private String fromUid;
   private String toUid;
	private String fromAgree;
	private String toAgree;
	 private String createdDate;
	    private String lastModifiedDate;
       private String lastActivitiesTime;
	public FriendsEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLastActivitiesTime() {
		return lastActivitiesTime;
	}

	public void setLastActivitiesTime(String lastActivitiesTime) {
		this.lastActivitiesTime = lastActivitiesTime;
	}

	
}
