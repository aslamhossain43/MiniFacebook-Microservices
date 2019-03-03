package com.renu.friends.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renu.friends.models.FriendsEntity;
import com.renu.friends.repositories.FriendsRepository;

@RestController
@RequestMapping(value = "/friends")
public class FriendsController {
private static final Logger LOGGER=LoggerFactory.getLogger(FriendsController.class);
//-------------------------------------------------------------------------------------------------------------
@Autowired
FriendsRepository friendsRepository;
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
@RequestMapping(value="/add")
public ResponseEntity<FriendsEntity>addFriends(@RequestBody FriendsEntity friendsEntity){
	LOGGER.info("From class FriendsController,method :addFriends()-----ENTER-------- ");


	
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
	
	return ResponseEntity.ok().body(friendsEntity);
	
}
//-------------------------------------------------------------------------------------------------------------

@RequestMapping(value="/getFromAgree")
public ResponseEntity<FriendsEntity>getFromAgree(@RequestParam("fromUid")String fromUid, @RequestParam("toUid") String toUid){
	LOGGER.info("From class FriendsController,method :getFromAgree()-----ENTER-------- ");
	FriendsEntity friendsEntity=friendsRepository.getFromAgree(fromUid, toUid);
	return ResponseEntity.ok().body(friendsEntity);

}






}
