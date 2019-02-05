package com.renu.about.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WebSiteAndSocialLink extends TimeEntity<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String uid;
	private String webSiteAndSocialLink;
	public WebSiteAndSocialLink() {}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getWebSiteAndSocialLink() {
		return webSiteAndSocialLink;
	}
	public void setWebSiteAndSocialLink(String webSiteAndSocialLink) {
		this.webSiteAndSocialLink = webSiteAndSocialLink;
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
