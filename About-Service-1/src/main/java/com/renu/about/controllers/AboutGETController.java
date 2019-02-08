package com.renu.about.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.SuccessCallback;
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
//-----------------
// GET WORKPLACES ALL
@GetMapping(value="/workplace/getAll/{uid}")
public ResponseEntity<List<Workplace>>getAllWorkplacesByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllWorkplacesByUID()--ENTER--UID : "+uid);
	List<Workplace>workplaces=workPlaceRepository.getAllWorkplacesByUID(uid);
 return	ResponseEntity.ok().body(workplaces);
}
//-----------------

//GET WORKPLACE BY ID
@GetMapping(value="/workplace/single/{id}")
public ResponseEntity<Workplace>getSingleWorkplaceByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleWorkplaceByID()--ENTER--ID : "+id);
	Workplace workplace=workPlaceRepository.getById(id);
return	ResponseEntity.ok().body(workplace);
}
//-----------------

//DELETE WORKPLACE BY ID
@GetMapping(value="/workplace/single/delete/{id}")
public ResponseEntity<String>deleteSingleWorkplaceByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : deleteSingleWorkplaceByID()--ENTER--ID : "+id);
	Workplace workplace=workPlaceRepository.getById(id);
	workPlaceRepository.delete(workplace);
	LOGGER.info("From class AboutGETController,method : deleteSingleWorkplaceByID()--DELETED--ID : "+id);
	
return	ResponseEntity.ok().body("SuccessCallback delete");
}

}
