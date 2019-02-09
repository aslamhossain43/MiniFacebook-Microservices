package com.renu.aboutStock.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.about.models.College;
import com.renu.about.models.HighSchool;
import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.CollegeRepository;
import com.renu.about.repositories.HighSchoolRepository;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/aboutStock-delete")
public class AboutDELETEController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutDELETEController.class);
//REST TEMPLATE
@Autowired
RestTemplate restTemplate;
//------------------------------------------------------------------------------------------------
//WORKPLACE REPOSITORY
@Autowired
WorkPlaceRepository workPlaceRepository;
//------------------------------------------------------------------------------------------------
//PROFESSIONAL REPOSITORY
@Autowired
ProfessionalSkillRepository professionalSkillRepository;
//------------------------------------------------------------------------------------------------
//COLLEGE REPOSITORY
@Autowired
CollegeRepository collegeRepository;
//------------------------------------------------------------------------------------------------
//HIGH SCHOOL REPOSITORY
@Autowired
HighSchoolRepository highSchoolRepository;
//-------------------------------------------------------------------------------------------------
//DELETE WORKPLACE BY URL
private static final String DELETE_SINGLE_WORKPLACE_URL="http://about-service/about-delete/workplace/single/delete/";
//------------------------------------------------------------------------------------------------------
//DELETE PROFESSIONAL SKILLS BY URL
private static final String DELETE_SINGLE_PROFESSIONAL_SKILLS_URL="http://about-service/about-delete/professionalSkills/single/delete/";
//-------------------------------------------------------------------------------------------------------------
//DELETE COLLEGE BY URL
private static final String DELETE_SINGLE_COLLEGE_URL="http://about-service/about-delete/college/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE HIGHSCHOOL BY URL
private static final String DELETE_SINGLE_HIGHSCHOOL_URL="http://about-service/about-delete/highSchool/single/delete/";

//------------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/single/delete/{id}")
public ResponseEntity<String> deleteSingleWorkplaceByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSingleWorkplaceByID()---ID : "+id);
	
	
	ResponseEntity<String> profilePhotosEntity =
	        restTemplate.exchange(DELETE_SINGLE_WORKPLACE_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceDELETEByID
public ResponseEntity<String> fallbackWorkplaceDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackWorkplaceDELETEByID---ID : "+id);
	Workplace profilePhotosEntity=workPlaceRepository.getById(id);
	workPlaceRepository.delete(profilePhotosEntity);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackWorkplaceDELETEByID--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//--------------------------------------------------------------------------------------------------------------------


//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackProfessionalSkillsDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/professionalSkills/single/delete/{id}")
public ResponseEntity<String> deleteSingleProfessionalSkillsByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class class AboutDELETEController,method : deleteSingleProfessionalSkillsByID()---ID : "+id);
	
	
	ResponseEntity<String> profilePhotosEntity =
	        restTemplate.exchange(DELETE_SINGLE_PROFESSIONAL_SKILLS_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceDELETEByID
public ResponseEntity<String>fallbackProfessionalSkillsDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class class AboutDELETEController,method : fallbackProfessionalSkillsDELETEByID()---ID : "+id);
	ProfessionalSkill professionalSkill=professionalSkillRepository.getById(id);
	professionalSkillRepository.delete(professionalSkill);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackProfessionalSkillsDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}

//------------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCollegesDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/college/single/delete/{id}")
public ResponseEntity<String> deleteSingleCollegeByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class class AboutDELETEController,method : deleteSingleCollegeByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_COLLEGE_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackCollegesDELETEByID
public ResponseEntity<String>fallbackCollegesDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackCollegesDELETEByID()---ID : "+id);
	College college=collegeRepository.getById(id);
	collegeRepository.delete(college);;
	LOGGER.info("FROM class AboutDELETEController,method : fallbackCollegesDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}


//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackHighSchoolDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/highSchool/single/delete/{id}")
public ResponseEntity<String> deleteSingleHighSchoolByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSingleHighSchoolByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_HIGHSCHOOL_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackHighSchoolDELETEByID
public ResponseEntity<String>fallbackHighSchoolDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackHighSchoolDELETEByID()---ID : "+id);
	HighSchool highSchool=highSchoolRepository.getById(id);
	highSchoolRepository.delete(highSchool);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackHighSchoolDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}


}
