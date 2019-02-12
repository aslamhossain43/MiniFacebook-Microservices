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

import com.renu.zuul.models.BasicInformation;
import com.renu.zuul.models.College;
import com.renu.zuul.models.ContactInformation;
import com.renu.zuul.models.CurrentCity;
import com.renu.zuul.models.FamilyMembers;
import com.renu.zuul.models.FavoriteQoutes;
import com.renu.zuul.models.HighSchool;
import com.renu.zuul.models.HomeTown;
import com.renu.zuul.models.OtherPlacesLived;
import com.renu.zuul.models.ProfessionalSkill;
import com.renu.zuul.models.RelationShip;
import com.renu.zuul.models.WebSiteAndSocialLink;
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
	private static final String GET_ALL_WORKPLACES_URL = "http://aboutStock-service/aboutStock-get/workplace/getAll/";
	private static final String GET_SINGLE_WORKPLACE_URL = "http://aboutStock-service/aboutStock-get/workplace/single/";
	private static final String UPDATE_SINGLE_WORKPLACE_URL = "http://aboutStock-service/aboutStock-update/workplace/update/";
	private static final String DELETE_SINGLE_WORKPLACE_URL = "http://aboutStock-service/aboutStock-delete/workplace/single/delete/";

	// -----------------------------------------------------------------------------------------------------------------------
	// PROFESSIONAL SKILLS ADD URL
	private static final String PROFESSIONAL_SKILLS_ADD_URL = "http://aboutStock-service/aboutStock-post/professionalSkills/add";
	private static final String GET_ALL_PROFESSIONAL_SKILLS_URL = "http://aboutStock-service/aboutStock-get/professionalSkills/getAll/";
	private static final String GET_SINGLE_PROFESSIONAL_SKILLS_URL = "http://aboutStock-service/aboutStock-get/professionalSkills/single/";
	private static final String UPDATE_SINGLE_PROFESSIONAL_SKILLS_URL = "http://aboutStock-service/aboutStock-update/professionalSkills/update/";
	private static final String DELETE_SINGLE_PROFESSIONAL_SKILLS_URL = "http://aboutStock-service/aboutStock-delete/professionalSkills/single/delete/";
	// --------------------------------------------------------------------------------------------------------------------
	// COLLEGE ADD URL
	private static final String COLLEGE_ADD_URL = "http://aboutStock-service/aboutStock-post/college/add";
	private static final String GET_ALL_COLLEGE_URL = "http://aboutStock-service/aboutStock-get/college/getAll/";
	private static final String GET_SINGLE_COLLEGE_URL = "http://aboutStock-service/aboutStock-get/college/single/";
	private static final String UPDATE_SINGLE_COLLEGE_URL = "http://aboutStock-service/aboutStock-update/college/update/";
	private static final String DELETE_SINGLE_COLLEGE_URL = "http://aboutStock-service/aboutStock-delete/college/single/delete/";

	
	// --------------------------------------------------------------------------------------------------------------------
		// HIGH SCHOOL ADD URL
		private static final String HIGHSCHOOL_ADD_URL = "http://aboutStock-service/aboutStock-post/highSchool/add";
		private static final String GET_ALL_HIGHSCHOOL_URL = "http://aboutStock-service/aboutStock-get/highSchool/getAll/";
		private static final String GET_SINGLE_HIGHSCHOOL_URL = "http://aboutStock-service/aboutStock-get/highSchool/single/";
		private static final String UPDATE_SINGLE_HIGHSCHOOL_URL = "http://aboutStock-service/aboutStock-update/highSchool/update/";
		private static final String DELETE_SINGLE_HIGHSCHOOL_URL = "http://aboutStock-service/aboutStock-delete/highSchool/single/delete/";

		// --------------------------------------------------------------------------------------------------------------------
		// CURRENT CITY ADD URL
		private static final String CURRENT_CITY_ADD_URL = "http://aboutStock-service/aboutStock-post/currentCity/add";
		private static final String GET_ALL_CURRENT_CITY_URL = "http://aboutStock-service/aboutStock-get/currentCity/getAll/";
		private static final String GET_SINGLE_CURRENT_CITY_URL = "http://aboutStock-service/aboutStock-get/currentCity/single/";
		
		private static final String UPDATE_SINGLE_CURRENT_CITY_URL = "http://aboutStock-service/aboutStock-update/currentCity/update/";
		
		private static final String DELETE_SINGLE_CURRENT_CITY_URL = "http://aboutStock-service/aboutStock-delete/currentCity/single/delete/";
		// --------------------------------------------------------------------------------------------------------------------
		// HOME TOWN ADD URL
		private static final String HOMETOWN_ADD_URL = "http://aboutStock-service/aboutStock-post/homeTown/add";
		private static final String GET_ALL_HOMETOWN_URL = "http://aboutStock-service/aboutStock-get/homeTown/getAll/";
		private static final String GET_SINGLE_HOMETOWN_URL = "http://aboutStock-service/aboutStock-get/homeTown/single/";
		
		private static final String UPDATE_SINGLE_HOMETOWN_URL = "http://aboutStock-service/aboutStock-update/homeTown/update/";
		
		private static final String DELETE_SINGLE_HOMETOWN_URL = "http://aboutStock-service/aboutStock-delete/homeTown/single/delete/";
		// --------------------------------------------------------------------------------------------------------------------
		// OTHER PLACES LIVED ADD URL
		private static final String OTHERPLACES_LIVED_ADD_URL = "http://aboutStock-service/aboutStock-post/otherPlacesLived/add";
		private static final String GET_ALL_OTHERPLACES_LIVED_URL = "http://aboutStock-service/aboutStock-get/otherPlacesLived/getAll/";
		private static final String GET_SINGLE_OTHERPLACES_LIVED_URL = "http://aboutStock-service/aboutStock-get/otherPlacesLived/single/";
		
		private static final String UPDATE_SINGLE_OTHERPLACES_LIVED_URL = "http://aboutStock-service/aboutStock-update/otherPlacesLived/update/";
		
		private static final String DELETE_SINGLE_OTHERPLACES_LIVED_URL = "http://aboutStock-service/aboutStock-delete/otherPlacesLived/single/delete/";
		// --------------------------------------------------------------------------------------------------------------------
		// CONTACT INFORMATION ADD URL
		private static final String CONTACT_INFORMATION_ADD_URL = "http://aboutStock-service/aboutStock-post/contactInformation/add";
		private static final String GET_ALL_CONTACT_INFORMATION_URL = "http://aboutStock-service/aboutStock-get/contactInformation/getAll/";
		private static final String GET_SINGLE_CONTACT_INFORMATION_URL = "http://aboutStock-service/aboutStock-get/contactInformation/single/";
		
		private static final String UPDATE_SINGLE_CONTACT_INFORMATION_URL = "http://aboutStock-service/aboutStock-update/contactInformation/update/";
		
		private static final String DELETE_SINGLE_CONTACT_INFORMATION_URL = "http://aboutStock-service/aboutStock-delete/contactInformation/single/delete/";
	
		// --------------------------------------------------------------------------------------------------------------------
		// WEBSITE AND SOCIAL LINK ADD URL
		private static final String WEBSITE_AND_SOCIAL_LINK_ADD_URL = "http://aboutStock-service/aboutStock-post/webSiteAndSocialLink/add";
		private static final String GET_ALL_WEBSITE_AND_SOCIAL_LINK_URL = "http://aboutStock-service/aboutStock-get/webSiteAndSocialLink/getAll/";
		private static final String GET_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL = "http://aboutStock-service/aboutStock-get/webSiteAndSocialLink/single/";
		
		private static final String UPDATE_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL = "http://aboutStock-service/aboutStock-update/webSiteAndSocialLink/update/";
		
		private static final String DELETE_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL = "http://aboutStock-service/aboutStock-delete/webSiteAndSocialLink/single/delete/";
		// --------------------------------------------------------------------------------------------------------------------
		// BASIC INFORMATION ADD URL
		private static final String BASIC_INFORMATION_ADD_URL = "http://aboutStock-service/aboutStock-post/basicInformation/add";
		private static final String GET_ALL_BASIC_INFORMATION_URL = "http://aboutStock-service/aboutStock-get/basicInformation/getAll/";
		private static final String GET_SINGLE_BASIC_INFORMATION_URL = "http://aboutStock-service/aboutStock-get/basicInformation/single/";
		
		private static final String UPDATE_SINGLE_BASIC_INFORMATION_URL = "http://aboutStock-service/aboutStock-update/basicInformation/update/";
		
		private static final String DELETE_SINGLE_BASIC_INFORMATION_URL = "http://aboutStock-service/aboutStock-delete/basicInformation/single/delete/";
		// --------------------------------------------------------------------------------------------------------------------
		// RELATION SHIP ADD URL
		private static final String RELATIONSHIP_ADD_URL = "http://aboutStock-service/aboutStock-post/relationShip/add";
		private static final String GET_ALL_RELATIONSHIP_URL = "http://aboutStock-service/aboutStock-get/relationShip/getAll/";
		private static final String GET_SINGLE_RELATIONSHIP_URL = "http://aboutStock-service/aboutStock-get/relationShip/single/";
		
		private static final String UPDATE_SINGLE_RELATIONSHIP_URL = "http://aboutStock-service/aboutStock-update/relationShip/update/";
		
		private static final String DELETE_SINGLE_RELATIONSHIP_URL = "http://aboutStock-service/aboutStock-delete/relationShip/single/delete/";
		// --------------------------------------------------------------------------------------------------------------------
		// FAMILY MEMBERS ADD URL
		private static final String FAMILYMEMBERS_ADD_URL = "http://aboutStock-service/aboutStock-post/familyMembers/add";
		private static final String GET_ALL_FAMILYMEMBERS_URL = "http://aboutStock-service/aboutStock-get/familyMembers/getAll/";
		private static final String GET_SINGLE_FAMILYMEMBERS_URL = "http://aboutStock-service/aboutStock-get/familyMembers/single/";
		
		private static final String UPDATE_SINGLE_FAMILYMEMBERS_URL = "http://aboutStock-service/aboutStock-update/familyMembers/update/";
		
		private static final String DELETE_SINGLE_FAMILYMEMBERS_URL = "http://aboutStock-service/aboutStock-delete/familyMembers/single/delete/";
		// --------------------------------------------------------------------------------------------------------------------
		// FAVORITE QUOTES ADD URL
		private static final String FAVORITEQUOTES_ADD_URL = "http://aboutStock-service/aboutStock-post/favoriteQuotes/add";
		private static final String GET_ALL_FAVORITEQUOTES_URL = "http://aboutStock-service/aboutStock-get/favoriteQuotes/getAll/";
		private static final String GET_SINGLE_FAVORITEQUOTES_URL = "http://aboutStock-service/aboutStock-get/favoriteQuotes/single/";
		
		private static final String UPDATE_SINGLE_FAVORITEQUOTES_URL = "http://aboutStock-service/aboutStock-update/favoriteQuotes/update/";
		
		private static final String DELETE_SINGLE_FAVORITEQUOTES_URL = "http://aboutStock-service/aboutStock-delete/favoriteQuotes/single/delete/";
	
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

	// ----------------------------------------------------------------------------------------------------

		// START CURRENT CITY METHOD
		@RequestMapping(value = "/currentCity/add")
		public ResponseEntity<?> currentCityAdd(@RequestBody CurrentCity currentCity) {
			LOGGER.info(
					"From class ProfileAboutRouteController,method : currentCityAdd()--ENTER--currentCity : "
							+ currentCity.getCurrentCity());

			CurrentCity  responseEntity = restTemplate.postForObject(CURRENT_CITY_ADD_URL,currentCity,
					CurrentCity.class);
			return ResponseEntity.ok().body(responseEntity);
		}

		// ---------------------
		// GET ALL current City
		@RequestMapping(value = "/currentCity/getAll/{uid}")
		public ResponseEntity<?> getAllCurrentCity(@PathVariable("uid") String uid) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getAllCurrentCity()--ENTER--UID : " + uid);

			ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_CURRENT_CITY_URL + uid,
					HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
					});

			return profilePhotosEntities;

		}

		// ---------------------

		// GET current City BY ID
		@RequestMapping(value = "/currentCity/single/{id}")
		public ResponseEntity<?> getSingleCurrentCity(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleCurrentCity()--ENTER--ID : " + id);

			ResponseEntity<CurrentCity> responseEntity = restTemplate.exchange(
					GET_SINGLE_CURRENT_CITY_URL + id, HttpMethod.GET, null,
					new ParameterizedTypeReference<CurrentCity>() {
					});

			return responseEntity;

		}

		// ---------------------

		// DELETE current City BY ID
		@RequestMapping(value = "/currentCity/single/delete/{id}")
		public ResponseEntity<?> getSingleDELETEcurrentCity(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleDELETEcurrentCity()--ENTER--ID : "
							+ id);

			ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_CURRENT_CITY_URL + id,
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
					});

			return profilePhotosEntity;

		}

		// ---------------------

		// UPDATE current City BY ID
		@RequestMapping(value = "/currentCity/update/{id}")
		public ResponseEntity<?> updateSinglecurrentCity(@RequestBody CurrentCity currentCity,
				@PathVariable("id") Long id) {
			LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglehigcurrentCity()--ENTER--ID : "
					+ id);
			restTemplate.put(UPDATE_SINGLE_CURRENT_CITY_URL + id, currentCity);
			return ResponseEntity.ok().body("success update");

		}

		// ----------------------------------------------------------------------------------------------------

		// START HOME TOWN METHOD
		@RequestMapping(value = "/homeTown/add")
		public ResponseEntity<?> homeTownAdd(@RequestBody HomeTown homeTown) {
			LOGGER.info(
					"From class ProfileAboutRouteController,method : homeTownAdd()--ENTER--homeTown : "
							+ homeTown.getHomeTown());

			HomeTown  responseEntity = restTemplate.postForObject(HOMETOWN_ADD_URL,homeTown,
					HomeTown.class);
			return ResponseEntity.ok().body(responseEntity);
		}

		// ---------------------
		// GET ALL homeTown
		@RequestMapping(value = "/homeTown/getAll/{uid}")
		public ResponseEntity<?> getAllHomeTown(@PathVariable("uid") String uid) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getAllHomeTown()--ENTER--UID : " + uid);

			ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_HOMETOWN_URL + uid,
					HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
					});

			return profilePhotosEntities;

		}

		// ---------------------

		// GET homeTown BY ID
		@RequestMapping(value = "/homeTown/single/{id}")
		public ResponseEntity<?> getSingleHomeTown(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleHomeTown()--ENTER--ID : " + id);

			ResponseEntity<HomeTown> responseEntity = restTemplate.exchange(
					GET_SINGLE_HOMETOWN_URL + id, HttpMethod.GET, null,
					new ParameterizedTypeReference<HomeTown>() {
					});

			return responseEntity;

		}

		// ---------------------

		// DELETE homeTown BY ID
		@RequestMapping(value = "/homeTown/single/delete/{id}")
		public ResponseEntity<?> getSingleDELETEhomeTown(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleDELETEhomeTown()--ENTER--ID : "
							+ id);

			ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_HOMETOWN_URL + id,
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
					});

			return profilePhotosEntity;

		}

		// ---------------------

		// UPDATE homeTown BY ID
		@RequestMapping(value = "/homeTown/update/{id}")
		public ResponseEntity<?> updateSingleHomeTown(@RequestBody HomeTown homeTown,
				@PathVariable("id") Long id) {
			LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglehomeTown()--ENTER--ID : "
					+ id);
			restTemplate.put(UPDATE_SINGLE_HOMETOWN_URL + id, homeTown);
			return ResponseEntity.ok().body("success update");

		}

		
		
		// ----------------------------------------------------------------------------------------------------

		// OTHER PLACES LIVED TOWN METHOD
		@RequestMapping(value = "/otherPlacesLived/add")
		public ResponseEntity<?> otherPlacesLivedAdd(@RequestBody OtherPlacesLived otherPlacesLived) {
			LOGGER.info(
					"From class ProfileAboutRouteController,method : otherPlacesLivedAdd()--ENTER--otherPlacesLived : "
							+ otherPlacesLived.getOtherPlacesLived());

			OtherPlacesLived otherPlacesLived2 = restTemplate.postForObject(OTHERPLACES_LIVED_ADD_URL,otherPlacesLived,
					OtherPlacesLived.class);
			return ResponseEntity.ok().body(otherPlacesLived2);
		}

		// ---------------------
		// GET ALL otherPlacesLived
		@RequestMapping(value = "/otherPlacesLived/getAll/{uid}")
		public ResponseEntity<?> getAllOtherPlacesLived(@PathVariable("uid") String uid) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getAllOtherPlacesLived()--ENTER--UID : " + uid);

			ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_OTHERPLACES_LIVED_URL + uid,
					HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
					});

			return profilePhotosEntities;

		}

		// ---------------------

		// GET otherPlacesLived BY ID
		@RequestMapping(value = "/otherPlacesLived/single/{id}")
		public ResponseEntity<?> getSingleOtherPlacesLived(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleOtherPlacesLived()--ENTER--ID : " + id);

			ResponseEntity<OtherPlacesLived> responseEntity = restTemplate.exchange(
					GET_SINGLE_OTHERPLACES_LIVED_URL + id, HttpMethod.GET, null,
					new ParameterizedTypeReference<OtherPlacesLived>() {
					});

			return responseEntity;

		}

		// ---------------------

		// DELETE otherPlacesLived BY ID
		@RequestMapping(value = "/otherPlacesLived/single/delete/{id}")
		public ResponseEntity<?> getSingleDELETEotherPlacesLived(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleDELETEotherPlacesLived()--ENTER--ID : "
							+ id);

			ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_OTHERPLACES_LIVED_URL + id,
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
					});

			return profilePhotosEntity;

		}

		// ---------------------

		// UPDATE otherPlacesLived BY ID
		@RequestMapping(value = "/otherPlacesLived/update/{id}")
		public ResponseEntity<?> updateSingleOtherPlacesLived(@RequestBody OtherPlacesLived otherPlacesLived,
				@PathVariable("id") Long id) {
			LOGGER.info("FROM class ProfileStockServiceController,method : updateSingleOtherPlacesLived()--ENTER--ID : "
					+ id);
			restTemplate.put(UPDATE_SINGLE_OTHERPLACES_LIVED_URL + id, otherPlacesLived);
			return ResponseEntity.ok().body("success update");

		}

		// ----------------------------------------------------------------------------------------------------

		// CONTACT INFORMATION TOWN METHOD
		@RequestMapping(value = "/contactInformation/add")
		public ResponseEntity<?> contactInformationAdd(@RequestBody ContactInformation contactInformation) {
			LOGGER.info(
					"From class ProfileAboutRouteController,method : contactInformationAdd()--ENTER--contactInformation : "
							+ contactInformation.getContactInformation());

			ContactInformation contactInformation2 = restTemplate.postForObject(CONTACT_INFORMATION_ADD_URL,contactInformation,
					ContactInformation.class);
			return ResponseEntity.ok().body(contactInformation2);
		}

		// ---------------------
		// GET ALL contactInformation
		@RequestMapping(value = "/contactInformation/getAll/{uid}")
		public ResponseEntity<?> getAllContactInformation(@PathVariable("uid") String uid) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getAllcontactInformation()--ENTER--UID : " + uid);

			ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_CONTACT_INFORMATION_URL + uid,
					HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
					});

			return profilePhotosEntities;

		}

		// ---------------------

		// GET contactInformation BY ID
		@RequestMapping(value = "/contactInformation/single/{id}")
		public ResponseEntity<?> getSinglecontactInformation(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSinglecontactInformation()--ENTER--ID : " + id);

			ResponseEntity<ContactInformation> responseEntity = restTemplate.exchange(
					GET_SINGLE_CONTACT_INFORMATION_URL + id, HttpMethod.GET, null,
					new ParameterizedTypeReference<ContactInformation>() {
					});

			return responseEntity;

		}

		// ---------------------

		// DELETE contactInformation BY ID
		@RequestMapping(value = "/contactInformation/single/delete/{id}")
		public ResponseEntity<?> getSingleDELETEcontactInformation(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleDELETEcontactInformation()--ENTER--ID : "
							+ id);

			ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_CONTACT_INFORMATION_URL + id,
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
					});

			return profilePhotosEntity;

		}

		// ---------------------

		// UPDATE contactInformation BY ID
		@RequestMapping(value = "/contactInformation/update/{id}")
		public ResponseEntity<?> updateSinglecontactInformation(@RequestBody ContactInformation contactInformation,
				@PathVariable("id") Long id) {
			LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglecontactInformation()--ENTER--ID : "
					+ id);
			restTemplate.put(UPDATE_SINGLE_CONTACT_INFORMATION_URL + id, contactInformation);
			return ResponseEntity.ok().body("success update");

		}

		

		// ----------------------------------------------------------------------------------------------------

		// WEBSITE AND SOCIAL LINK METHOD
		@RequestMapping(value = "/webSiteAndSocialLink/add")
		public ResponseEntity<?> webSiteAndSocialLinkAdd(@RequestBody WebSiteAndSocialLink webSiteAndSocialLink) {
			LOGGER.info(
					"From class ProfileAboutRouteController,method : webSiteAndSocialLinkAdd()--ENTER--webSiteAndSocialLink : "
							+ webSiteAndSocialLink.getWebSiteAndSocialLink());

			WebSiteAndSocialLink webSiteAndSocialLink2 = restTemplate.postForObject(WEBSITE_AND_SOCIAL_LINK_ADD_URL,webSiteAndSocialLink,
					WebSiteAndSocialLink.class);
			return ResponseEntity.ok().body(webSiteAndSocialLink2);
		}

		// ---------------------
		// GET ALL webSiteAndSocialLink
		@RequestMapping(value = "/webSiteAndSocialLink/getAll/{uid}")
		public ResponseEntity<?> getAllwebSiteAndSocialLink(@PathVariable("uid") String uid) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getAllwebSiteAndSocialLink()--ENTER--UID : " + uid);

			ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_WEBSITE_AND_SOCIAL_LINK_URL + uid,
					HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
					});

			return profilePhotosEntities;

		}

		// ---------------------

		// GET webSiteAndSocialLink BY ID
		@RequestMapping(value = "/webSiteAndSocialLink/single/{id}")
		public ResponseEntity<?> getSinglewebSiteAndSocialLink(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSinglewebSiteAndSocialLink()--ENTER--ID : " + id);

			ResponseEntity<WebSiteAndSocialLink> responseEntity = restTemplate.exchange(
					GET_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL + id, HttpMethod.GET, null,
					new ParameterizedTypeReference<WebSiteAndSocialLink>() {
					});

			return responseEntity;

		}

		// ---------------------

		// DELETE webSiteAndSocialLink BY ID
		@RequestMapping(value = "/webSiteAndSocialLink/single/delete/{id}")
		public ResponseEntity<?> getSingleDELETEwebSiteAndSocialLink(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleDELETEwebSiteAndSocialLink()--ENTER--ID : "
							+ id);

			ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL + id,
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
					});

			return profilePhotosEntity;

		}

		// ---------------------

		// UPDATE webSiteAndSocialLink BY ID
		@RequestMapping(value = "/webSiteAndSocialLink/update/{id}")
		public ResponseEntity<?> updateSinglewebSiteAndSocialLink(@RequestBody WebSiteAndSocialLink webSiteAndSocialLink,
				@PathVariable("id") Long id) {
			LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglewebSiteAndSocialLink()--ENTER--ID : "
					+ id);
			restTemplate.put(UPDATE_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL + id, webSiteAndSocialLink);
			return ResponseEntity.ok().body("success update");

		}
			
		// ----------------------------------------------------------------------------------------------------

		// BASIC INFORMATION METHOD
		@RequestMapping(value = "/basicInformation/add")
		public ResponseEntity<?> basicInformationAdd(@RequestBody BasicInformation basicInformation) {
			LOGGER.info(
					"From class ProfileAboutRouteController,method : basicInformationAdd()--ENTER--basicInformation : "
							+ basicInformation.getBasicInformation());

			BasicInformation basicInformation2 = restTemplate.postForObject(BASIC_INFORMATION_ADD_URL,basicInformation,
					BasicInformation.class);
			return ResponseEntity.ok().body(basicInformation2);
		}

		// ---------------------
		// GET ALL basicInformation
		@RequestMapping(value = "/basicInformation/getAll/{uid}")
		public ResponseEntity<?> getAllbasicInformation(@PathVariable("uid") String uid) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getAllbasicInformation()--ENTER--UID : " + uid);

			ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_BASIC_INFORMATION_URL + uid,
					HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
					});

			return profilePhotosEntities;

		}

		// ---------------------

		// GET basicInformation BY ID
		@RequestMapping(value = "/basicInformation/single/{id}")
		public ResponseEntity<?> getSinglebasicInformation(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSinglebasicInformation()--ENTER--ID : " + id);

			ResponseEntity<BasicInformation> responseEntity = restTemplate.exchange(
					GET_SINGLE_BASIC_INFORMATION_URL + id, HttpMethod.GET, null,
					new ParameterizedTypeReference<BasicInformation>() {
					});

			return responseEntity;

		}

		// ---------------------

		// DELETE basicInformation BY ID
		@RequestMapping(value = "/basicInformation/single/delete/{id}")
		public ResponseEntity<?> getSingleDELETEbasicInformation(@PathVariable("id") Long id) {
			LOGGER.info(
					"FROM class ProfileStockServiceController,method : getSingleDELETEbasicInformation()--ENTER--ID : "
							+ id);

			ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_BASIC_INFORMATION_URL + id,
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
					});

			return profilePhotosEntity;

		}

		// ---------------------

		// UPDATE basicInformation BY ID
		@RequestMapping(value = "/basicInformation/update/{id}")
		public ResponseEntity<?> updateSinglebasicInformation(@RequestBody BasicInformation basicInformation,
				@PathVariable("id") Long id) {
			LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglebasicInformation()--ENTER--ID : "
					+ id);
			restTemplate.put(UPDATE_SINGLE_BASIC_INFORMATION_URL + id, basicInformation);
			return ResponseEntity.ok().body("success update");

		}

		
	// ----------------------------------------------------------------------------------------------------

	// RELATION SHIP METHOD
	@RequestMapping(value = "/relationShip/add")
	public ResponseEntity<?> relationShipAdd(@RequestBody RelationShip relationShip) {
		LOGGER.info(
				"From class ProfileAboutRouteController,method : relationShipAdd()--ENTER--relationShip : "
						+ relationShip.getRelationShip());

		RelationShip relationShip2 = restTemplate.postForObject(RELATIONSHIP_ADD_URL,relationShip,
				RelationShip.class);
		return ResponseEntity.ok().body(relationShip2);
	}

	// ---------------------
	// GET ALL relationShip
	@RequestMapping(value = "/relationShip/getAll/{uid}")
	public ResponseEntity<?> getAllrelationShip(@PathVariable("uid") String uid) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getAllrelationShip()--ENTER--UID : " + uid);

		ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_RELATIONSHIP_URL + uid,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
				});

		return profilePhotosEntities;

	}

	// ---------------------

	// GET relationShip BY ID
	@RequestMapping(value = "/relationShip/single/{id}")
	public ResponseEntity<?> getSinglerelationShip(@PathVariable("id") Long id) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getSinglerelationShip()--ENTER--ID : " + id);

		ResponseEntity<RelationShip> responseEntity = restTemplate.exchange(
				GET_SINGLE_RELATIONSHIP_URL + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<RelationShip>() {
				});

		return responseEntity;

	}

	// ---------------------

	// DELETE relationShip BY ID
	@RequestMapping(value = "/relationShip/single/delete/{id}")
	public ResponseEntity<?> getSingleDELETErelationShip(@PathVariable("id") Long id) {
		LOGGER.info(
				"FROM class ProfileStockServiceController,method : getSingleDELETErelationShip()--ENTER--ID : "
						+ id);

		ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_RELATIONSHIP_URL + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				});

		return profilePhotosEntity;

	}

	// ---------------------

	// UPDATE relationShip BY ID
	@RequestMapping(value = "/relationShip/update/{id}")
	public ResponseEntity<?> updateSinglerelationShip(@RequestBody RelationShip relationShip,
			@PathVariable("id") Long id) {
		LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglerelationShip()--ENTER--ID : "
				+ id);
		restTemplate.put(UPDATE_SINGLE_RELATIONSHIP_URL + id, relationShip);
		return ResponseEntity.ok().body("success update");

	}
	
	
// ----------------------------------------------------------------------------------------------------

// FAMILY MEMBERS METHOD
@RequestMapping(value = "/familyMembers/add")
public ResponseEntity<?> familyMembersAdd(@RequestBody FamilyMembers familyMembers) {
	LOGGER.info(
			"From class ProfileAboutRouteController,method : familyMembersAdd()--ENTER--familyMembers : "
					+ familyMembers.getFamilyMembers());

	FamilyMembers familyMembers2 = restTemplate.postForObject(FAMILYMEMBERS_ADD_URL,familyMembers,
			FamilyMembers.class);
	return ResponseEntity.ok().body(familyMembers2);
}

// ---------------------
// GET ALL familyMembers
@RequestMapping(value = "/familyMembers/getAll/{uid}")
public ResponseEntity<?> getAllfamilyMembers(@PathVariable("uid") String uid) {
	LOGGER.info(
			"FROM class ProfileStockServiceController,method : getAllfamilyMembers()--ENTER--UID : " + uid);

	ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_FAMILYMEMBERS_URL + uid,
			HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
			});

	return profilePhotosEntities;

}

// ---------------------

// GET familyMembers BY ID
@RequestMapping(value = "/familyMembers/single/{id}")
public ResponseEntity<?> getSinglefamilyMembers(@PathVariable("id") Long id) {
	LOGGER.info(
			"FROM class ProfileStockServiceController,method : getSinglefamilyMembers()--ENTER--ID : " + id);

	ResponseEntity<FamilyMembers> responseEntity = restTemplate.exchange(
			GET_SINGLE_FAMILYMEMBERS_URL + id, HttpMethod.GET, null,
			new ParameterizedTypeReference<FamilyMembers>() {
			});

	return responseEntity;

}

// ---------------------

// DELETE familyMembers BY ID
@RequestMapping(value = "/familyMembers/single/delete/{id}")
public ResponseEntity<?> getSingleDELETEfamilyMembers(@PathVariable("id") Long id) {
	LOGGER.info(
			"FROM class ProfileStockServiceController,method : getSingleDELETEfamilyMembers()--ENTER--ID : "
					+ id);

	ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_FAMILYMEMBERS_URL + id,
			HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
			});

	return profilePhotosEntity;

}

// ---------------------

// UPDATE familyMembers BY ID
@RequestMapping(value = "/familyMembers/update/{id}")
public ResponseEntity<?> updateSinglefamilyMembers(@RequestBody FamilyMembers familyMembers,
		@PathVariable("id") Long id) {
	LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglefamilyMembers()--ENTER--ID : "
			+ id);
	restTemplate.put(UPDATE_SINGLE_FAMILYMEMBERS_URL + id, familyMembers);
	return ResponseEntity.ok().body("success update");

}

//----------------------------------------------------------------------------------------------------

//FAVORITE QUOTES METHOD
@RequestMapping(value = "/favoriteQuotes/add")
public ResponseEntity<?> favoriteQuotesAdd(@RequestBody FavoriteQoutes favoriteQoutes) {
	LOGGER.info(
			"From class ProfileAboutRouteController,method : favoriteQuotesAdd()--ENTER--favoriteQuotes : "
					+ favoriteQoutes.getFavoriteQuote());

	FavoriteQoutes favoriteQoutes2 = restTemplate.postForObject(FAVORITEQUOTES_ADD_URL,favoriteQoutes,
			FavoriteQoutes.class);
	return ResponseEntity.ok().body(favoriteQoutes2);
}

//---------------------
//GET ALL favoriteQuotes
@RequestMapping(value = "/favoriteQuotes/getAll/{uid}")
public ResponseEntity<?> getAllfavoriteQuotes(@PathVariable("uid") String uid) {
	LOGGER.info(
			"FROM class ProfileStockServiceController,method : getAllfavoriteQuotes()--ENTER--UID : " + uid);

	ResponseEntity<List<?>> profilePhotosEntities = restTemplate.exchange(GET_ALL_FAVORITEQUOTES_URL + uid,
			HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
			});

	return profilePhotosEntities;

}

//---------------------

//GET favoriteQuotes BY ID
@RequestMapping(value = "/favoriteQuotes/single/{id}")
public ResponseEntity<?> getSinglefavoriteQuotes(@PathVariable("id") Long id) {
	LOGGER.info(
			"FROM class ProfileStockServiceController,method : getSinglefavoriteQuotes()--ENTER--ID : " + id);

	ResponseEntity<FavoriteQoutes> responseEntity = restTemplate.exchange(
			GET_SINGLE_FAVORITEQUOTES_URL + id, HttpMethod.GET, null,
			new ParameterizedTypeReference<FavoriteQoutes>() {
			});

	return responseEntity;

}

//---------------------

//DELETE favoriteQuotes BY ID
@RequestMapping(value = "/favoriteQuotes/single/delete/{id}")
public ResponseEntity<?> getSingleDELETEfavoriteQuotes(@PathVariable("id") Long id) {
	LOGGER.info(
			"FROM class ProfileStockServiceController,method : getSingleDELETEfavoriteQuotes()--ENTER--ID : "
					+ id);

	ResponseEntity<String> profilePhotosEntity = restTemplate.exchange(DELETE_SINGLE_FAVORITEQUOTES_URL + id,
			HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
			});

	return profilePhotosEntity;

}

//---------------------

//UPDATE favoriteQuotes BY ID
@RequestMapping(value = "/favoriteQuotes/update/{id}")
public ResponseEntity<?> updateSinglefavoriteQuotes(@RequestBody FavoriteQoutes favoriteQoutes,
		@PathVariable("id") Long id) {
	LOGGER.info("FROM class ProfileStockServiceController,method : updateSinglefavoriteQuotes()--ENTER--ID : "
			+ id);
	restTemplate.put(UPDATE_SINGLE_FAVORITEQUOTES_URL + id, favoriteQoutes);
	return ResponseEntity.ok().body("success update");

}

		
}
