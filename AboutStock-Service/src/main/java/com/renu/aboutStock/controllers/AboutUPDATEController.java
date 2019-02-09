package com.renu.aboutStock.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.about.models.College;
import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.CollegeRepository;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/aboutStock-update")
public class AboutUPDATEController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutUPDATEController.class);
// REST TEMPLATE
@Autowired
RestTemplate restTemplate;
//--------------------------------------------------------------------------------------------------------------
@Autowired
WorkPlaceRepository workPlaceRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
ProfessionalSkillRepository professionalSkillRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
CollegeRepository collegeRepository;
//----------------------------------------------------------------------------------------------------------------
//UPDATE WORKPLACE BY URL
private static final String UPDATE_SINGLE_WORKPLACE_URL="http://about-service/about-update/workplace/update/";
//----------------------------------------------------------------------------------------------------------------
//UPDATE PROFESSIONAL SKILLS BY URL
private static final String UPDATE_SINGLE_PROFESSIONAL_SKILLS_URL="http://about-service/about-update/professionalSkills/update/";
//----------------------------------------------------------------------------------------------------------------
//UPDATE COLLEGE BY URL
private static final String UPDATE_SINGLE_COLLEGE_URL="http://about-service/about-update/college/update/";

//----------------------------------------------------------------------------------------------------------------

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


//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackProfessionalSkillsUPDATEByID")
//UPDATE PROFESSIONAL SKILLS BY ID
@PutMapping(value="/professionalSkills/update/{id}")
public ResponseEntity<String> updateSingleProfessionalSkillsByID(@PathVariable("id") Long id,@RequestBody ProfessionalSkill professionalSkill) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSingleProfessionalSkillsByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_PROFESSIONAL_SKILLS_URL+id, professionalSkill);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackProfessionalSkillsUPDATEByID
public ResponseEntity<String>fallbackProfessionalSkillsUPDATEByID(@PathVariable("id") Long id,@RequestBody ProfessionalSkill professionalSkill) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackProfessionalSkillsUPDATEByID()---ID : "+id);
	ProfessionalSkill professionalSkill2=professionalSkillRepository.getById(id);
	professionalSkill2.setProfessionalSkill(professionalSkill.getProfessionalSkill());
 professionalSkillRepository.save(professionalSkill2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackProfessionalSkillsUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}



//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCollegeUPDATEByID")
//UPDATE COLLEGE BY ID
@PutMapping(value="/college/update/{id}")
public ResponseEntity<String> updateSingleCollegeByID(@PathVariable("id") Long id,@RequestBody College college) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSingleCollegeByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_COLLEGE_URL+id, college);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackCollegeUPDATEByID
public ResponseEntity<String>fallbackCollegeUPDATEByID(@PathVariable("id") Long id,@RequestBody College college) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackCollegeUPDATEByID()---ID : "+id);
	College college2=collegeRepository.getById(id);
	college2.setCollege(college.getCollege());
collegeRepository.save(college2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackCollegeUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}


}
