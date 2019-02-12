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
//--------------------------------------------------------------------------------------------------------------
@Autowired
HighSchoolRepository highSchoolRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
CurrentCityRepository currentCityRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
HomeTownRepository homeTownRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
OtherPlacesLivedRepository otherPlacesLivedRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
ContactInformationRepository contactInformationRepository;

//--------------------------------------------------------------------------------------------------------------
@Autowired
WebSiteAndSocialLinkRepository webSiteAndSocialLinkRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
BasicInformationRepository basicInformationRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
RelationShipRepository relationShipRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
FamilyMembersRepository familyMembersRepository;
//--------------------------------------------------------------------------------------------------------------
@Autowired
FavoriteQuotesRepository favoriteQuotesRepository;

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
//UPDATE HIGH SCHOOL BY URL
private static final String UPDATE_SINGLE_HIGHSCHOOL_URL="http://about-service/about-update/highSchool/update/";
//----------------------------------------------------------------------------------------------------------------
//UPDATE CURRENT CITY BY URL
private static final String UPDATE_SINGLE_CURRENT_CITY_URL="http://about-service/about-update/currentCity/update/";
//----------------------------------------------------------------------------------------------------------------
//UPDATE HOME TOWN BY URL
private static final String UPDATE_SINGLE_HOMETOWN_URL="http://about-service/about-update/homeTown/update/";
//----------------------------------------------------------------------------------------------------------------
//OTHERPLACES LIVED BY URL
private static final String UPDATE_SINGLE_OTHERPLACESLIVED_URL="http://about-service/about-update/otherPlacesLived/update/";
//----------------------------------------------------------------------------------------------------------------
//CONTACT INFORMATION BY URL
private static final String UPDATE_SINGLE_CONTACT_INFORMATION_URL="http://about-service/about-update/contactInformation/update/";
//----------------------------------------------------------------------------------------------------------------
//WEBSITE AND SOCIAL LINK BY URL
private static final String UPDATE_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL="http://about-service/about-update/webSiteAndSocialLink/update/";
//----------------------------------------------------------------------------------------------------------------
//BASIC INFORMATION BY URL
private static final String UPDATE_SINGLE_BASIC_INFORMATION_URL="http://about-service/about-update/basicInformation/update/";
//----------------------------------------------------------------------------------------------------------------
//RELATION SHIP BY URL
private static final String UPDATE_SINGLE_RELATIONSHIP_URL="http://about-service/about-update/relationShip/update/";
//----------------------------------------------------------------------------------------------------------------
//FAMILY MEMBERS BY URL
private static final String UPDATE_SINGLE_FAMILY_MEMBERS_URL="http://about-service/about-update/familyMembers/update/";
//----------------------------------------------------------------------------------------------------------------
//FAVORITE QUOTES BY URL
private static final String UPDATE_SINGLE_FAVORITE_QUOTES_URL="http://about-service/about-update/favoriteQuotes/update/";

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


//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackHighSchoolUPDATEByID")
//UPDATE HIGH SCHOOL BY ID
@PutMapping(value="/highSchool/update/{id}")
public ResponseEntity<String> updateSingleHighSchoolByID(@PathVariable("id") Long id,@RequestBody HighSchool highSchool) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSingleHighSchoolByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_HIGHSCHOOL_URL+id, highSchool);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackHighSchoolUPDATEByID
public ResponseEntity<String>fallbackHighSchoolUPDATEByID(@PathVariable("id") Long id,@RequestBody HighSchool highSchool) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackHighSchoolUPDATEByID()---ID : "+id);
	HighSchool highSchool2=highSchoolRepository.getById(id);
	highSchool2.setHighSchool(highSchool.getHighSchool());
highSchoolRepository.save(highSchool2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackHighSchoolUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}


//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCurrentCityUPDATEByID")
//UPDATE CURRENT CITY BY ID
@PutMapping(value="/currentCity/update/{id}")
public ResponseEntity<String> updateSingleCurrentCityByID(@PathVariable("id") Long id,@RequestBody CurrentCity currentCity) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSingleCurrentCityByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_CURRENT_CITY_URL+id, currentCity);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackCurrentCityUPDATEByID
public ResponseEntity<String>fallbackCurrentCityUPDATEByID(@PathVariable("id") Long id,@RequestBody CurrentCity currentCity) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackCurrentCityUPDATEByID()---ID : "+id);
	CurrentCity currentCity2=currentCityRepository.getById(id);
	currentCity2.setCurrentCity(currentCity.getCurrentCity());
currentCityRepository.save(currentCity2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackCurrentCityUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}

//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackHomeTownUPDATEByID")
//UPDATE HOME TOWN BY ID
@PutMapping(value="/homeTown/update/{id}")
public ResponseEntity<String> updateSingleHomeTownByID(@PathVariable("id") Long id,@RequestBody HomeTown homeTown) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSingleHomeTownByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_HOMETOWN_URL+id, homeTown);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackHomeTownUPDATEByID
public ResponseEntity<String>fallbackHomeTownUPDATEByID(@PathVariable("id") Long id,@RequestBody HomeTown homeTown) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackHomeTownUPDATEByID()---ID : "+id);
	HomeTown homeTown2=homeTownRepository.getById(id);
	homeTown2.setHomeTown(homeTown.getHomeTown());
homeTownRepository.save(homeTown2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackHomeTownUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}

//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackOtherplacesLivedUPDATEByID")
//UPDATE OTHER PLACES LIVED BY ID
@PutMapping(value="/otherPlacesLived/update/{id}")
public ResponseEntity<String> updateSingleotherPlacesLivedByID(@PathVariable("id") Long id,@RequestBody OtherPlacesLived otherPlacesLived) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSingleotherPlacesLivedByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_OTHERPLACESLIVED_URL+id, otherPlacesLived);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackOtherplacesLivedUPDATEByID
public ResponseEntity<String>fallbackOtherplacesLivedUPDATEByID(@PathVariable("id") Long id,@RequestBody OtherPlacesLived otherPlacesLived) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackOtherplacesLivedUPDATEByID()---ID : "+id);
	OtherPlacesLived otherPlacesLived2=otherPlacesLivedRepository.getById(id);
	otherPlacesLived2.setOtherPlacesLived(otherPlacesLived.getOtherPlacesLived());
otherPlacesLivedRepository.save(otherPlacesLived2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackOtherplacesLivedUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}
//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackContactInformationUPDATEByID")
//UPDATE CONTACT INFORMATION BY ID
@PutMapping(value="/contactInformation/update/{id}")
public ResponseEntity<String> updateSinglecontactInformationByID(@PathVariable("id") Long id,@RequestBody ContactInformation contactInformation) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSinglecontactInformationByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_CONTACT_INFORMATION_URL+id, contactInformation);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackContactInformationUPDATEByID
public ResponseEntity<String>fallbackContactInformationUPDATEByID(@PathVariable("id") Long id,@RequestBody ContactInformation contactInformation) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackContactInformationUPDATEByID()---ID : "+id);
	ContactInformation contactInformation2=contactInformationRepository.getById(id);
	contactInformation2.setContactInformation(contactInformation.getContactInformation());
contactInformationRepository.save(contactInformation2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackContactInformationUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}
//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackwebSiteAndSocialLinkUPDATEByID")
//UPDATE webSiteAndSocialLink BY ID
@PutMapping(value="/webSiteAndSocialLink/update/{id}")
public ResponseEntity<String> updateSinglewebSiteAndSocialLinkByID(@PathVariable("id") Long id,@RequestBody WebSiteAndSocialLink webSiteAndSocialLink) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSinglewebSiteAndSocialLinkByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL+id, webSiteAndSocialLink);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackwebSiteAndSocialLinkUPDATEByID
public ResponseEntity<String>fallbackwebSiteAndSocialLinkUPDATEByID(@PathVariable("id") Long id,@RequestBody WebSiteAndSocialLink webSiteAndSocialLink) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackwebSiteAndSocialLinkUPDATEByID()---ID : "+id);
	WebSiteAndSocialLink webSiteAndSocialLink2=webSiteAndSocialLinkRepository.getById(id);
	webSiteAndSocialLink2.setWebSiteAndSocialLink(webSiteAndSocialLink.getWebSiteAndSocialLink());
webSiteAndSocialLinkRepository.save(webSiteAndSocialLink2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackwebSiteAndSocialLinkUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}
//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackbasicInformationUPDATEByID")
//UPDATE basicInformation BY ID
@PutMapping(value="/basicInformation/update/{id}")
public ResponseEntity<String> updateSinglebasicInformationByID(@PathVariable("id") Long id,@RequestBody BasicInformation basicInformation) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSinglebasicInformationByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_BASIC_INFORMATION_URL+id, basicInformation);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackbasicInformationUPDATEByID
public ResponseEntity<String>fallbackbasicInformationUPDATEByID(@PathVariable("id") Long id,@RequestBody BasicInformation basicInformation) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackbasicInformationUPDATEByID()---ID : "+id);
	BasicInformation basicInformation2=basicInformationRepository.getById(id);
	basicInformation2.setBasicInformation(basicInformation.getBasicInformation());
basicInformationRepository.save(basicInformation2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackBasicInformationUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}
//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackrelationShipUPDATEByID")
//UPDATE relationShip BY ID
@PutMapping(value="/relationShip/update/{id}")
public ResponseEntity<String> updateSinglerelationShipByID(@PathVariable("id") Long id,@RequestBody RelationShip relationShip) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSinglerelationShipByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_RELATIONSHIP_URL+id, relationShip);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackrelationShipUPDATEByID
public ResponseEntity<String>fallbackrelationShipUPDATEByID(@PathVariable("id") Long id,@RequestBody RelationShip relationShip) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackrelationShipUPDATEByID()---ID : "+id);
	RelationShip relationShip2=relationShipRepository.getById(id);
	relationShip2.setRelationShip(relationShip.getRelationShip());
relationShipRepository.save(relationShip2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackrelationShipUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}
//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfamilyMembersUPDATEByID")
//UPDATE familyMembers BY ID
@PutMapping(value="/familyMembers/update/{id}")
public ResponseEntity<String> updateSinglefamilyMembersByID(@PathVariable("id") Long id,@RequestBody FamilyMembers familyMembers) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSinglefamilyMembersByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_FAMILY_MEMBERS_URL+id, familyMembers);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackfamilyMembersUPDATEByID
public ResponseEntity<String>fallbackfamilyMembersUPDATEByID(@PathVariable("id") Long id,@RequestBody FamilyMembers familyMembers) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackfamilyMembersUPDATEByID()---ID : "+id);
	FamilyMembers familyMembers2=familyMembersRepository.getById(id);
	familyMembers2.setFamilyMembers(familyMembers.getFamilyMembers());
familyMembersRepository.save(familyMembers2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackfamilyMembersUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}
//----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfavoriteQuotesUPDATEByID")
//UPDATE favoriteQuotes BY ID
@PutMapping(value="/favoriteQuotes/update/{id}")
public ResponseEntity<String> updateSinglefavoriteQuotesByID(@PathVariable("id") Long id,@RequestBody FavoriteQoutes favoriteQoutes) {
	LOGGER.info("FROM class AboutUPDATEController,method :  updateSinglefavoriteQuotesByID()---ID : "+id);
	restTemplate.put(UPDATE_SINGLE_FAVORITE_QUOTES_URL+id, favoriteQoutes);
	
	
	return ResponseEntity.ok().body("success update");


}
//HYSTRIX fallbackfavoriteQuotesUPDATEByID
public ResponseEntity<String>fallbackfavoriteQuotesUPDATEByID(@PathVariable("id") Long id,@RequestBody FavoriteQoutes favoriteQoutes) {
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackfavoriteQuotesUPDATEByID()---ID : "+id);
	FavoriteQoutes favoriteQoutes2=favoriteQuotesRepository.getById(id);
	favoriteQoutes2.setFavoriteQuote(favoriteQoutes.getFavoriteQuote());
favoriteQuotesRepository.save(favoriteQoutes2);
	LOGGER.info("FROM class AboutUPDATEController,method : fallbackfavoriteQuotesUPDATEByID()--UPDATED--ID : "+id);
	return ResponseEntity.ok().body("success update");
}

}
