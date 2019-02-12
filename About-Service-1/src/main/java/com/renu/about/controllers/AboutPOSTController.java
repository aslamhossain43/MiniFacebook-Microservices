package com.renu.about.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.about.models.BasicInformation;
import com.renu.about.models.College;
import com.renu.about.models.ContactInformation;
import com.renu.about.models.CurrentCity;
import com.renu.about.models.FamilyMembers;
import com.renu.about.models.FavoriteQoutes;
import com.renu.about.models.HighSchool;
import com.renu.about.models.HomeTown;
import com.renu.about.models.OtherPlacesLived;
import com.renu.about.models.ProfessionalSkill;
import com.renu.about.models.RelationShip;
import com.renu.about.models.WebSiteAndSocialLink;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.BasicInformationRepository;
import com.renu.about.repositories.CollegeRepository;
import com.renu.about.repositories.ContactInformationRepository;
import com.renu.about.repositories.CurrentCityRepository;
import com.renu.about.repositories.FamilyMembersRepository;
import com.renu.about.repositories.FavoriteQuotesRepository;
import com.renu.about.repositories.HighSchoolRepository;
import com.renu.about.repositories.HomeTownRepository;
import com.renu.about.repositories.OtherPlacesLivedRepository;
import com.renu.about.repositories.ProfessionalSkillRepository;
import com.renu.about.repositories.RelationShipRepository;
import com.renu.about.repositories.WebSiteAndSocialLinkRepository;
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
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
CollegeRepository collegeRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
HighSchoolRepository highSchoolRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
CurrentCityRepository currentCityRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
HomeTownRepository homeTownRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
OtherPlacesLivedRepository otherPlacesLivedRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
ContactInformationRepository contactInformationRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
WebSiteAndSocialLinkRepository webSiteAndSocialLinkRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
BasicInformationRepository basicInformationRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
RelationShipRepository relationShipRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
FamilyMembersRepository familyMembersRepository;
//--------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
FavoriteQuotesRepository favoriteQuotesRepository;
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
	
	
//----------------------------------------------------------------------------------------------------
	// COLLEGE ADD
@PostMapping(value="/college/add")
public ResponseEntity<College>addCollege(@RequestBody College college){
	LOGGER.info("From class AboutPOSTController,method : addCollege()--ENTER--");
	collegeRepository.save(college);
	LOGGER.info("From class AboutPOSTController,method : addCollege()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(college);
}
	
//----------------------------------------------------------------------------------------------------
	// HIGH SCHOOL ADD
@PostMapping(value="/highSchool/add")
public ResponseEntity<HighSchool>addHighSchool(@RequestBody HighSchool highSchool){
	LOGGER.info("From class AboutPOSTController,method : addHighSchool()--ENTER--");
	highSchoolRepository.save(highSchool);
	LOGGER.info("From class AboutPOSTController,method : addHighSchool()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(highSchool);
}
//----------------------------------------------------------------------------------------------------
	// CURRENT CITY ADD
@PostMapping(value="/currentCity/add")
public ResponseEntity<CurrentCity>addCurrentCity(@RequestBody CurrentCity currentCity){
	LOGGER.info("From class AboutPOSTController,method : addCurrentCity()--ENTER--");
	currentCityRepository.save(currentCity);
	LOGGER.info("From class AboutPOSTController,method : addCurrentCity()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(currentCity);
}
//----------------------------------------------------------------------------------------------------
	// HOME TOWN ADD
@PostMapping(value="/homeTown/add")
public ResponseEntity<HomeTown>addHomeTown(@RequestBody HomeTown homeTown){
	LOGGER.info("From class AboutPOSTController,method : addHomeTown()--ENTER--");
	homeTownRepository.save(homeTown);
	LOGGER.info("From class AboutPOSTController,method : addHomeTown()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(homeTown);
}
//----------------------------------------------------------------------------------------------------
	// OTHER PLACES LIVED ADD
@PostMapping(value="/otherPlacesLived/add")
public ResponseEntity<OtherPlacesLived>addotherPlacesLived(@RequestBody OtherPlacesLived otherPlacesLived){
	LOGGER.info("From class AboutPOSTController,method : addotherPlacesLived()--ENTER--");
	otherPlacesLivedRepository.save(otherPlacesLived);
	LOGGER.info("From class AboutPOSTController,method : addotherPlacesLived()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(otherPlacesLived);
}
//----------------------------------------------------------------------------------------------------
@PostMapping(value="/contactInformation/add")
public ResponseEntity<ContactInformation>addcontactInformation(@RequestBody ContactInformation contactInformation){
	LOGGER.info("From class AboutPOSTController,method : addcontactInformation()--ENTER--");
	contactInformationRepository.save(contactInformation);
	LOGGER.info("From class AboutPOSTController,method : addcontactInformation()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(contactInformation);
}
//----------------------------------------------------------------------------------------------------
@PostMapping(value="/webSiteAndSocialLink/add")
public ResponseEntity<WebSiteAndSocialLink>addwebSiteAndSocialLink(@RequestBody WebSiteAndSocialLink webSiteAndSocialLink){
	LOGGER.info("From class AboutPOSTController,method : addwebSiteAndSocialLink()--ENTER--");
	webSiteAndSocialLinkRepository.save(webSiteAndSocialLink);
	LOGGER.info("From class AboutPOSTController,method : addwebSiteAndSocialLink()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(webSiteAndSocialLink);
}
//----------------------------------------------------------------------------------------------------
@PostMapping(value="/basicInformation/add")
public ResponseEntity<BasicInformation>addbasicInformation(@RequestBody BasicInformation basicInformation){
	LOGGER.info("From class AboutPOSTController,method : addbasicInformation()--ENTER--");
	basicInformationRepository.save(basicInformation);
	LOGGER.info("From class AboutPOSTController,method : addbasicInformation()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(basicInformation);
}
//----------------------------------------------------------------------------------------------------
@PostMapping(value="/relationShip/add")
public ResponseEntity<RelationShip>addrelationShip(@RequestBody RelationShip relationShip){
	LOGGER.info("From class AboutPOSTController,method : addrelationShip()--ENTER--");
	relationShipRepository.save(relationShip);
	LOGGER.info("From class AboutPOSTController,method : addrelationShip()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(relationShip);
}
//----------------------------------------------------------------------------------------------------
@PostMapping(value="/familyMembers/add")
public ResponseEntity<FamilyMembers>addfamilyMembers(@RequestBody FamilyMembers familyMembers){
	LOGGER.info("From class AboutPOSTController,method : addfamilyMembers()--ENTER--");
	familyMembersRepository.save(familyMembers);
	LOGGER.info("From class AboutPOSTController,method : addfamilyMembers()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(familyMembers);
}
//----------------------------------------------------------------------------------------------------
@PostMapping(value="/favoriteQuotes/add")
public ResponseEntity<FavoriteQoutes>addfavoriteQuotes(@RequestBody FavoriteQoutes favoriteQoutes){
	LOGGER.info("From class AboutPOSTController,method : addfavoriteQuotes()--ENTER--");
	favoriteQuotesRepository.save(favoriteQoutes);
	LOGGER.info("From class AboutPOSTController,method : addfavoriteQuotes()--SAVED COLLEGE--");
	
return ResponseEntity.ok().body(favoriteQoutes);
}
		
}
