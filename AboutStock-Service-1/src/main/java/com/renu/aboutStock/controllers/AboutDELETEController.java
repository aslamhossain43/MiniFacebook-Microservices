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
//---------------------------------------------------------------------------------------------------
//CURRENT CITY REPOSITORY
@Autowired
CurrentCityRepository currentCityRepository;
//---------------------------------------------------------------------------------------------------
//HOME TOWN REPOSITORY
@Autowired
HomeTownRepository homeTownRepository;
//---------------------------------------------------------------------------------------------------
//OTHER PLACES REPOSITORY
@Autowired
OtherPlacesLivedRepository otherPlacesLivedRepository;
//---------------------------------------------------------------------------------------------------
//CONTACT INFORMATION REPOSITORY
@Autowired
ContactInformationRepository contactInformationRepository;
//---------------------------------------------------------------------------------------------------
//WEBSITE AND SOCIAL LINK REPOSITORY
@Autowired
WebSiteAndSocialLinkRepository webSiteAndSocialLinkRepository;
//---------------------------------------------------------------------------------------------------
//BASIC INFORMATION REPOSITORY
@Autowired
BasicInformationRepository basicInformationRepository;
//---------------------------------------------------------------------------------------------------
//RELATION SHIP REPOSITORY
@Autowired
RelationShipRepository relationShipRepository;
//---------------------------------------------------------------------------------------------------
//FAMILY MEMBERS REPOSITORY
@Autowired
FamilyMembersRepository familyMembersRepository;
//---------------------------------------------------------------------------------------------------
//FAVORITE QUOTES REPOSITORY
@Autowired
FavoriteQuotesRepository favoriteQuotesRepository;
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
//---------------------------------------------------------------------------------------------------------------
//DELETE CURRENT CITY BY URL
private static final String DELETE_SINGLE_CURRENT_CITY_URL="http://about-service/about-delete/currentCity/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE HOME TOWN BY URL
private static final String DELETE_SINGLE_HOMETOWN_URL="http://about-service/about-delete/homeTown/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE OTHER PLACES LIVED BY URL
private static final String DELETE_SINGLE_OTHERPLACES_LIVED_URL="http://about-service/about-delete/otherPlacesLived/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE CONTACT INFORMATION BY URL
private static final String DELETE_SINGLE_CONTACT_INFORMATION_URL="http://about-service/about-delete/contactInformation/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE WEBSITE AND SOCIAL LINK BY URL
private static final String DELETE_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL="http://about-service/about-delete/webSiteAndSocialLink/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE BASIC INFORMATION BY URL
private static final String DELETE_SINGLE_BASIC_INFORMATION_URL="http://about-service/about-delete/basicInformation/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE RELATION SHIP BY URL
private static final String DELETE_SINGLE_RELATIONSHIP_URL="http://about-service/about-delete/relationShip/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE FAMILY MEMBERS BY URL
private static final String DELETE_SINGLE_FAMILY_MEMBERS_URL="http://about-service/about-delete/familyMembers/single/delete/";
//---------------------------------------------------------------------------------------------------------------
//DELETE FAVORITE QUOTES BY URL
private static final String DELETE_SINGLE_FAVORITE_QUOTES_URL="http://about-service/about-delete/favoriteQuotes/single/delete/";

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


//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCurrentCityDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/currentCity/single/delete/{id}")
public ResponseEntity<String> deleteSingleCurrentCityByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSingleCurrentCityByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_CURRENT_CITY_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackCurrentCityDELETEByID
public ResponseEntity<String>fallbackCurrentCityDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackCurrentCityDELETEByID()---ID : "+id);
    CurrentCity currentCity=currentCityRepository.getById(id);
	currentCityRepository.delete(currentCity);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackCurrentCityDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackHomeTownDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/homeTown/single/delete/{id}")
public ResponseEntity<String> deleteSingleHomeTownByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSingleHomeTownByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_HOMETOWN_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackHomeTownDELETEByID
public ResponseEntity<String>fallbackHomeTownDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackHomeTownDELETEByID()---ID : "+id);
  HomeTown homeTown=homeTownRepository.getById(id);
	homeTownRepository.delete(homeTown);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackHomeTownDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackotherPlacesLivedDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/otherPlacesLived/single/delete/{id}")
public ResponseEntity<String> deleteSingleotherPlacesLivedByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSingleotherPlacesLivedByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_OTHERPLACES_LIVED_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackotherPlacesLivedDELETEByID
public ResponseEntity<String>fallbackotherPlacesLivedDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackotherPlacesLivedDELETEByID()---ID : "+id);
	OtherPlacesLived otherPlacesLived=otherPlacesLivedRepository.getById(id);
LOGGER.info("FROM class AboutDELETEController,method : fallbackotherPlacesLivedDELETEByID()---getting-otherplaces-- : "+otherPlacesLived.getOtherPlacesLived());

	otherPlacesLivedRepository.delete(otherPlacesLived);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackotherPlacesLivedDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackcontactInformationDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/contactInformation/single/delete/{id}")
public ResponseEntity<String> deleteSinglecontactInformationByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSinglecontactInformationByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_CONTACT_INFORMATION_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackcontactInformationDELETEByID
public ResponseEntity<String>fallbackcontactInformationDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackcontactInformationDELETEByID()---ID : "+id);
ContactInformation contactInformation=contactInformationRepository.getById(id);
	contactInformationRepository.delete(contactInformation);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackcontactInformationDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackwebSiteAndSocialLinkDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/webSiteAndSocialLink/single/delete/{id}")
public ResponseEntity<String> deleteSinglewebSiteAndSocialLinkByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSinglewebSiteAndSocialLinkByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackwebSiteAndSocialLinkDELETEByID
public ResponseEntity<String>fallbackwebSiteAndSocialLinkDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackwebSiteAndSocialLinkDELETEByID()---ID : "+id);
WebSiteAndSocialLink webSiteAndSocialLink=webSiteAndSocialLinkRepository.getById(id);
	webSiteAndSocialLinkRepository.delete(webSiteAndSocialLink);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackwebSiteAndSocialLinkDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackbasicInformationDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/basicInformation/single/delete/{id}")
public ResponseEntity<String> deleteSinglebasicInformationByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSinglebasicInformationByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_BASIC_INFORMATION_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackbasicInformationDELETEByID
public ResponseEntity<String>fallbackbasicInformationDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackbasicInformationDELETEByID()---ID : "+id);
BasicInformation basicInformation=basicInformationRepository.getById(id);
	basicInformationRepository.delete(basicInformation);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackbasicInformationDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackrelationShipDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/relationShip/single/delete/{id}")
public ResponseEntity<String> deleteSinglerelationShipByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSinglerelationShipByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_RELATIONSHIP_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackrelationShipDELETEByID
public ResponseEntity<String>fallbackrelationShipDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackrelationShipDELETEByID()---ID : "+id);
RelationShip relationShip=relationShipRepository.getById(id);
	relationShipRepository.delete(relationShip);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackrelationShipDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfamilyMembersDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/familyMembers/single/delete/{id}")
public ResponseEntity<String> deleteSinglefamilyMembersByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSinglefamilyMembersByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_FAMILY_MEMBERS_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackfamilyMembersDELETEByID
public ResponseEntity<String>fallbackfamilyMembersDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackfamilyMembersDELETEByID()---ID : "+id);
FamilyMembers familyMembers=familyMembersRepository.getById(id);
	familyMembersRepository.delete(familyMembers);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackfamilyMembersDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfavoriteQuotesDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/favoriteQuotes/single/delete/{id}")
public ResponseEntity<String> deleteSinglefavoriteQuotesByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : deleteSinglefavoriteQuotesByID()---ID : "+id);
	
	
	ResponseEntity<String> responseEntity =
	        restTemplate.exchange(DELETE_SINGLE_FAVORITE_QUOTES_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackfavoriteQuotesDELETEByID
public ResponseEntity<String>fallbackfavoriteQuotesDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutDELETEController,method : fallbackfavoriteQuotesDELETEByID()---ID : "+id);
FavoriteQoutes favoriteQoutes=favoriteQuotesRepository.getById(id);
	favoriteQuotesRepository.delete(favoriteQoutes);
	LOGGER.info("FROM class AboutDELETEController,method : fallbackfavoriteQuotesDELETEByID()--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}

}
