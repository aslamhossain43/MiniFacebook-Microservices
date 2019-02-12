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
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
HighSchoolRepository highSchoolRepository;
//COLLEGE ADD URL
private static final String HIGHSCHOOL_ADD_URL="http://about-service/aboutService-post/highSchool/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
CurrentCityRepository currentCityRepository;
//CURRENT CITY ADD URL
private static final String CURRENT_CITY_ADD_URL="http://about-service/aboutService-post/currentCity/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
HomeTownRepository homeTownRepository;
//HOME TOWN ADD URL
private static final String HOMETOWN_ADD_URL="http://about-service/aboutService-post/homeTown/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
OtherPlacesLivedRepository otherPlacesLivedRepository;
//HOME TOWN ADD URL
private static final String OTHERPLACESLIVED_ADD_URL="http://about-service/aboutService-post/otherPlacesLived/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
ContactInformationRepository contactInformationRepository;
//CONTACT INFORMATION ADD URL
private static final String CONTACTINFORMATION_ADD_URL="http://about-service/aboutService-post/contactInformation/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
WebSiteAndSocialLinkRepository webSiteAndSocialLinkRepository;
//WEBSITE AND SOCIAL LINK ADD URL
private static final String WEBSITE_AND_SOCIAL_LINK_ADD_URL="http://about-service/aboutService-post/webSiteAndSocialLink/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
BasicInformationRepository basicInformationRepository;
//BASIC INFORMATION ADD URL
private static final String BASIC_INFORMATION_ADD_URL="http://about-service/aboutService-post/basicInformation/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
RelationShipRepository relationShipRepository;
//RELATION SHIP ADD URL
private static final String RELATIONSHIP_ADD_URL="http://about-service/aboutService-post/relationShip/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
FamilyMembersRepository familyMembersRepository;
//FAMILY MEMBERS ADD URL
private static final String FAMILYMEMBERS_ADD_URL="http://about-service/aboutService-post/familyMembers/add";
//------------------------------------------------------------------------------------------------------
//REPOSITORY
@Autowired
FavoriteQuotesRepository favoriteQuotesRepository;
//FAVORITE QUOTES ADD URL
private static final String FAVORITE_QUOTES_ADD_URL="http://about-service/aboutService-post/favoriteQuotes/add";
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






//-------------------------------------------------------------------------------------------------------------------
	// HIGH SCHOOL ADD
@HystrixCommand(fallbackMethod="highSchoolAddFallBack")
@PostMapping(value="/highSchool/add")
public ResponseEntity<HighSchool>addHighSchool(@RequestBody HighSchool highSchool){
	LOGGER.info("From class AboutPOSTController,method : addHighSchool()--ENTER--");
	HighSchool highSchool2=restTemplate.postForObject(HIGHSCHOOL_ADD_URL,highSchool,HighSchool.class);
	return ResponseEntity.ok().body(highSchool2);
}

//HYSTRIX HIGH SCHOOL ADD
public ResponseEntity<HighSchool>highSchoolAddFallBack(@RequestBody HighSchool highSchool){
	LOGGER.info("From class AboutPOSTController,method : hgighSchoolAddFallBack()--ENTER--");
	highSchoolRepository.save(highSchool);
	return ResponseEntity.ok().body(highSchool);
}





//-------------------------------------------------------------------------------------------------------------------
	// CURRENT CITY ADD
@HystrixCommand(fallbackMethod="fallbackCurrentCityAddFallBack")
@PostMapping(value="/currentCity/add")
public ResponseEntity<CurrentCity>addCurrentCity(@RequestBody CurrentCity currentCity){
	LOGGER.info("From class AboutPOSTController,method : addCurrentCity()--ENTER--");
	CurrentCity currentCity2=restTemplate.postForObject(CURRENT_CITY_ADD_URL,currentCity,CurrentCity.class);
	return ResponseEntity.ok().body(currentCity2);
}

//HYSTRIX fallbackCurrentCityAddFallBack ADD
public ResponseEntity<CurrentCity>fallbackCurrentCityAddFallBack(@RequestBody CurrentCity currentCity){
	LOGGER.info("From class AboutPOSTController,method : fallbackCurrentCityAddFallBack()--ENTER--");
	currentCityRepository.save(currentCity);
	return ResponseEntity.ok().body(currentCity);
}


//-------------------------------------------------------------------------------------------------------------------
	// HOME TOWN ADD
@HystrixCommand(fallbackMethod="fallbackHomeTownAddFallBack")
@PostMapping(value="/homeTown/add")
public ResponseEntity<HomeTown>addHomeTown(@RequestBody HomeTown homeTown){
	LOGGER.info("From class AboutPOSTController,method : addHomeTown()--ENTER--");
	HomeTown homeTown2=restTemplate.postForObject(HOMETOWN_ADD_URL,homeTown,HomeTown.class);
	return ResponseEntity.ok().body(homeTown2);
}

//HYSTRIX fallbackHomeTownAddFallBack ADD
public ResponseEntity<HomeTown>fallbackHomeTownAddFallBack(@RequestBody HomeTown homeTown){
	LOGGER.info("From class AboutPOSTController,method : fallbackHomeTownAddFallBack()--ENTER--");
	homeTownRepository.save(homeTown);
	return ResponseEntity.ok().body(homeTown);
}

//-------------------------------------------------------------------------------------------------------------------
	// OTHER PLACES LIVED ADD
@HystrixCommand(fallbackMethod="fallbackOtherplacesLivedAddFallBack")
@PostMapping(value="/otherPlacesLived/add")
public ResponseEntity<OtherPlacesLived>addotherPlacesLived(@RequestBody OtherPlacesLived otherPlacesLived){
	LOGGER.info("From class AboutPOSTController,method : addotherPlacesLived()--ENTER--");
	OtherPlacesLived otherPlacesLived2=restTemplate.postForObject(OTHERPLACESLIVED_ADD_URL,otherPlacesLived,OtherPlacesLived.class);
	return ResponseEntity.ok().body(otherPlacesLived2);
}

//HYSTRIX fallbackOtherplacesLivedAddFallBack ADD
public ResponseEntity<OtherPlacesLived>fallbackOtherplacesLivedAddFallBack(@RequestBody OtherPlacesLived otherPlacesLived){
	LOGGER.info("From class AboutPOSTController,method : fallbackOtherplacesLivedAddFallBack()--ENTER--");
	otherPlacesLivedRepository.save(otherPlacesLived);
	return ResponseEntity.ok().body(otherPlacesLived);
}


//-------------------------------------------------------------------------------------------------------------------
	// CONTACT INFORMATION ADD
@HystrixCommand(fallbackMethod="fallbackcontactInformationAddFallBack")
@PostMapping(value="/contactInformation/add")
public ResponseEntity<ContactInformation>addcontactInformation(@RequestBody ContactInformation contactInformation){
	LOGGER.info("From class AboutPOSTController,method : addcontactInformation()--ENTER--");
	ContactInformation contactInformation2=restTemplate.postForObject(CONTACTINFORMATION_ADD_URL,contactInformation,ContactInformation.class);
	return ResponseEntity.ok().body(contactInformation2);
}

//HYSTRIX fallbackcontactInformationAddFallBack ADD
public ResponseEntity<ContactInformation>fallbackcontactInformationAddFallBack(@RequestBody ContactInformation contactInformation){
	LOGGER.info("From class AboutPOSTController,method : fallbackcontactInformationAddFallBack()--ENTER--");
	contactInformationRepository.save(contactInformation);
	return ResponseEntity.ok().body(contactInformation);
}



//-------------------------------------------------------------------------------------------------------------------
	// WEBSITE AND SOCIAL LINK ADD
@HystrixCommand(fallbackMethod="fallbackwebSiteAndSocialLinkAddFallBack")
@PostMapping(value="/webSiteAndSocialLink/add")
public ResponseEntity<WebSiteAndSocialLink>addwebSiteAndSocialLink(@RequestBody WebSiteAndSocialLink webSiteAndSocialLink){
	LOGGER.info("From class AboutPOSTController,method : addwebSiteAndSocialLink()--ENTER--");
	WebSiteAndSocialLink webSiteAndSocialLink2=restTemplate.postForObject(WEBSITE_AND_SOCIAL_LINK_ADD_URL,webSiteAndSocialLink,WebSiteAndSocialLink.class);
	return ResponseEntity.ok().body(webSiteAndSocialLink2);
}

//HYSTRIX fallbackwebSiteAndSocialLinkAddFallBack ADD
public ResponseEntity<WebSiteAndSocialLink>fallbackwebSiteAndSocialLinkAddFallBack(@RequestBody WebSiteAndSocialLink webSiteAndSocialLink){
	LOGGER.info("From class AboutPOSTController,method : fallbackwebSiteAndSocialLinkAddFallBack()--ENTER--");
	webSiteAndSocialLinkRepository.save(webSiteAndSocialLink);
	return ResponseEntity.ok().body(webSiteAndSocialLink);
}


//-------------------------------------------------------------------------------------------------------------------
	// BASIC INFORMATON ADD
@HystrixCommand(fallbackMethod="fallbackbasicInformationAddFallBack")
@PostMapping(value="/basicInformation/add")
public ResponseEntity<BasicInformation>addbasicInformation(@RequestBody BasicInformation basicInformation){
	LOGGER.info("From class AboutPOSTController,method : addbasicInformation()--ENTER--");
	BasicInformation basicInformation2=restTemplate.postForObject(BASIC_INFORMATION_ADD_URL,basicInformation,BasicInformation.class);
	return ResponseEntity.ok().body(basicInformation2);
}

//HYSTRIX fallbackbasicInformationAddFallBack ADD
public ResponseEntity<BasicInformation>fallbackbasicInformationAddFallBack(@RequestBody BasicInformation basicInformation){
	LOGGER.info("From class AboutPOSTController,method : fallbackbasicInformationAddFallBack()--ENTER--");
	basicInformationRepository.save(basicInformation);
	return ResponseEntity.ok().body(basicInformation);
}



//-------------------------------------------------------------------------------------------------------------------
	// RELATION SHIP ADD
@HystrixCommand(fallbackMethod="fallbackrelationShipAddFallBack")
@PostMapping(value="/relationShip/add")
public ResponseEntity<RelationShip>addrelationShip(@RequestBody RelationShip relationShip){
	LOGGER.info("From class AboutPOSTController,method : addrelationShip()--ENTER--");
	RelationShip relationShip2=restTemplate.postForObject(RELATIONSHIP_ADD_URL,relationShip,RelationShip.class);
	return ResponseEntity.ok().body(relationShip2);
}

//HYSTRIX fallbackrelationShipAddFallBack ADD
public ResponseEntity<RelationShip>fallbackrelationShipAddFallBack(@RequestBody RelationShip relationShip){
	LOGGER.info("From class AboutPOSTController,method : fallbackrelationShipAddFallBack()--ENTER--");
	relationShipRepository.save(relationShip);
	return ResponseEntity.ok().body(relationShip);
}


		
//-------------------------------------------------------------------------------------------------------------------
	// FAMILY MEMBERS ADD
@HystrixCommand(fallbackMethod="fallbackfamilyMembersAddFallBack")
@PostMapping(value="/familyMembers/add")
public ResponseEntity<FamilyMembers>addfamilyMembers(@RequestBody FamilyMembers familyMembers){
	LOGGER.info("From class AboutPOSTController,method : addfamilyMembers()--ENTER--");
	FamilyMembers familyMembers2=restTemplate.postForObject(FAMILYMEMBERS_ADD_URL,familyMembers,FamilyMembers.class);
	return ResponseEntity.ok().body(familyMembers2);
}

//HYSTRIX fallbackfamilyMembersAddFallBack ADD
public ResponseEntity<FamilyMembers>fallbackfamilyMembersAddFallBack(@RequestBody FamilyMembers familyMembers){
	LOGGER.info("From class AboutPOSTController,method : fallbackfamilyMembersAddFallBack()--ENTER--");
	familyMembersRepository.save(familyMembers);
	return ResponseEntity.ok().body(familyMembers);
}

//-------------------------------------------------------------------------------------------------------------------
	// FAVORITE QUOTES ADD
@HystrixCommand(fallbackMethod="fallbackfavoriteQuotesAddFallBack")
@PostMapping(value="/favoriteQuotes/add")
public ResponseEntity<FavoriteQoutes>addfavoriteQuotes(@RequestBody FavoriteQoutes favoriteQoutes){
	LOGGER.info("From class AboutPOSTController,method : addfavoriteQuotes()--ENTER--");
	FavoriteQoutes favoriteQoutes2=restTemplate.postForObject(FAVORITE_QUOTES_ADD_URL,favoriteQoutes,FavoriteQoutes.class);
	return ResponseEntity.ok().body(favoriteQoutes2);
}

//HYSTRIX fallbackfavoriteQuotesAddFallBack ADD
public ResponseEntity<FavoriteQoutes>fallbackfavoriteQuotesAddFallBack(@RequestBody FavoriteQoutes favoriteQoutes){
	LOGGER.info("From class AboutPOSTController,method : fallbackfavoriteQuotesAddFallBack()--ENTER--");
	favoriteQuotesRepository.save(favoriteQoutes);
	return ResponseEntity.ok().body(favoriteQoutes);
}


	
	
}
