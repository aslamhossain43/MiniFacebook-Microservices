package com.renu.zuul.models;

public class FavoriteQoutes {

	private String uid;
	private String favoriteQuote;

	public FavoriteQoutes() {
	}

	public String getFavoriteQuote() {
		return favoriteQuote;
	}

	public void setFavoriteQuote(String favoriteQuote) {
		this.favoriteQuote = favoriteQuote;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
