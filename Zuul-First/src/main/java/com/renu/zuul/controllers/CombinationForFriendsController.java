package com.renu.zuul.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renu.zuul.config.RibbonConfiguration;

@RestController
@RequestMapping(value="/zuul-combination-for-friends")
@RibbonClient(name = "zuul-combination-for-friends", configuration = RibbonConfiguration.class)
public class CombinationForFriendsController {
private static final Logger LOGGER=LoggerFactory.getLogger(CombinationForFriendsController.class);
//---------------------------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;




}
