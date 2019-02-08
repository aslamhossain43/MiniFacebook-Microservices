package com.renu.about.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.about.models.Workplace;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/about-update")
public class AboutUPDATEController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutUPDATEController.class);
// WORKPLACE REPOSITORY
@Autowired
WorkPlaceRepository workPlaceRepository;
@PutMapping(value="/workplace/update/{id}")
public ResponseEntity<String>updateWorkplaceById(@PathVariable Long id,@RequestBody Workplace workplace){
	LOGGER.info("From class AboutUPDATEController,method : updateWorkplaceById()---ENTER--ID : "+id);
    Workplace workplace2=workPlaceRepository.getById(id);
    workplace2.setWorkPlace(workplace.getWorkPlace());
    workPlaceRepository.save(workplace2);
    LOGGER.info("From class AboutUPDATEController,method : updateWorkplaceById()---UPDATED--ID : "+id);
    return ResponseEntity.ok().body("success update !!!");



}


}
