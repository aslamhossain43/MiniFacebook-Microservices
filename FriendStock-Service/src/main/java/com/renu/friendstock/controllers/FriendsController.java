package com.renu.friendstock.controllers;

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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.friendstock.config.RibbonConfiguration;
import com.renu.friendstock.models.FriendsEntity;
import com.renu.friendstock.repositories.FriendsRepository;

@RestController
@RequestMapping(value="/friends")
@RibbonClient(name = "friends-manage", configuration = RibbonConfiguration.class)
public class FriendsController {
private static final Logger LOGGER=LoggerFactory.getLogger(FriendsController.class);
//----------------------------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;
//----------------------------------------------------------------------------------------------------------------
private static final String ADD_FRIENDS_DATA="http://friends-service/friends/add";
private static final String GET_FROM_AGREE="http://friends-service/friends/getFromAgree";

//----------------------------------------------------------------------------------------------------------------
@Autowired
FriendsRepository friendsRepository;
//----------------------------------------------------------------------------------------------------------------


@HystrixCommand(fallbackMethod="fallBackAddFriends")
@RequestMapping(value="/add")
public ResponseEntity<FriendsEntity>addfriends(@RequestBody FriendsEntity friendsEntity){
	LOGGER.info("From class FriendsController,method : addfriends()-----ENTER------");
	FriendsEntity friendsEntity2=restTemplate.postForObject(ADD_FRIENDS_DATA, friendsEntity, FriendsEntity.class);
	LOGGER.info("From class FriendsController,method : addfriends()-----REST TEMPLATE COMPLETED------");
	
	return ResponseEntity.ok().body(friendsEntity2);
}
//-------------------------------------------
public ResponseEntity<FriendsEntity>fallBackAddFriends(@RequestBody FriendsEntity friendsEntity){
	LOGGER.info("From class FriendsController,method : fallBackAddfriends()-----ENTER------");
	FriendsEntity friendsEntity2=friendsRepository.getFromAgree(friendsEntity.getFromUid(),friendsEntity.getToUid());
	if (friendsEntity2==null) {
		
	friendsRepository.save(friendsEntity);
	}
	else {
		friendsEntity2.setId(friendsEntity2.getId());
		friendsEntity2.setFromUid(friendsEntity2.getFromUid());
		friendsEntity2.setToUid(friendsEntity2.getToUid());
		friendsEntity2.setFromAgree(friendsEntity2.getFromAgree());
		friendsEntity2.setCreatedDate(friendsEntity2.getCreatedDate());
		friendsEntity2.setLastModifiedDate(friendsEntity.getLastModifiedDate());
		friendsEntity2.setLastActivitiesTime(friendsEntity.getLastModifiedDate());
		friendsRepository.save(friendsEntity2);
		
	}
	LOGGER.info("From class FriendsController,method : fallBackAddfriends()-----SAVE COMPLETED------");
	
	return ResponseEntity.ok().body(friendsEntity);
	
}
//----------------------------------------------------------------------------------------------------------------------
@HystrixCommand(fallbackMethod="fallBackGetFromAgree")
@RequestMapping(value="/getFromAgree")
public ResponseEntity<FriendsEntity>getFromAgree(@RequestParam("fromUid")String fromUid, @RequestParam("toUid") String toUid){
	LOGGER.info("From class FriendsController,method : getFromAgree()-----ENTER-----fromUid : "+fromUid+" toUid : "+toUid);

	MultiValueMap<String, Object> map= new LinkedMultiValueMap<String,Object>();
	map.add("fromUid",fromUid);
	map.add("toUid", toUid);
	FriendsEntity friendsEntity=restTemplate.postForObject(GET_FROM_AGREE,map, FriendsEntity.class);
	LOGGER.info("From class FriendsController,method : getFromAgree()-----REST TEMPLATE COMPLETED-------");

	return ResponseEntity.ok().body(friendsEntity);

}
public ResponseEntity<FriendsEntity>fallBackGetFromAgree(@RequestParam("fromUid")String fromUid, @RequestParam("toUid") String toUid){
	LOGGER.info("From class FriendsController,method : fallBackFetFromAgree()-----ENTER-----fromUid : "+fromUid+" toUid : "+toUid);
	FriendsEntity friendsEntity=friendsRepository.getFromAgree(fromUid, toUid);
	return ResponseEntity.ok().body(friendsEntity);
}
}
