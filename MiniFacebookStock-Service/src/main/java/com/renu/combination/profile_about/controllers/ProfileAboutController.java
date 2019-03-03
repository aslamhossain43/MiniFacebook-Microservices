package com.renu.combination.profile_about.controllers;

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

import com.renu.minifacebookstockservice.config.RibbonConfiguration;


@RestController
@RequestMapping(value = "/get/about")
@RibbonClient(name = "profile-about-service", configuration = RibbonConfiguration.class)
public class ProfileAboutController {
private static final Logger LOGGER=LoggerFactory.getLogger(ProfileAboutController.class);
//----------------------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;
// ---------------------------------------------------------------------------------------------------------
private static final String GET_ALL_WORKPLACES = "http://minifacebookstock-service/aboutStock-get/workplace/getAll";

// ---------------------------------------------------------------------------------------------------------
	// GET ALL WORKPLACES
	@RequestMapping(value = "/workplace/getAll")
	public ResponseEntity<List<?>> getAddFriendsEntity() {
		LOGGER.info("FROM class ProfileAboutController ,method : getAddFriendsEntity()--ENTER--");

		ResponseEntity<List<?>> workplaces = restTemplate.exchange(GET_ALL_WORKPLACES,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
				});

		return workplaces;

	}

}
