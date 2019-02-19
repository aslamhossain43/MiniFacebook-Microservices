package com.renu.friendstock.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.friendstock.config.RibbonConfiguration;
import com.renu.friendstock.models.AddFriendsData;
import com.renu.friendstock.repositories.AddFriendsDataRepository;


@RestController
@RequestMapping(value="/friends/smalldata")
@RibbonClient(name="small-data-ribbon",configuration = RibbonConfiguration.class)
public class AddFriendsDataController {
private static final Logger LOGGER=LoggerFactory.getLogger(AddFriendsDataController.class);
//----------------------------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;
//----------------------------------------------------------------------------------------------------------------
private static final String ADD_SMALL_DATA="http://friends-service/friends/smalldata/add";
private static final String GET_ALL_ADD_FRIENDS_DATA="http://friends-service/friends/smalldata/getAll";

@Autowired
AddFriendsDataRepository addFriendsDataRepository;
//----------------------------------------------------------------------------------------------------------------
@HystrixCommand(fallbackMethod="fallBackAddSmallData")
@RequestMapping(value="/add")
public ResponseEntity<AddFriendsData>addSmallData(@RequestBody AddFriendsData addFriendsData){
	LOGGER.info("From class AddFriendsDataController,method : addSmallData() ---ENTER-----");
	AddFriendsData addFriendsData2=restTemplate.postForObject(ADD_SMALL_DATA, addFriendsData, AddFriendsData.class);
	LOGGER.info("From class AddFriendsDataController,method : addSmallData() ---REST TEMPLATE-COMPLETED-----");
	
	return ResponseEntity.ok().body(addFriendsData2);
}

public ResponseEntity<AddFriendsData>fallBackAddSmallData(@RequestBody AddFriendsData addFriendsData) {
	
	LOGGER.info("From class AddFriendsDataController,method : fallBackAddSmallData() ---ENTER-----");
	AddFriendsData getByUid=addFriendsDataRepository.getByUid(addFriendsData.getUid());
	if (getByUid==null) {
		if (addFriendsData.getUid()!=null) {
			addFriendsDataRepository.save(addFriendsData);
			LOGGER.info("From class AddFriendsDataController,method : fallBackAddSmallData() ---FIRST-SUCCESS-----");
			
		}
	} else {

	
	
	//------------------------------
	getByUid.setId(getByUid.getId());
	getByUid.setUid(getByUid.getUid());
	if (addFriendsData.getUserName()!=null) {
		getByUid.setUserName(addFriendsData.getUserName());
		
	} else {
		getByUid.setUserName(getByUid.getUserName());

	}
	if (addFriendsData.getEmail()!=null) {
		getByUid.setEmail(addFriendsData.getEmail());
		
	} else {
getByUid.setEmail(getByUid.getEmail());
	}
	if (addFriendsData.getPhotoUrl()!=null) {
		getByUid.setPhotoUrl(addFriendsData.getPhotoUrl());
		
	} else {
		getByUid.setPhotoUrl(getByUid.getPhotoUrl());

	}
	//-------------------------------
	if (addFriendsData.getPhotoCode()!=null) {
		getByUid.setPhotoCode(addFriendsData.getPhotoCode());
		
	} else {
		getByUid.setPhotoCode(getByUid.getPhotoCode());

	}
	//-------------------------------
	if (addFriendsData.getBasicInformation()!=null) {
		getByUid.setBasicInformation(addFriendsData.getBasicInformation());
		
	} else {
		getByUid.setBasicInformation(getByUid.getBasicInformation());

	}
	//--------------------------------
	if (addFriendsData.getCollege()!=null) {
		getByUid.setCollege(addFriendsData.getCollege());
		
	} else {
		getByUid.setCollege(getByUid.getCollege());

	}
	//--------------------------------
	if (addFriendsData.getContactInformation()!=null) {
		getByUid.setContactInformation(addFriendsData.getContactInformation());
		
	} else {
		getByUid.setContactInformation(getByUid.getContactInformation());

	}
	//--------------------------------
	if (addFriendsData.getCurrentCity()!=null) {
		getByUid.setCurrentCity(addFriendsData.getCurrentCity());
		
	} else {
		getByUid.setCurrentCity(getByUid.getCurrentCity());

	}
	//--------------------------------
	if (addFriendsData.getFamilyMembers()!=null) {
		getByUid.setFamilyMembers(addFriendsData.getFamilyMembers());
		
	} else {
		getByUid.setFamilyMembers(getByUid.getFamilyMembers());

	}
	if (addFriendsData.getRelation()!=null) {
		getByUid.setRelation(addFriendsData.getRelation());
		
	} else {
		getByUid.setRelation(getByUid.getRelation());

	}
	//--------------------------------
	if (addFriendsData.getFavoriteQuote()!=null) {
		getByUid.setFavoriteQuote(addFriendsData.getFavoriteQuote());
		
	} else {
		getByUid.setFavoriteQuote(getByUid.getFavoriteQuote());

	}
	//-------------------------------
	if (addFriendsData.getHighSchool()!=null) {
		getByUid.setHighSchool(addFriendsData.getHighSchool());
		
	} else {
		getByUid.setHighSchool(getByUid.getHighSchool());

	}
	//-------------------------------
	if (addFriendsData.getHomeTown()!=null) {
		getByUid.setHomeTown(addFriendsData.getHomeTown());
		
	} else {
		getByUid.setHomeTown(getByUid.getHomeTown());

	}
	//-------------------------------
	if (addFriendsData.getOtherPlacesLived()!=null) {
		getByUid.setOtherPlacesLived(addFriendsData.getOtherPlacesLived());
		
	} else {
		getByUid.setOtherPlacesLived(getByUid.getOtherPlacesLived());

	}
	//-------------------------------
	if (addFriendsData.getProfessionalSkill()!=null) {
		getByUid.setProfessionalSkill(addFriendsData.getProfessionalSkill());
		
	} else {
		getByUid.setProfessionalSkill(getByUid.getProfessionalSkill());

	}
	//-------------------------------
	if (addFriendsData.getRelationShip()!=null) {
		getByUid.setRelationShip(addFriendsData.getRelationShip());
		
	} else {
		getByUid.setRelationShip(getByUid.getRelationShip());

	}
	//-------------------------------
	if (addFriendsData.getWebSiteAndSocialLink()!=null) {
		getByUid.setWebSiteAndSocialLink(addFriendsData.getWebSiteAndSocialLink());
		
	} else {
		getByUid.setWebSiteAndSocialLink(getByUid.getWebSiteAndSocialLink());

	}
	//-------------------------------
	if (addFriendsData.getWorkPlace()!=null) {
		getByUid.setWorkPlace(addFriendsData.getWorkPlace());
		
	} else {
		getByUid.setWorkPlace(getByUid.getWorkPlace());

	}
	//-------------------------------
		getByUid.setCreatedDate(getByUid.getCreatedDate());
	getByUid.setLastModifiedDate(addFriendsData.getLastModifiedDate());
	getByUid.setLastActivitiesTime(addFriendsData.getLastActivitiesTime());
	//-------------------------------
	addFriendsDataRepository.save(getByUid);
	LOGGER.info("From class AddFriendsDataController,method : addSmallData() ---UPDATE-SUCCESS-----");
	
	
	
	}
	
	
	return ResponseEntity.ok().body(addFriendsData);
}
//--------------------------------------------------------------------------------------------------------------------
@HystrixCommand(fallbackMethod="fallBackgetAllFriendsData")
@RequestMapping(value="/getAll")
public ResponseEntity<List<AddFriendsData>>getAllFriendsData(){
	LOGGER.info("From class AddFriendsDataController ,method : getAllFriendsData()---ENTER------");
	ResponseEntity<List<AddFriendsData>> addFriendsData = restTemplate.exchange(GET_ALL_ADD_FRIENDS_DATA, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<AddFriendsData>>() {
			});
return addFriendsData;
	
	
}

public ResponseEntity<List<AddFriendsData>>fallBackgetAllFriendsData(){
	LOGGER.info("From class AddFriendsDataController ,method : fallBackgetAllFriendsData()---ENTER------");
	List<AddFriendsData>addFriendsDatas=addFriendsDataRepository.findAll();
	LOGGER.info("From class AddFriendsDataController ,method : fallBackgetAllFriendsData()---AFTER GETTING ALL DATA------");
	return ResponseEntity.ok().body(addFriendsDatas);
	
	
	
	
}









}
