package com.renu.zuul.models;

public class WebSiteAndSocialLink {
	private Long id;
	private String uid;
	private String webSiteAndSocialLink;
    private String createdDate;
    private String lastModifiedDate;

	public WebSiteAndSocialLink() {
	}

	public Long getId() {
		return id;
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

	public String getWebSiteAndSocialLink() {
		return webSiteAndSocialLink;
	}

	public void setWebSiteAndSocialLink(String webSiteAndSocialLink) {
		this.webSiteAndSocialLink = webSiteAndSocialLink;
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

	

}
