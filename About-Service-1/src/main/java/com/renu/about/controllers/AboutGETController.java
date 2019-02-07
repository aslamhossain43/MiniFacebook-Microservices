package com.renu.about.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.about.models.Workplace;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/about-get")
public class AboutGETController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutGETController.class);
// WORKPLACE REPOSITORY
@Autowired
WorkPlaceRepository workPlaceRepository;
// GET WORKPLACES ALL
@GetMapping(value="/workplace/getAll/{uid}")
public ResponseEntity<List<Workplace>>getAllWorkplacesByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllWorkplacesByUID()--ENTER--UID : "+uid);
	List<Workplace>workplaces=workPlaceRepository.getAllWorkplacesByUID(uid);
 return	ResponseEntity.ok().body(workplaces);
}
}
