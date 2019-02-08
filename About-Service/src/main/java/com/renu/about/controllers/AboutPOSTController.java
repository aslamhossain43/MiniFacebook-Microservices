package com.renu.about.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.WorkPlaceRepository;


@RestController
@RequestMapping(value="/aboutService-post")
public class AboutPOSTController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutPOSTController.class);
//--------------------------------------------------------------------------------------------------
// REPOSITORY
@Autowired
WorkPlaceRepository workPlaceRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
ProfessionalSkillRepository professionalSkillRepository;
//----------------------------------------------------------------------------------------------------
	// WORKPLACE ADD
@PostMapping(value="/workplace/add")
public ResponseEntity<Workplace>addWorkplace(@RequestBody Workplace workplace){
	LOGGER.info("From class AboutPOSTController,method : addWorkplace()--ENTER--");
	workPlaceRepository.save(workplace);
return ResponseEntity.ok().body(workplace);
}
	
//----------------------------------------------------------------------------------------------------
	// PROFESSIONAL SKILLS ADD
@PostMapping(value="/professionalSkills/add")
public ResponseEntity<ProfessionalSkill>addProfessionalSkills(@RequestBody ProfessionalSkill professionalSkill){
	LOGGER.info("From class AboutPOSTController,method : addProfessionalSkills()--ENTER--");
	professionalSkillRepository.save(professionalSkill);
	LOGGER.info("From class AboutPOSTController,method : addProfessionalSkills()--SAVED PROFESSIONAL SKILLS--");
	
return ResponseEntity.ok().body(professionalSkill);
}
	
	
	
	
}
