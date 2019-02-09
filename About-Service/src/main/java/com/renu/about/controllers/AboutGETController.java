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

import com.renu.about.models.College;
import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.CollegeRepository;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/about-get")
public class AboutGETController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutGETController.class);
//---------------------------------------------------------------------------------------------------------------
@Autowired
WorkPlaceRepository workPlaceRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
ProfessionalSkillRepository professionalSkillRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
CollegeRepository collegeRepository;
//---------------------------------------------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------------------------------------
//GET PROFESSIONAL SKILLS ALL
@GetMapping(value="/professionalSkills/getAll/{uid}")
public ResponseEntity<List<ProfessionalSkill>>getAllProfessionalSkillsByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllProfessionalSkillsByUID()--ENTER--UID : "+uid);
	List<ProfessionalSkill>professionalSkills=professionalSkillRepository.getAllProfessionalSkillsByUID(uid);
return	ResponseEntity.ok().body(professionalSkills);
}
//-----------------

//GET PROFESSIONAL SKILLS BY ID
@GetMapping(value="/professionalSkills/single/{id}")
public ResponseEntity<ProfessionalSkill>getSingleProfessionalSkillsByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleProfessionalSkillsByID()--ENTER--ID : "+id);
	ProfessionalSkill professionalSkill=professionalSkillRepository.getById(id);
return	ResponseEntity.ok().body(professionalSkill);
}
//-----------------

//DELETE PROFESSIONA SKILLS BY ID
@GetMapping(value="/professionalSkills/single/delete/{id}")
public ResponseEntity<String>deleteSingleProfessionalSkillsByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : deleteSingleProfessionalSkillsByID()--ENTER--ID : "+id);
	ProfessionalSkill professionalSkill=professionalSkillRepository.getById(id);
	professionalSkillRepository.delete(professionalSkill);
	LOGGER.info("From class AboutGETController,method : deleteSingleProfessionalSkillsByID()--DELETED--ID : "+id);
	
return	ResponseEntity.ok().body("SuccessCallback delete");
}
//-----------------------------------------------------------------------------------------------------------
//GET COLLEGE ALL
@GetMapping(value="/college/getAll/{uid}")
public ResponseEntity<List<College>>getAllCollegesByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllCollegesByUID()--ENTER--UID : "+uid);
	List<College>colleges=collegeRepository.getAllCollegesByUID(uid);
return	ResponseEntity.ok().body(colleges);
}
//-----------------

//GET COLLEGE BY ID
@GetMapping(value="/college/single/{id}")
public ResponseEntity<College>getSingleCollegeByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleCollegeByID()--ENTER--ID : "+id);
	College college=collegeRepository.getById(id);
return	ResponseEntity.ok().body(college);
}
//-----------------

//DELETE COLLEGE BY ID
@GetMapping(value="/college/single/delete/{id}")
public ResponseEntity<String>deleteSingleCollegeByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : deleteSingleCollegeByID()--ENTER--ID : "+id);
	College college=collegeRepository.getById(id);
	collegeRepository.delete(college);;
	LOGGER.info("From class AboutGETController,method : deleteSingleCollegeByID()--DELETED--ID : "+id);
	
return	ResponseEntity.ok().body("SuccessCallback delete");
}

}
