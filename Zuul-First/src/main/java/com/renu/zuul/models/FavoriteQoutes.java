package com.renu.zuul.models;

public class FavoriteQoutes {

	private Long id;
	private String uid;
	private String favoriteQuote;
    private String createdDate;
    private String lastModifiedDate;

	public FavoriteQoutes() {
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

	public String getFavoriteQuote() {
		return favoriteQuote;
	}

	public void setFavoriteQuote(String favoriteQuote) {
		this.favoriteQuote = favoriteQuote;
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
