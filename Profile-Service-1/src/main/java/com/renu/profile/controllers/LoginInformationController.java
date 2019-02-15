package com.renu.profile.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.profile.models.LoginInformationEntity;
import com.renu.profile.repositories.LoginInformationRepository;


@RestController
@RequestMapping(value="/login")
public class LoginInformationController {
private static final Logger LOGGER=LoggerFactory.getLogger(LoginInformationController.class);

//-------------------------------------------------------------------------------------------------------
@Autowired
LoginInformationRepository loginInformationRepository;
//--------------------------------------------------------------------------------------------------------
@RequestMapping(value="/add/information")
public ResponseEntity<String>addLoginInformation(@RequestBody LoginInformationEntity loginInformationEntity){
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----ENTER-----");
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----UID : "+loginInformationEntity.getUid());
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----USER_NAME : "+loginInformationEntity.getUserName());
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----EMAIL : "+loginInformationEntity.getEmail());
	LOGGER.info("From class LoginInformationController,method: addLoginInformation()-----PHOTO_URL : "+loginInformationEntity.getPhotoUrl());
   loginInformationRepository.save(loginInformationEntity);
    	
	return ResponseEntity.ok().body("success");
	
	
	
}
}
