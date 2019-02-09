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

import com.renu.about.models.College;
import com.renu.about.models.HighSchool;
import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.CollegeRepository;
import com.renu.about.repositories.HighSchoolRepository;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/about-update")
public class AboutUPDATEController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutUPDATEController.class);
//---------------------------------------------------------------------------------------------------------
@Autowired
WorkPlaceRepository workPlaceRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
ProfessionalSkillRepository professionalSkillRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
CollegeRepository collegeRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
HighSchoolRepository highSchoolRepository;
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/workplace/update/{id}")
public ResponseEntity<String>updateWorkplaceById(@PathVariable Long id,@RequestBody Workplace workplace){
	LOGGER.info("From class AboutUPDATEController,method : updateWorkplaceById()---ENTER--ID : "+id);
    Workplace workplace2=workPlaceRepository.getById(id);
    workplace2.setWorkPlace(workplace.getWorkPlace());
    workPlaceRepository.save(workplace2);
    LOGGER.info("From class AboutUPDATEController,method : updateWorkplaceById()---UPDATED--ID : "+id);
    return ResponseEntity.ok().body("success update !!!");



}
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/professionalSkills/update/{id}")
public ResponseEntity<String>updateProfessionalSkillsById(@PathVariable Long id,@RequestBody ProfessionalSkill professionalSkill){
	LOGGER.info("From class AboutUPDATEController,method : updateProfessionalSkillsById()---ENTER--ID : "+id);
  ProfessionalSkill professionalSkill2=professionalSkillRepository.getById(id);
  professionalSkill2.setProfessionalSkill(professionalSkill.getProfessionalSkill());
  professionalSkillRepository.save(professionalSkill2);
  LOGGER.info("From class AboutUPDATEController,method : updateProfessionalSkillsById()---UPDATED--ID : "+id);
  return ResponseEntity.ok().body("success update !!!");



}

//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/college/update/{id}")
public ResponseEntity<String>updateCollegeById(@PathVariable Long id,@RequestBody College college){
	LOGGER.info("From class AboutUPDATEController,method : updateCollegeById()---ENTER--ID : "+id);
College college2=collegeRepository.getById(id);
college2.setCollege(college.getCollege());
collegeRepository.save(college2);
LOGGER.info("From class AboutUPDATEController,method : updateCollegeById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/highSchool/update/{id}")
public ResponseEntity<String>updateHighSchoolById(@PathVariable Long id,@RequestBody HighSchool highSchool){
	LOGGER.info("From class AboutUPDATEController,method : updateHighSchoolById()---ENTER--ID : "+id);
HighSchool highSchool2=highSchoolRepository.getById(id);
highSchool2.setHighSchool(highSchool.getHighSchool());
highSchoolRepository.save(highSchool2);
LOGGER.info("From class AboutUPDATEController,method : updateHighSchoolById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}

}
