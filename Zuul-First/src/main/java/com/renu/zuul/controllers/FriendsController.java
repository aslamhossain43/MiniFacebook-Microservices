package com.renu.zuul.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renu.zuul.config.RibbonConfiguration;
import com.renu.zuul.models.FriendsEntity;
@RestController
@RequestMapping(value="/zuul-friends")
@RibbonClient(name = "friends-manage", configuration = RibbonConfiguration.class)
public class FriendsController {
private static final Logger LOGGER=LoggerFactory.getLogger(FriendsController.class);
//----------------------------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;
//----------------------------------------------------------------------------------------------------------------
private static final String ADD_FRIENDS_DATA="http://minifacebookstock-service/friends/add";
private static final String GET_FROM_AGREE="http://minifacebookstock-service/friends/getFromAgree";

//----------------------------------------------------------------------------------------------------------------
@RequestMapping(value="/friends/add")
public ResponseEntity<FriendsEntity>addFriendsData(@RequestBody FriendsEntity friendsEntity){
	LOGGER.info("From class FriendsController, method : addFriendsData()-----ENTER---- ");
	FriendsEntity friendsEntity2=restTemplate.postForObject(ADD_FRIENDS_DATA, friendsEntity, FriendsEntity.class);
	LOGGER.info("From class FriendsController, method : addFriendsData()-----REST TEMPLATE COMPLETED---- ");
	return ResponseEntity.ok().body(friendsEntity2);
	
	
}



//------------------------------------------------------------------------------------------------------------------
@RequestMapping(value="/friends/getFromAgree")
public ResponseEntity<?>getFromAgree(@RequestParam("fromUid")String fromUid, @RequestParam("toUid") String toUid) throws Exception {
	LOGGER.info("FROM class FriendsController,method : getFromAgree()--ENTER--fromUid : "+fromUid+" toUid : "+toUid);

	MultiValueMap<String, Object> map= new LinkedMultiValueMap<String,Object>();
	map.add("fromUid",fromUid);
	map.add("toUid", toUid);
	FriendsEntity friendsEntity=restTemplate.postForObject(GET_FROM_AGREE,map, FriendsEntity.class);
	return ResponseEntity.ok().body(friendsEntity);
}







}
