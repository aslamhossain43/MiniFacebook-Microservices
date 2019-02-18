package com.renu.zuul.controllers;

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

import com.renu.zuul.config.RibbonConfiguration;

@RestController
@RequestMapping(value = "/zuul-combination-for-friends")
@RibbonClient(name = "zuul-combination-for-friends", configuration = RibbonConfiguration.class)
public class CombinationForFriendsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CombinationForFriendsController.class);
	// ---------------------------------------------------------------------------------------------------------------
	@Autowired
	RestTemplate restTemplate;
	// ---------------------------------------------------------------------------------------------------------
	private static final String GET_ALL_WORKPLACES = "http://combination-service/get/about/workplace/getAll";
	// ---------------------------------------------------------------------------------------------------------
	private static final String GET_ALL_LOGINFORMATION = "http://combination-service/get/photo/loginformation/getAll";

	// ----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/get/workplaces")
	public ResponseEntity<List<?>> getAllWorkplaces() {
		LOGGER.info("From class CombinationForFriendsController,method :  getAllWorkplaces()---ENTER----");
		ResponseEntity<List<?>> workplacesEntity = restTemplate.exchange(GET_ALL_WORKPLACES, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<?>>() {
				});

		return workplacesEntity;

	}

	// ----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/get/loginformation")
	public ResponseEntity<List<?>> getAllLoginformation() {
		LOGGER.info("From class CombinationForFriendsController,method :  getAllLoginformation()---ENTER----");
		ResponseEntity<List<?>> loginformation = restTemplate.exchange(GET_ALL_LOGINFORMATION, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<?>>() {
				});

		return loginformation;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
