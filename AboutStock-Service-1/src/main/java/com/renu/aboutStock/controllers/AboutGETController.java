package com.renu.aboutStock.controllers;

import java.util.List;

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
import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.CollegeRepository;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/aboutStock-get")
public class AboutGETController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutGETController.class);
// REST TEMPLATE
@Autowired
RestTemplate restTemplate;
//------------------------------------------------------------------------------------------------
// WORKPLACE REPOSITORY
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
//-------------------------------------------------------------------------------------------------
//GET ALL WORKPLACES URL
private static final String GET_ALL_WORKPLACES_URL="http://about-service/about-get/workplace/getAll/";
//GET WORKPLACE BY URL
private static final String GET_SINGLE_WORKPLACE_URL="http://about-service/about-get/workplace/single/";
//DELETE WORKPLACE BY URL
private static final String DELETE_SINGLE_WORKPLACE_URL="http://about-service/about-get/workplace/single/delete/";
//-------------------------------------------------------------------------------------------------
//GET ALL PROFESSIONAL SKILLS URL
private static final String GET_ALL_PROFESSIONAL_SKILLS_URL="http://about-service/about-get/professionalSkills/getAll/";
//GET PROFESSIONAL SKILLS BY URL
private static final String GET_SINGLE_PROFESSIONAL_SKILLS_URL="http://about-service/about-get/professionalSkills/single/";
//DELETE PROFESSIONAL SKILLS BY URL
private static final String DELETE_SINGLE_PROFESSIONAL_SKILLS_URL="http://about-service/about-get/professionalSkills/single/delete/";
//-------------------------------------------------------------------------------------------------
//GET ALL COLLEGES URL
private static final String GET_ALL_COLLEGES_URL="http://about-service/about-get/college/getAll/";
//GET COLLEGE URL
private static final String GET_SINGLE_COLLEGES_URL="http://about-service/about-get/college/single/";
//DELETE COLLEGE BY URL
private static final String DELETE_SINGLE_COLLEGE_URL="http://about-service/about-get/college/single/delete/";

//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/getAll/{uid}")
public ResponseEntity<List<Workplace>> getAllWorkplaceByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : getAllWorkplaceByUID()---UID : "+uid);
	
	
	ResponseEntity<List<Workplace>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_WORKPLACES_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<Workplace>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackForStorUID
public ResponseEntity<List<Workplace>> fallbackWorkplaceGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackWorkplaceGETAll()---UID : "+uid);
	List<Workplace> profilePhotosEntity=workPlaceRepository.getAllWorkplacesByUID(uid);
	return ResponseEntity.ok().body(profilePhotosEntity);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/single/{id}")
public ResponseEntity<Workplace> getSingleWorkplaceByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : getSingleWorkplaceByID()---ID : "+id);
	
	
	ResponseEntity<Workplace> profilePhotosEntity =
	        restTemplate.exchange(GET_SINGLE_WORKPLACE_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<Workplace>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceGETByID
public ResponseEntity<Workplace> fallbackWorkplaceGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackWorkplaceGETByID()---ID : "+id);
	Workplace profilePhotosEntity=workPlaceRepository.getById(id);
	return ResponseEntity.ok().body(profilePhotosEntity);
}



//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/single/delete/{id}")
public ResponseEntity<String> deleteSingleWorkplaceByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : deleteSingleWorkplaceByID()---ID : "+id);
	
	
	ResponseEntity<String> profilePhotosEntity =
	        restTemplate.exchange(DELETE_SINGLE_WORKPLACE_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceDELETEByID
public ResponseEntity<String> fallbackWorkplaceDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackWorkplaceDELETEByID---ID : "+id);
	Workplace profilePhotosEntity=workPlaceRepository.getById(id);
	workPlaceRepository.delete(profilePhotosEntity);
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackWorkplaceDELETEByID--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackProfessionalSkillsGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/professionalSkills/getAll/{uid}")
public ResponseEntity<List<ProfessionalSkill>> getAllProfessionalSkillsByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method :  getAllProfessionalSkillsByUID()---UID : "+uid);
	
	
	ResponseEntity<List<ProfessionalSkill>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_PROFESSIONAL_SKILLS_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<ProfessionalSkill>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackForStorUID
public ResponseEntity<List<ProfessionalSkill>>fallbackProfessionalSkillsGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackProfessionalSkillsGETAll()---UID : "+uid);
	List<ProfessionalSkill> profilePhotosEntity=professionalSkillRepository.getAllProfessionalSkillsByUID(uid);
	return ResponseEntity.ok().body(profilePhotosEntity);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackProfessionalSkillsGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/professionalSkills/single/{id}")
public ResponseEntity<ProfessionalSkill> getSingleProfessionalSkillsByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : getSingleProfessionalSkillsByID()---ID : "+id);
	
	
	ResponseEntity<ProfessionalSkill> profilePhotosEntity =
	        restTemplate.exchange(GET_SINGLE_PROFESSIONAL_SKILLS_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<ProfessionalSkill>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceGETByID
public ResponseEntity<ProfessionalSkill> fallbackProfessionalSkillsGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackProfessionalSkillsGETByID()---ID : "+id);
	ProfessionalSkill professionalSkill=professionalSkillRepository.getById(id);
	return ResponseEntity.ok().body(professionalSkill);
}



//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackProfessionalSkillsDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/professionalSkills/single/delete/{id}")
public ResponseEntity<String> deleteSingleProfessionalSkillsByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : deleteSingleProfessionalSkillsByID()---ID : "+id);
	
	
	ResponseEntity<String> profilePhotosEntity =
	        restTemplate.exchange(DELETE_SINGLE_PROFESSIONAL_SKILLS_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceDELETEByID
public ResponseEntity<String>fallbackProfessionalSkillsDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackProfessionalSkillsDELETEByID()---ID : "+id);
	ProfessionalSkill professionalSkill=professionalSkillRepository.getById(id);
	professionalSkillRepository.delete(professionalSkill);
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackProfessionalSkillsDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}

//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCollegeGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/college/getAll/{uid}")
public ResponseEntity<List<College>> getAllCollegesByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method :  getAllCollegesByUID()---UID : "+uid);
	
	
	ResponseEntity<List<College>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_COLLEGES_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<College>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackForStorUID
public ResponseEntity<List<College>>fallbackCollegeGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackCollegeGETAll()---UID : "+uid);
	List<College> colleges=collegeRepository.getAllCollegesByUID(uid);
	return ResponseEntity.ok().body(colleges);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCollegeGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/college/single/{id}")
public ResponseEntity<College> getSingleCollegeByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : getSingleCollegeByID()---ID : "+id);
	
	
	ResponseEntity<College> college =
	        restTemplate.exchange(GET_SINGLE_COLLEGES_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<College>() {
	            });
	
	
	
	return college;


}
//HYSTRIX fallbackCollegeGETByID
public ResponseEntity<College>fallbackCollegeGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackCollegeGETByID()---ID : "+id);
	College college=collegeRepository.getById(id);
	return ResponseEntity.ok().body(college);
}



//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCollegesDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/college/single/delete/{id}")
public ResponseEntity<String> deleteSingleCollegeByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : deleteSingleCollegeByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_COLLEGE_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackCollegesDELETEByID
public ResponseEntity<String>fallbackCollegesDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackCollegesDELETEByID()---ID : "+id);
	College college=collegeRepository.getById(id);
	collegeRepository.delete(college);;
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackCollegesDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}


}
