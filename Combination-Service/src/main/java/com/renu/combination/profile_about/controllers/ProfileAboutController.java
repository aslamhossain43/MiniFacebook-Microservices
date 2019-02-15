package com.renu.combination.profile_about.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renu.combination.config.RibbonConfiguration;


@RestController
@RequestMapping(value = "/get/about")
@RibbonClient(name = "profile-about-service", configuration = RibbonConfiguration.class)
public class ProfileAboutController {
private static final Logger LOGGER=LoggerFactory.getLogger(ProfileAboutController.class);
//----------------------------------------------------------------------------------------------------------
@Autowired
RestTemplate restTemplate;
}
