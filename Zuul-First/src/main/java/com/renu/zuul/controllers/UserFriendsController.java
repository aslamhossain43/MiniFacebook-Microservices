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
import com.renu.zuul.friends.models.UserFriends;
import com.renu.zuul.models.FriendsEntity;

@RestController
@RequestMapping(value="/zuul-userFriends")
@RibbonClient(name = "user-friends", configuration = RibbonConfiguration.class)
public class UserFriendsController {
	private static final Logger LOGGER=LoggerFactory.getLogger(UserFriendsController.class);
	//----------------------------------------------------------------------------------------------------------------
	@Autowired
	RestTemplate restTemplate;
	//----------------------------------------------------------------------------------------------------------------
	private static final String ADD_USER="http://friendStock-service/userFriends/add";

	


	
	
	
	
	
	
	
	
	
	
	
}
