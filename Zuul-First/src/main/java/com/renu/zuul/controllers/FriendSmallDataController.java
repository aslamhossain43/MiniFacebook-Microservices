package com.renu.zuul.controllers;

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

import com.renu.zuul.config.RibbonConfiguration;
import com.renu.zuul.models.AddFriendsData;

@RestController
@RequestMapping(value = "/zuul-smalldata-for-friends")
@RibbonClient(name = "zuul-smalldata-for-friends", configuration = RibbonConfiguration.class)
public class FriendSmallDataController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FriendSmallDataController.class);
	// ---------------------------------------------------------------------------------------------------------------
	@Autowired
	RestTemplate restTemplate;
	// ---------------------------------------------------------------------------------------------------------
	private static final String ADD_SMALL_DATA_FRIENDS = "http://minifacebookstock-service/friends/smalldata/add";
	private static final String GET_ALL_SMALL_DATA="http://minifacebookstock-service/friends/smalldata/getAll";

	// ---------------------------------------------------------------------------------------------------------
@RequestMapping(value="/friends/smalldata/add")
public ResponseEntity<?>addSmallDataForFriends(@RequestBody AddFriendsData addFriendsData){
	LOGGER.info("From class FriendSmallDataController,,method : addSmallDataForFriends()---ENTER");
	AddFriendsData addFriendsData2=restTemplate.postForObject(ADD_SMALL_DATA_FRIENDS, addFriendsData, AddFriendsData.class);
	LOGGER.info("From class FriendSmallDataController,,method : addSmallDataForFriends()---SUCCESS");

	return ResponseEntity.ok().body(addFriendsData2);
	
}

@RequestMapping(value="/friends/smalldata/getAll")
public ResponseEntity<List<?>>getAllSmallDataForFriends(){
	LOGGER.info("From class FriendSmallDataController,method : getAllSmallDataForFriends()----ENTER-----");
	ResponseEntity<List<?>> responseEntity = restTemplate.exchange(GET_ALL_SMALL_DATA, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<?>>() {
			});
return responseEntity;


}



}
