package com.renu.profilestock.controllers;

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
import com.renu.profilestock.config.RibbonConfiguration;
import com.renu.profilestock.models.LoginInformationEntity;
import com.renu.profilestock.repositories.LoginInformationRepository;

@RestController
@RequestMapping(value="/login")
@RibbonClient(name = "ribbon-loginformation", configuration = RibbonConfiguration.class)
public class LoginInformationController {
private static final Logger LOGGER=LoggerFactory.getLogger(LoginInformationController.class);
//--------------------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;
//-------------------------------------------------------------------------------------------------------
@Autowired
LoginInformationRepository loginInformationRepository;
//-------------------------------------------------------------------------------------------------------
private static final String ADD_LOGIN_INFORMATION="http://profile-service/login/add/information";
//-------------------------------------------------------------------------------------------------------
private static final String GET_LOGIN_INFORMATION="http://profile-service/login/get/information";

//--------------------------------------------------------------------------------------------------------
@HystrixCommand(fallbackMethod="fallBackAddLoginInformation")
@RequestMapping(value="/add/information")
public ResponseEntity<String>addLoginInformation(@RequestBody LoginInformationEntity loginInformationEntity){
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----ENTER-----");
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----UID : "+loginInformationEntity.getUid());
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----USER_NAME : "+loginInformationEntity.getUserName());
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----EMAIL : "+loginInformationEntity.getEmail());
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----PHOTO_URL : "+loginInformationEntity.getPhotoUrl());
   String entity=restTemplate.postForObject(ADD_LOGIN_INFORMATION, loginInformationEntity, String.class);
	return ResponseEntity.ok().body(entity);
	
	
	
}


public ResponseEntity<String>fallBackAddLoginInformation(@RequestBody LoginInformationEntity loginInformationEntity){
	LOGGER.info("From class LoginInformationController,method: fallBackAddLoginInformation()-----ENTER-----");
	LOGGER.info("From class LoginInformationController,method: fallBackAddLoginInformation()-----UID : "+loginInformationEntity.getUid());
	LOGGER.info("From class LoginInformationController,method: fallBackAddLoginInformation()-----USER_NAME : "+loginInformationEntity.getUserName());
	LOGGER.info("From class LoginInformationController,method: fallBackAddLoginInformation()-----EMAIL : "+loginInformationEntity.getEmail());
	LOGGER.info("From class LoginInformationController,method: fallBackAddLoginInformation()-----PHOTO_URL : "+loginInformationEntity.getPhotoUrl());
	  LoginInformationEntity getByUID=loginInformationRepository.getByUid(loginInformationEntity.getUid());
	  if (getByUID==null) {
		  if (loginInformationEntity.getUid()!=null) {
				
			  loginInformationRepository.save(loginInformationEntity);
			  }
	} else {
		loginInformationEntity.setId(getByUID.getId());
		loginInformationEntity.setUid(getByUID.getUid());
		loginInformationEntity.setEmail(getByUID.getEmail());
		loginInformationEntity.setPhotoUrl(getByUID.getPhotoUrl());
		loginInformationEntity.setUserName(getByUID.getUserName());
		loginInformationEntity.setLastActivitiesTime(loginInformationEntity.getLastModifiedDate());
		loginInformationEntity.setCreatedDate(getByUID.getCreatedDate());
		
	loginInformationRepository.save(loginInformationEntity);	
	}
	    
	return ResponseEntity.ok().body("success");
	
	
	
}




//---------------------------------------------------------------------------------------------------------------------
@HystrixCommand(fallbackMethod="fallBackGETloginInformation")
@RequestMapping(value="/get/information")
public ResponseEntity<List<LoginInformationEntity>>getLoginformation(){
	LOGGER.info("From class LoginInformationController,method: getLoginformation()-----ENTER-----");

	ResponseEntity<List<LoginInformationEntity>> responseEntity = restTemplate.exchange(GET_LOGIN_INFORMATION,
			HttpMethod.GET, null, new ParameterizedTypeReference<List<LoginInformationEntity>>() {
			});
	return responseEntity;

}

//------------------------------------
public ResponseEntity<List<LoginInformationEntity>>fallBackGETloginInformation(){
	LOGGER.info("From class LoginInformationController,method: fallBackGETloginInformation()-----ENTER-----");

	List<LoginInformationEntity>loginInformationEntities=loginInformationRepository.getAllLogInformation();
	return ResponseEntity.ok().body(loginInformationEntities);
}










}
