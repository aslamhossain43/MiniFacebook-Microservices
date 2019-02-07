package com.renu.aboutStock.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.about.config.RibbonConfiguration;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.WorkPlaceRepository;


@RestController
@RequestMapping(value="/aboutStock-post")
@RibbonClient(name = "aboutStock-service", configuration = RibbonConfiguration.class)
public class AboutPOSTController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutPOSTController.class);
// REST TEMPLATE 
@Autowired
RestTemplate restTemplate;
// REPOSITORY
@Autowired
WorkPlaceRepository workPlaceRepository;
// WORKPLACE ADD URL
private static final String WORKPLACE_ADD_URL="http://about-service/aboutService-post/add";
	// WORKPLACE ADD
@HystrixCommand(fallbackMethod="workplaceAddFallBack")
@PostMapping(value="/add")
public ResponseEntity<Workplace>addWorkplace(@RequestBody Workplace workplace){
	LOGGER.info("From class AboutPOSTController,method : addWorkplace()--ENTER--");
	Workplace workplace2=restTemplate.postForObject(WORKPLACE_ADD_URL,workplace,Workplace.class);
	return ResponseEntity.ok().body(workplace2);
}

// HYSTRIX WORKPLACE ADD
public ResponseEntity<Workplace>workplaceAddFallBack(@RequestBody Workplace workplace){
	LOGGER.info("From class AboutPOSTController,method : workplaceAddFallBack()--ENTER--");
	workPlaceRepository.save(workplace);
	return ResponseEntity.ok().body(workplace);
}






	
	
	
}
