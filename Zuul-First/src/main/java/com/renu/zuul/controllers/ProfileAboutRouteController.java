package com.renu.zuul.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renu.zuul.models.College;
import com.renu.zuul.models.HighSchool;
import com.renu.zuul.models.ProfessionalSkill;
import com.renu.zuul.models.Workplace;

@RestController
@RequestMapping(value = "/zuul-profileAbout")
public class ProfileAboutRouteController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileAboutRouteController.class);
	// REST TEMPLATE
	@Autowired
	RestTemplate restTemplate;
	// -----------------------------------------------------------------------------------------------------------------
	// WORKPLACE ADD URL
	private static final String WORKPLACE_ADD_URL = "http://aboutStock-service/aboutStock-post/workplace/add";
	// GET ALL WORKPLACES URL
	private static final String GET_ALL_WORKPLACES_URL = "http://aboutStock-service/aboutStock-get/workplace/getAll/";
	// GET WORKPLACE BY ID URL
	private static final String GET_SINGLE_WORKPLACE_URL = "http://aboutStock-service/aboutStock-get/workplace/single/";
	// UPDATE WORKPLACE BY ID URL
	private static final String UPDATE_SINGLE_WORKPLACE_URL = "http://aboutStock-service/aboutStock-update/workplace/update/";
	// DELETE WORKPLACE BY ID URL
	private static final String DELETE_SINGLE_WORKPLACE_URL = "http://aboutStock-service/aboutStock-delete/workplace/single/delete/";

	// -----------------------------------------------------------------------------------------------------------------------
	// PROFESSIONAL SKILLS ADD URL
	private static final String PROFESSIONAL_SKILLS_ADD_URL = "http://aboutStock-service/aboutStock-post/professionalSkills/add";
	// GET ALL PROFESSIONAL SKILLS URL
	private static final String GET_ALL_PROFESSIONAL_SKILLS_URL = "http://aboutStock-service/aboutStock-get/professionalSkills/getAll/";
	// GET PROFESSIONAL SKILLS BY ID URL
	private static final String GET_SINGLE_PROFESSIONAL_SKILLS_URL = "http://aboutStock-service/aboutStock-get/professionalSkills/single/";
	// UPDATE PROFESSIONAL SKILLS BY ID URL
	private static final String UPDATE_SINGLE_PROFESSIONAL_SKILLS_URL = "http://aboutStock-service/aboutStock-update/professionalSkills/update/";
	// DELETE PROFESSIONAL SKILLS BY ID URL
	private static final String DELETE_SINGLE_PROFESSIONAL_SKILLS_URL = "http://aboutStock-service/aboutStock-delete/professionalSkills/single/delete/";
	// --------------------------------------------------------------------------------------------------------------------
	// COLLEGE ADD URL
	private static final String COLLEGE_ADD_URL = "http://aboutStock-service/aboutStock-post/college/add";
	// GET ALL COLLEGE URL
	private static final String GET_ALL_COLLEGE_URL = "http://aboutStock-service/aboutStock-get/college/getAll/";
	// GET COLLEGE BY ID URL
	private static final String GET_SINGLE_COLLEGE_URL = "http://aboutStock-service/aboutStock-get/college/single/";
	// UPDATE COLLEGE BY ID URL
	private static final String UPDATE_SINGLE_COLLEGE_URL = "http://aboutStock-service/aboutStock-update/college/update/";
	// DELETE COLLEGE BY ID URL
	private static final String DELETE_SINGLE_COLLEGE_URL = "http://aboutStock-service/aboutStock-delete/college/single/delete/";

	
	// --------------------------------------------------------------------------------------------------------------------
		// HIGH SCHOOL ADD URL
		private static final String HIGHSCHOOL_ADD_URL = "http://aboutStock-service/aboutStock-post/highSchool/add";
		// GET ALL COLLEGE URL
		private static final String GET_ALL_HIGHSCHOOL_URL = "http://aboutStock-service/aboutStock-get/highSchool/getAll/";
		// GET COLLEGE BY ID URL
		private static final String GET_SINGLE_HIGHSCHOOL_URL = "http://aboutStock-service/aboutStock-get/highSchool/single/";
		// UPDATE COLLEGE BY ID URL
		private static final String UPDATE_SINGLE_HIGHSCHOOL_URL = "http://aboutStock-service/aboutStock-update/highSchool/update/";
		// DELETE COLLEGE BY ID URL
		private static final String DELETE_SINGLE_HIGHSCHOOL_URL = "http://aboutStock-service/aboutStock-delete/highSchool/single/delete/";

	
	// --------------------------------------------------------------------------------------------------------------------
	// START WRKPLACE METHOD
	@RequestMapping(value = "/workplace/add")
	public ResponseEntity<?> workplaceAdd(@RequestBody Workplace workplace) {
		LOGGER.info("From class ProfileAboutRouteController,method : workplaceAdd()--ENTER--workplace : "
				+ workplace.getWorkPlace());

		Workplace responseEntity = restTemplate.postForObject(WORKPLACE_ADD_URL, workplace, Workplace.class);
		return ResponseEntity.ok().body(responseEntity);
	}

	// ---------------------
	// GET ALL WORKPLACES
	@RequestMapping(value = "/workplace/getAll/{uid}")
	public ResponseEntity<?> getAllWorkplaces(@PathVariable("uid") String uid) {
		LOGGER.info("FROM class ProfileStockServiceController,method : getAllWorkplaces()--ENTER--UID : " + uid);

		ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_WORKPLACES_URL + uid,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
				});

		return profilePhotosEntities;

	}

	// ---------------------

	// GET WORKPLACE BY ID
	@RequestMapping(value = "/workplace/single/{id}")
	public ResponseEntity<?> getSingleWorkplace(@PathVariable("id") Long id) {
		LOGGER.info("FROM class ProfileStockServiceController,method : getSingleWorkplace()--ENTER--ID : " + id);

		ResponseEntity<Workplace> profilePhotosEntity = restTemplate.exchange(GET_SINGLE_WORKPLACE_URL + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<Workplace>() {
				});

		return profilePhotosEntity;

	}

	// ---------------------

	// DELETE WORKPLACE BY ID
	@RequestMapping(value = "/workplace/single/delete/{id}")
	public ResponseEntity<?> getSingleDELETEWorkplace(@PathVariable("id") Long id) {
		LOGGER.info("FROM class ProfileStockServiceController,method : getSingleWorkplace()--ENTER--ID : " + id);

		ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_WORKPLACE_URL + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				});

		return profilePhotosEntity;

	}

	// ---------------------

	// UPDATE WORKPLACE BY ID
	@RequestMapping(value = "/workplace/update/{id}")
	public ResponseEntity<?> updateSingleWorkplace(@RequestBody Workplace workplace, @PathVariable("id") Long id) {
		LOGGER.info("FROM class ProfileStockServiceController,method : updateSingleWorkplace()--ENTER--ID : " + id);
		restTemplate.put(UPDATE_SINGLE_WORKPLACE_URL + id, workplace);
		return ResponseEntity.ok().body("success update");

	}

	// ----------------------------------------------------------------------------------------------------

	// START PROFESSIONAL SKILLS METHOD
	@RequestMapping(value = "/professionalSkills/add")
	public ResponseEntity<?> professionalSkillsAdd(@RequestBody ProfessionalSkill professionalSkill) {
		LOGGER.info(
				"From class ProfileAboutRouteController,method : professionalSkillsAdd()--ENTER--professionalSkills : "
						+ professionalSkill.getProfessionalSkill());

		ProfessionalSkill responseEntity = restTemplate.postForObject(PROFESSIONAL_SKILLS_ADD_URL, professionalSkill,
				ProfessionalSkill.class);
		return ResponseEntity.ok().body(responseEntity);
	}

	// ---------------------
	// GET ALL PROFESSIONAL SKILLS
	@RequestMapping(value = "/professionalSkills/getAll/{uid}")
	public ResponseEntity<?> getAllProfessionalSkills(@PathVariable("uid") String uid) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getAllProfessionalSkills()--ENTER--UID : " + uid);

		ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_PROFESSIONAL_SKILLS_URL + uid,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
				});

		return profilePhotosEntities;

	}

	// ---------------------

	// GET PROFESSIONAL SKILLS BY ID
	@RequestMapping(value = "/professionalSkills/single/{id}")
	public ResponseEntity<?> getSingleProfessionalSkills(@PathVariable("id") Long id) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getSingleProfessionalSkills()--ENTER--ID : " + id);

		ResponseEntity<ProfessionalSkill> profilePhotosEntity = restTemplate.exchange(
				GET_SINGLE_PROFESSIONAL_SKILLS_URL + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<ProfessionalSkill>() {
				});

		return profilePhotosEntity;

	}

	// ---------------------

	// DELETE PROFESSIONAL SKILL BY ID
	@RequestMapping(value = "/professionalSkills/single/delete/{id}")
	public ResponseEntity<?> getSingleDELETEProfessionalSkills(@PathVariable("id") Long id) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getSingleDELETEProfessionalSkills()--ENTER--ID : "
						+ id);

		ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_PROFESSIONAL_SKILLS_URL + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				});

		return profilePhotosEntity;

	}

	// ---------------------

	// UPDATE PROFESSIONAL SKILLS BY ID
	@RequestMapping(value = "/professionalSkills/update/{id}")
	public ResponseEntity<?> updateSingleProfessionalSkills(@RequestBody ProfessionalSkill professionalSkill,
			@PathVariable("id") Long id) {
		LOGGER.info("FROM class ProfileStockServiceController,method : updateSingleProfessionalSkills()--ENTER--ID : "
				+ id);
		restTemplate.put(UPDATE_SINGLE_PROFESSIONAL_SKILLS_URL + id, professionalSkill);
		return ResponseEntity.ok().body("success update");

	}

	// ----------------------------------------------------------------------------------------------------

	// START COLLEGE METHOD
	@RequestMapping(value = "/college/add")
	public ResponseEntity<?> collegeAdd(@RequestBody College college) {
		LOGGER.info(
				"From class ProfileAboutRouteController,method : collegeAdd()--ENTER--college : "
						+ college.getCollege());

		College responseEntity = restTemplate.postForObject(COLLEGE_ADD_URL, college,
				College.class);
		return ResponseEntity.ok().body(responseEntity);
	}

	// ---------------------
	// GET ALL COLLEGE
	@RequestMapping(value = "/college/getAll/{uid}")
	public ResponseEntity<?> getAllCollege(@PathVariable("uid") String uid) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getAllCollege()--ENTER--UID : " + uid);

		ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_COLLEGE_URL + uid,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
				});

		return profilePhotosEntities;

	}

	// ---------------------

	// GET COLLEGE BY ID
	@RequestMapping(value = "/college/single/{id}")
	public ResponseEntity<?> getSingleCollege(@PathVariable("id") Long id) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getSingleCollege()--ENTER--ID : " + id);

		ResponseEntity<College> responseEntity = restTemplate.exchange(
				GET_SINGLE_COLLEGE_URL + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<College>() {
				});

		return responseEntity;

	}

	// ---------------------

	// DELETE COLLEGE BY ID
	@RequestMapping(value = "/college/single/delete/{id}")
	public ResponseEntity<?> getSingleDELETECollege(@PathVariable("id") Long id) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getSingleDELETECollege()--ENTER--ID : "
						+ id);

		ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_COLLEGE_URL + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				});

		return profilePhotosEntity;

	}

	// ---------------------

	// UPDATE COLLEGE BY ID
	@RequestMapping(value = "/college/update/{id}")
	public ResponseEntity<?> updateSingleCollege(@RequestBody College college,
			@PathVariable("id") Long id) {
		LOGGER.info("FROM class ProfileStockServiceController,method : updateSingleCollege()--ENTER--ID : "
				+ id);
		restTemplate.put(UPDATE_SINGLE_COLLEGE_URL + id, college);
		return ResponseEntity.ok().body("success update");

	}

	
	// ----------------------------------------------------------------------------------------------------

	// START HIGHSCHOOL METHOD
	@RequestMapping(value = "/highSchool/add")
	public ResponseEntity<?> highSchoolAdd(@RequestBody HighSchool highSchool) {
		LOGGER.info(
				"From class ProfileAboutRouteController,method : highSchoolAdd()--ENTER--highSchool : "
						+ highSchool.getHighSchool());

		HighSchool responseEntity = restTemplate.postForObject(HIGHSCHOOL_ADD_URL,highSchool,
				HighSchool.class);
		return ResponseEntity.ok().body(responseEntity);
	}

	// ---------------------
	// GET ALL HIGH SCHOOL
	@RequestMapping(value = "/highSchool/getAll/{uid}")
	public ResponseEntity<?> getAllHighSchool(@PathVariable("uid") String uid) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getAllHighSchool()--ENTER--UID : " + uid);

		ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_HIGHSCHOOL_URL + uid,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
				});

		return profilePhotosEntities;

	}

	// ---------------------

	// GET HIGH SCHOOL BY ID
	@RequestMapping(value = "/highSchool/single/{id}")
	public ResponseEntity<?> getSingleHighSchool(@PathVariable("id") Long id) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getSingleHighSchool()--ENTER--ID : " + id);

		ResponseEntity<HighSchool> responseEntity = restTemplate.exchange(
				GET_SINGLE_HIGHSCHOOL_URL + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<HighSchool>() {
				});

		return responseEntity;

	}

	// ---------------------

	// DELETE HIGH SCHOOL BY ID
	@RequestMapping(value = "/highSchool/single/delete/{id}")
	public ResponseEntity<?> getSingleDELETEHighSchool(@PathVariable("id") Long id) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getSingleDELETEHighSchool()--ENTER--ID : "
						+ id);

		ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_HIGHSCHOOL_URL + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				});

		return profilePhotosEntity;

	}

	// ---------------------

	// UPDATE HIGH SCHOOL BY ID
	@RequestMapping(value = "/highSchool/update/{id}")
	public ResponseEntity<?> updateSingleHighSchool(@RequestBody HighSchool highSchool,
			@PathVariable("id") Long id) {
		LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglehigHSchool()--ENTER--ID : "
				+ id);
		restTemplate.put(UPDATE_SINGLE_HIGHSCHOOL_URL + id, highSchool);
		return ResponseEntity.ok().body("success update");

	}

	
}
