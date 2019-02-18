package com.renu.friends.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class AddFriendsData extends TimeEntity<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//------------------------------------------------------------------------------------------------------------
	private String uid;
	private String userName;
	private String email;
	private String photoUrl;
	//-------------------------------------------------------------------------------------------------------------
	private String photoCode;
	//-------------------------------------------------------------------------------------------------------------
	private String basicInformation;
	
	//-------------------------------------------------------------------------------------------------------------
	private String college;
	
	//-------------------------------------------------------------------------------------------------------------
	private String contactInformation;
	
	//-------------------------------------------------------------------------------------------------------------
	private String currentCity;
	
	//-------------------------------------------------------------------------------------------------------------
	private String familyMembers;
	private String relation;
	
	//-------------------------------------------------------------------------------------------------------------
	private String favoriteQuote;
	
	//-------------------------------------------------------------------------------------------------------------
	private String highSchool;
	
	//-------------------------------------------------------------------------------------------------------------
	private String homeTown;
	
	//-------------------------------------------------------------------------------------------------------------
	private String otherPlacesLived;
	
	//-------------------------------------------------------------------------------------------------------------
	private String professionalSkill;
	
	//-------------------------------------------------------------------------------------------------------------
	private String relationShip;
	
	//-------------------------------------------------------------------------------------------------------------
	private String webSiteAndSocialLink;
	
	//-------------------------------------------------------------------------------------------------------------
	private String workPlace;

	//-------------------------------------------------------------------------------------------------------------
	
	
	public AddFriendsData() {}

	@Override
	public Long getId() {
		return id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoCode() {
		return photoCode;
	}

	public void setPhotoCode(String photoCode) {
		this.photoCode = photoCode;
	}

	public String getBasicInformation() {
		return basicInformation;
	}

	public void setBasicInformation(String basicInformation) {
		this.basicInformation = basicInformation;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(String familyMembers) {
		this.familyMembers = familyMembers;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getFavoriteQuote() {
		return favoriteQuote;
	}

	public void setFavoriteQuote(String favoriteQuote) {
		this.favoriteQuote = favoriteQuote;
	}

	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getOtherPlacesLived() {
		return otherPlacesLived;
	}

	public void setOtherPlacesLived(String otherPlacesLived) {
		this.otherPlacesLived = otherPlacesLived;
	}

	public String getProfessionalSkill() {
		return professionalSkill;
	}

	public void setProfessionalSkill(String professionalSkill) {
		this.professionalSkill = professionalSkill;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getWebSiteAndSocialLink() {
		return webSiteAndSocialLink;
	}

	public void setWebSiteAndSocialLink(String webSiteAndSocialLink) {
		this.webSiteAndSocialLink = webSiteAndSocialLink;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
}
