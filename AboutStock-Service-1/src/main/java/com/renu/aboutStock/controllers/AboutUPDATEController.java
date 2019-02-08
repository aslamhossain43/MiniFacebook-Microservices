package com.renu.aboutStock.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/aboutStock-update")
public class AboutUPDATEController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutUPDATEController.class);

// WORKPLACE REPOSITORY
@Autowired
WorkPlaceRepository workPlaceRepository;
// REST TEMPLATE
@Autowired
RestTemplate restTemplate;
//UPDATE WORKPLACE BY URL
private static final String UPDATE_SINGLE_WORKPLACE_URL="http://about-service/about-update/workplace/update/";

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceUPDATEByID")
//UPDATE WORKPLACE BY ID
@PutMapping(value="/workplace/update/{id}")
public ResponseEntity<String> updateSingleWorkplaceByID(@PathVariable("id") Long id,@RequestBody Workplace workplace) {
	LOGGER.info("FROM class AboutUPDATEController,method : updateSingleWorkplaceByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_WORKPLACE_URL+id, workplace);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackWorkplaceUPDATEByID
public ResponseEntity<String> fallbackWorkplaceUPDATEByID(@PathVariable("id") Long id,@RequestBody Workplace workplace) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackWorkplaceUPDATEByID---ID : "+id);
	Workplace workplace2=workPlaceRepository.getById(id);
    workplace2.setWorkPlace(workplace.getWorkPlace());
    workPlaceRepository.save(workplace2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackWorkplaceUPDATEByID--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}

//-----------------------------


}
