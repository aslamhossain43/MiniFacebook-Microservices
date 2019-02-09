package com.renu.about.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.about.models.College;
import com.renu.about.models.HighSchool;
import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.CollegeRepository;
import com.renu.about.repositories.HighSchoolRepository;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value = "/about-delete")
public class AboutDELETEController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AboutDELETEController.class);
	// ---------------------------------------------------------------------------------------------------------------
	@Autowired
	WorkPlaceRepository workPlaceRepository;
	// ---------------------------------------------------------------------------------------------------------------
	@Autowired
	ProfessionalSkillRepository professionalSkillRepository;
	// ---------------------------------------------------------------------------------------------------------------
	@Autowired
	CollegeRepository collegeRepository;
	// ---------------------------------------------------------------------------------------------------------------
		@Autowired
		HighSchoolRepository highSchoolRepository;
		
	// ---------------------------------------------------------------------------------------------------------------

	// DELETE WORKPLACE BY ID
	@GetMapping(value = "/workplace/single/delete/{id}")
	public ResponseEntity<String> deleteSingleWorkplaceByID(@PathVariable("id") Long id) {
		LOGGER.info("From class AboutDELETEController,method : deleteSingleWorkplaceByID()--ENTER--ID : " + id);
		Workplace workplace = workPlaceRepository.getById(id);
		workPlaceRepository.delete(workplace);
		LOGGER.info("From class AboutDELETEController,method : deleteSingleWorkplaceByID()--DELETED--ID : " + id);

		return ResponseEntity.ok().body("SuccessCallback delete");
	}

	// ------------------------------------------------------------------------------------------------------------

	// DELETE PROFESSIONA SKILLS BY ID
	@GetMapping(value = "/professionalSkills/single/delete/{id}")
	public ResponseEntity<String> deleteSingleProfessionalSkillsByID(@PathVariable("id") Long id) {
		LOGGER.info(
				"From class AboutDELETEController,method : deleteSingleProfessionalSkillsByID()--ENTER--ID : " + id);
		ProfessionalSkill professionalSkill = professionalSkillRepository.getById(id);
		professionalSkillRepository.delete(professionalSkill);
		LOGGER.info(
				"From class AboutDELETEController,method : deleteSingleProfessionalSkillsByID()--DELETED--ID : " + id);

		return ResponseEntity.ok().body("SuccessCallback delete");
	}

	// ------------------------------------------------------------------------------------------------------------------

	// DELETE COLLEGE BY ID
	@GetMapping(value = "/college/single/delete/{id}")
	public ResponseEntity<String> deleteSingleCollegeByID(@PathVariable("id") Long id) {
		LOGGER.info("From class AboutDELETEController,method : deleteSingleCollegeByID()--ENTER--ID : " + id);
		College college = collegeRepository.getById(id);
		collegeRepository.delete(college);
		;
		LOGGER.info("From class AboutDELETEController,method : deleteSingleCollegeByID()--DELETED--ID : " + id);

		return ResponseEntity.ok().body("SuccessCallback delete");
	}
	
	// ------------------------------------------------------------------------------------------------------------------

		// DELETE COLLEGE BY ID
		@GetMapping(value = "/highSchool/single/delete/{id}")
		public ResponseEntity<String> deleteSingleHighSchoolByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSingleHighSchoolByID()--ENTER--ID : " + id);
			HighSchool highSchool=highSchoolRepository.getById(id);
			highSchoolRepository.delete(highSchool);
			LOGGER.info("From class AboutDELETEController,method : deleteSingleHighSchoolByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}

}
