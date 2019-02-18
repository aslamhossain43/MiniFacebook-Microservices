package com.renu.combination.profile_photo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renu.combination.config.RibbonConfiguration;

@RestController
@RequestMapping(value = "/get/photo")
@RibbonClient(name = "profile-photo-service", configuration = RibbonConfiguration.class)
public class ProfilePhotoController {
private static final Logger LOGGER=LoggerFactory.getLogger(ProfilePhotoController.class);
//------------------------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;
//---------------------------------------------------------------------------------------------------------
private static final String GET_ALL_LOGINFORMATION = "http://profileStock-service/login/get/information";

//------------------------------------------------------------------------------------------------------------
@RequestMapping(value="/loginformation/getAll")
public ResponseEntity<List<?>>getLogInformation(){
	LOGGER.info("From class ProfilePhotoController,method : getLogInformation()---ENTER----");
	ResponseEntity<List<?>> workplaces = restTemplate.exchange(GET_ALL_LOGINFORMATION,
			HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
			});	
	return workplaces;
}

}
