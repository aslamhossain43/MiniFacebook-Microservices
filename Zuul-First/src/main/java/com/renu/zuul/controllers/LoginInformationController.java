package com.renu.zuul.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renu.zuul.config.RibbonConfiguration;
import com.renu.zuul.models.LoginInformationEntity;

@RestController
@RequestMapping(value = "/zuul-logInformation")
@RibbonClient(name = "zuul-loginformation", configuration = RibbonConfiguration.class)
public class LoginInformationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginInformationController.class);
	// ----------------------------------------------------------------------------------------------------------
	@Autowired
	RestTemplate restTemplate;
	// -------------------------------------------------------------------------------------------------------
	private static final String ADD_LOGIN_INFORMATION = "http://minifacebookstock-service/login/add/information";

	// ------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/add/information")
	public ResponseEntity<?> addLoginInformation(@RequestBody LoginInformationEntity loginInformationEntity) {
		LOGGER.info("From class LoginInformationController, method : addLoginInformation()------ENTER----");
		LOGGER.info("From class LoginInformationController, method : addLoginInformation()------UID : "+loginInformationEntity.getUid());	
		LOGGER.info("From class LoginInformationController, method : addLoginInformation()------USER_NAME : "+loginInformationEntity.getUserName());
		LOGGER.info("From class LoginInformationController, method : addLoginInformation()------EMAIL : "+loginInformationEntity.getEmail());
		LOGGER.info("From class LoginInformationController, method : addLoginInformation()------PHOTO_URL : "+loginInformationEntity.getPhotoUrl());
			
		
		
		
		String response = restTemplate.postForObject(ADD_LOGIN_INFORMATION, loginInformationEntity, String.class);

		return ResponseEntity.ok().body(response);

	}
}
