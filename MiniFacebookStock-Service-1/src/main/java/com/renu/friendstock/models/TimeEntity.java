package com.renu.friendstock.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class TimeEntity<ID> {
	private String createdDate;
	private String lastModifiedDate;
	private String lastActivitiesTime;
	public abstract ID getId();

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

	@PrePersist
	public void prepersist() {
		Date currentDate = new Date();
		this.createdDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa").format(currentDate);
		this.lastModifiedDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa").format(currentDate);

	}

	@PreUpdate
	public void preUpdate() {
		Date currentDate = new Date();
		this.lastModifiedDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa").format(currentDate);
		this.lastActivitiesTime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa").format(currentDate);

	}
}
