package com.renu.friendstock.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.friendstock.config.RibbonConfiguration;
import com.renu.friendstock.models.UserFriends;
import com.renu.friendstock.repositories.FriendRepository;
import com.renu.friendstock.repositories.UserRepository;

@RestController
@RequestMapping(value="/userFriends")
@RibbonClient(name = "user-friends", configuration = RibbonConfiguration.class)
public class UserFriendsController {
private static final Logger LOGGER=LoggerFactory.getLogger(UserFriendsController.class);
//-------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;
//------------------------------------------------------------------------------------------------
@Autowired
UserRepository userRepository;
//--------------------------------------------------------------------------------------------------
@Autowired
FriendRepository friendRepository;
//--------------------------------------------------------------------------------------------------
@HystrixCommand(fallbackMethod="fallBackUserAdd")
@RequestMapping(value="/add")
public ResponseEntity<?>userAdd(@RequestBody UserFriends userFriends){
	LOGGER.info("From class UserFriendsController,method : userAdd()-----ENTER-");
	userFriends.getUsers().setFriends(userFriends.getFriends());
	userFriends.getFriends().setUser(userFriends.getUsers());
	userRepository.save(userFriends.getUsers());
	return ResponseEntity.ok().body(null);
}






}
