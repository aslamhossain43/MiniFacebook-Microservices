package com.renu.aboutStock.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.about.config.RibbonConfiguration;
import com.renu.about.models.College;
import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.CollegeRepository;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.WorkPlaceRepository;


@RestController
@RequestMapping(value="/aboutStock-post")
@RibbonClient(name = "aboutStock-service", configuration = RibbonConfiguration.class)
public class AboutPOSTController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutPOSTController.class);
// REST TEMPLATE 
@Autowired
RestTemplate restTemplate;
//------------------------------------------------------------------------------------------------------
// REPOSITORY
@Autowired
WorkPlaceRepository workPlaceRepository;
// WORKPLACE ADD URL
private static final String WORKPLACE_ADD_URL="http://about-service/aboutService-post/workplace/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
ProfessionalSkillRepository professionalSkillRepository;
//PROFESSIONAL SKILLS ADD URL
private static final String PROFESSIONAL_SKILLS_ADD_URL="http://about-service/aboutService-post/professionalSkills/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
CollegeRepository collegeRepository;
//COLLEGE ADD URL
private static final String COLLEGE_ADD_URL="http://about-service/aboutService-post/college/add";
//-------------------------------------------------------------------------------------------------------------------
	// WORKPLACE ADD
@HystrixCommand(fallbackMethod="workplaceAddFallBack")
@PostMapping(value="/workplace/add")
public ResponseEntity<Workplace>addWorkplace(@RequestBody Workplace workplace){
	LOGGER.info("From class AboutPOSTController,method : addWorkplace()--ENTER--");
	Workplace workplace2=restTemplate.postForObject(WORKPLACE_ADD_URL,workplace,Workplace.class);
	return ResponseEntity.ok().body(workplace2);
}

// HYSTRIX WORKPLACE ADD
public ResponseEntity<Workplace>workplaceAddFallBack(@RequestBody Workplace workplace){
	LOGGER.info("From class AboutPOSTController,method : workplaceAddFallBack()--ENTER--");
	workPlaceRepository.save(workplace);
	return ResponseEntity.ok().body(workplace);
}

//-------------------------------------------------------------------------------------------------------------------
	// PROFESSIONAL SKILL ADD
@HystrixCommand(fallbackMethod="professionalSkillsAddFallBack")
@PostMapping(value="/professionalSkills/add")
public ResponseEntity<ProfessionalSkill>addProfessionalSkills(@RequestBody ProfessionalSkill professionalSkill){
	LOGGER.info("From class AboutPOSTController,method : addProfessionalSkills()--ENTER--");
	ProfessionalSkill professionalSkill2=restTemplate.postForObject(PROFESSIONAL_SKILLS_ADD_URL,professionalSkill,ProfessionalSkill.class);
	return ResponseEntity.ok().body(professionalSkill2);
}

//HYSTRIX PROFESSIONAL SKILLS ADD
public ResponseEntity<ProfessionalSkill>professionalSkillsAddFallBack(@RequestBody ProfessionalSkill professionalSkill){
	LOGGER.info("From class AboutPOSTController,method : professionalSkillsAddFallBack()--ENTER--");
	professionalSkillRepository.save(professionalSkill);
	return ResponseEntity.ok().body(professionalSkill);
}





//-------------------------------------------------------------------------------------------------------------------
	// COLLEGE ADD
@HystrixCommand(fallbackMethod="collegeAddFallBack")
@PostMapping(value="/college/add")
public ResponseEntity<College>addCollege(@RequestBody College college){
	LOGGER.info("From class AboutPOSTController,method : addCollege()--ENTER--");
	College college2=restTemplate.postForObject(COLLEGE_ADD_URL,college,College.class);
	return ResponseEntity.ok().body(college2);
}

//HYSTRIX COLLEGE ADD
public ResponseEntity<College>collegeAddFallBack(@RequestBody College college){
	LOGGER.info("From class AboutPOSTController,method : collegeAddFallBack()--ENTER--");
	collegeRepository.save(college);
	return ResponseEntity.ok().body(college);
}





	
	
	
	
}
