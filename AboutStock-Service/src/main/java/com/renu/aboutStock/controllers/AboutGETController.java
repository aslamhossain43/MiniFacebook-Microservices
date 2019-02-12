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
//------------------------------------------------------------------------------------------------
//HIGH SCHOOL REPOSITORY
@Autowired
HighSchoolRepository highSchoolRepository;
//------------------------------------------------------------------------------------------------
//CURRENT CITY REPOSITORY
@Autowired
CurrentCityRepository currentCityRepository;
//------------------------------------------------------------------------------------------------
//HOME TOWN REPOSITORY
@Autowired
HomeTownRepository homeTownRepository;
//------------------------------------------------------------------------------------------------
//OTHER PLACES REPOSITORY
@Autowired
OtherPlacesLivedRepository otherPlacesLivedRepository;
//------------------------------------------------------------------------------------------------
//CONTACT INFORMATION REPOSITORY
@Autowired
ContactInformationRepository contactInformationRepository;
//------------------------------------------------------------------------------------------------
//WEBSITE AND SOCIAL LINK REPOSITORY
@Autowired
WebSiteAndSocialLinkRepository webSiteAndSocialLinkRepository;
//------------------------------------------------------------------------------------------------
//BASIC INFORMATION  REPOSITORY
@Autowired
BasicInformationRepository basicInformationRepository;
//------------------------------------------------------------------------------------------------
//RELATION SHIP  REPOSITORY
@Autowired
RelationShipRepository relationShipRepository;
//------------------------------------------------------------------------------------------------
//FAMILY MEMBERS REPOSITORY
@Autowired
FamilyMembersRepository familyMembersRepository;
//------------------------------------------------------------------------------------------------
//FAVORITE QUOTES REPOSITORY
@Autowired
FavoriteQuotesRepository favoriteQuotesRepository;
//-------------------------------------------------------------------------------------------------
//GET ALL WORKPLACES URL
private static final String GET_ALL_WORKPLACES_URL="http://about-service/about-get/workplace/getAll/";
//GET WORKPLACE BY URL
private static final String GET_SINGLE_WORKPLACE_URL="http://about-service/about-get/workplace/single/";

//-------------------------------------------------------------------------------------------------
//GET ALL PROFESSIONAL SKILLS URL
private static final String GET_ALL_PROFESSIONAL_SKILLS_URL="http://about-service/about-get/professionalSkills/getAll/";
//GET PROFESSIONAL SKILLS BY URL
private static final String GET_SINGLE_PROFESSIONAL_SKILLS_URL="http://about-service/about-get/professionalSkills/single/";
//-------------------------------------------------------------------------------------------------
//GET ALL COLLEGES URL
private static final String GET_ALL_COLLEGES_URL="http://about-service/about-get/college/getAll/";
//GET COLLEGE URL
private static final String GET_SINGLE_COLLEGES_URL="http://about-service/about-get/college/single/";

//-------------------------------------------------------------------------------------------------
//GET ALL HIGH SCHOOL URL
private static final String GET_ALL_HIGHSCHOOL_URL="http://about-service/about-get/highSchool/getAll/";
//GET HIGHSCHOOL URL
private static final String GET_SINGLE_HIGHSCHOOL_URL="http://about-service/about-get/highSchool/single/";

//-------------------------------------------------------------------------------------------------
//GET ALL CURRENT CITY URL
private static final String GET_ALL_CURRENT_CITY_URL="http://about-service/about-get/currentCity/getAll/";
//GET CURRENT CITY URL
private static final String GET_SINGLE_CURRENT_CITY_URL="http://about-service/about-get/currentCity/single/";

//-------------------------------------------------------------------------------------------------
//GET ALL HOME TOWN URL
private static final String GET_ALL_HOMETOWN_URL="http://about-service/about-get/homeTown/getAll/";
//GET HOME TOWN URL
private static final String GET_SINGLE_HOMETOWN_URL="http://about-service/about-get/homeTown/single/";

//-------------------------------------------------------------------------------------------------
//GET ALL OTHERPLACES LIVED URL
private static final String GET_ALL_OTHERPLACES_LIVED_URL="http://about-service/about-get/otherPlacesLived/getAll/";
//GET HOME TOWN URL
private static final String GET_SINGLE_OTHERPLACES_LIVED_URL="http://about-service/about-get/otherPlacesLived/single/";
//-------------------------------------------------------------------------------------------------
//GET ALL CONTACT INFORMATION URL
private static final String GET_ALL_CONTACT_INFORMATION_URL="http://about-service/about-get/contactInformation/getAll/";
//GET HOME TOWN URL
private static final String GET_SINGLE_CONTACT_INFORMATION_URL="http://about-service/about-get/contactInformation/single/";
//-------------------------------------------------------------------------------------------------
//GET ALL WEBSITE AND SOCIAL LINK URL
private static final String GET_ALL_WEBSITE_AND_SOCIAL_LINK_URL="http://about-service/about-get/webSiteAndSocialLink/getAll/";
//GET HOME TOWN URL
private static final String GET_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL="http://about-service/about-get/webSiteAndSocialLink/single/";
//-------------------------------------------------------------------------------------------------
//GET ALL BASIC INFORMATION URL
private static final String GET_ALL_BASIC_INFORMATION_URL="http://about-service/about-get/basicInformation/getAll/";
//GET HOME TOWN URL
private static final String GET_SINGLE_BASIC_INFORMATION_URL="http://about-service/about-get/basicInformation/single/";
//-------------------------------------------------------------------------------------------------
//GET ALL RELATION SHIP URL
private static final String GET_ALL_RELATIONSHIP_URL="http://about-service/about-get/relationShip/getAll/";
//GET HOME TOWN URL
private static final String GET_SINGLE_RELATIONSHIP_URL="http://about-service/about-get/relationShip/single/";
//-------------------------------------------------------------------------------------------------
//GET ALL FAMILY MEMBERS URL
private static final String GET_ALL_FAMILYMEMBERS_URL="http://about-service/about-get/familyMembers/getAll/";
//GET HOME TOWN URL
private static final String GET_SINGLE_FAMILYMEMBERS_URL="http://about-service/about-get/familyMembers/single/";
//-------------------------------------------------------------------------------------------------
//GET ALL FAVORITE QUOTES URL
private static final String GET_ALL_FAVORITE_QUOTES_URL="http://about-service/about-get/favoriteQuotes/getAll/";
//GET HOME TOWN URL
private static final String GET_SINGLE_FAVORITE_QUOTES_URL="http://about-service/about-get/favoriteQuotes/single/";

//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/getAll/{uid}")
public ResponseEntity<List<Workplace>> getAllWorkplaceByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : getAllWorkplaceByUID()---UID : "+uid);
	
	
	ResponseEntity<List<Workplace>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_WORKPLACES_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<Workplace>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackForStorUID
public ResponseEntity<List<Workplace>> fallbackWorkplaceGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackWorkplaceGETAll()---UID : "+uid);
	List<Workplace> profilePhotosEntity=workPlaceRepository.getAllWorkplacesByUID(uid);
	return ResponseEntity.ok().body(profilePhotosEntity);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/single/{id}")
public ResponseEntity<Workplace> getSingleWorkplaceByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSingleWorkplaceByID()---ID : "+id);
	
	
	ResponseEntity<Workplace> profilePhotosEntity =
	        restTemplate.exchange(GET_SINGLE_WORKPLACE_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<Workplace>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceGETByID
public ResponseEntity<Workplace> fallbackWorkplaceGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackWorkplaceGETByID()---ID : "+id);
	Workplace profilePhotosEntity=workPlaceRepository.getById(id);
	return ResponseEntity.ok().body(profilePhotosEntity);
}




//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackProfessionalSkillsGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/professionalSkills/getAll/{uid}")
public ResponseEntity<List<ProfessionalSkill>> getAllProfessionalSkillsByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllProfessionalSkillsByUID()---UID : "+uid);
	
	
	ResponseEntity<List<ProfessionalSkill>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_PROFESSIONAL_SKILLS_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<ProfessionalSkill>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackForStorUID
public ResponseEntity<List<ProfessionalSkill>>fallbackProfessionalSkillsGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackProfessionalSkillsGETAll()---UID : "+uid);
	List<ProfessionalSkill> profilePhotosEntity=professionalSkillRepository.getAllProfessionalSkillsByUID(uid);
	return ResponseEntity.ok().body(profilePhotosEntity);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackProfessionalSkillsGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/professionalSkills/single/{id}")
public ResponseEntity<ProfessionalSkill> getSingleProfessionalSkillsByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSingleProfessionalSkillsByID()---ID : "+id);
	
	
	ResponseEntity<ProfessionalSkill> profilePhotosEntity =
	        restTemplate.exchange(GET_SINGLE_PROFESSIONAL_SKILLS_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<ProfessionalSkill>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceGETByID
public ResponseEntity<ProfessionalSkill> fallbackProfessionalSkillsGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackProfessionalSkillsGETByID()---ID : "+id);
	ProfessionalSkill professionalSkill=professionalSkillRepository.getById(id);
	return ResponseEntity.ok().body(professionalSkill);
}



//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCollegeGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/college/getAll/{uid}")
public ResponseEntity<List<College>> getAllCollegesByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllCollegesByUID()---UID : "+uid);
	
	
	ResponseEntity<List<College>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_COLLEGES_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<College>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackForStorUID
public ResponseEntity<List<College>>fallbackCollegeGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackCollegeGETAll()---UID : "+uid);
	List<College> colleges=collegeRepository.getAllCollegesByUID(uid);
	return ResponseEntity.ok().body(colleges);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCollegeGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/college/single/{id}")
public ResponseEntity<College> getSingleCollegeByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSingleCollegeByID()---ID : "+id);
	
	
	ResponseEntity<College> college =
	        restTemplate.exchange(GET_SINGLE_COLLEGES_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<College>() {
	            });
	
	
	
	return college;


}
//HYSTRIX fallbackCollegeGETByID
public ResponseEntity<College>fallbackCollegeGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackCollegeGETByID()---ID : "+id);
	College college=collegeRepository.getById(id);
	return ResponseEntity.ok().body(college);
}



//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackHighSchoolGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/highSchool/getAll/{uid}")
public ResponseEntity<List<HighSchool>> getAllHighSchoolByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllHighSchoolByUID()---UID : "+uid);
	
	
	ResponseEntity<List<HighSchool>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_HIGHSCHOOL_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<HighSchool>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackHighSchoolGETAll
public ResponseEntity<List<HighSchool>>fallbackHighSchoolGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackHighSchoolGETAll()---UID : "+uid);
	List<HighSchool> highSchools=highSchoolRepository.getAllHighSchoolByUID(uid);
	return ResponseEntity.ok().body(highSchools);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackHighSchoolGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/highSchool/single/{id}")
public ResponseEntity<HighSchool> getSingleHighSchoolByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSingleHighSchoolByID()---ID : "+id);
	
	
	ResponseEntity<HighSchool> responseEntity =
	        restTemplate.exchange(GET_SINGLE_HIGHSCHOOL_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<HighSchool>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackHighSchoolGETByID
public ResponseEntity<HighSchool>fallbackHighSchoolGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackHighSchoolGETByID()---ID : "+id);
	HighSchool highSchool=highSchoolRepository.getById(id);
	return ResponseEntity.ok().body(highSchool);
}



//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCurrentCityGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/currentCity/getAll/{uid}")
public ResponseEntity<List<CurrentCity>> getAllCurrentCityByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllCurrentCityByUID()---UID : "+uid);
	
	
	ResponseEntity<List<CurrentCity>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_CURRENT_CITY_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<CurrentCity>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackCurrentCityGETAll
public ResponseEntity<List<CurrentCity>>fallbackCurrentCityGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackCurrentCityGETAll()---UID : "+uid);
	List<CurrentCity> currentCities=currentCityRepository.getAllCurrentCityByUID(uid);
	return ResponseEntity.ok().body(currentCities);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackCurrentCityGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/currentCity/single/{id}")
public ResponseEntity<CurrentCity> getSingleCurrentCityByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSingleCurrentCityByID()---ID : "+id);
	
	
	ResponseEntity<CurrentCity> responseEntity =
	        restTemplate.exchange(GET_SINGLE_CURRENT_CITY_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<CurrentCity>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackCurrentCityGETByID
public ResponseEntity<CurrentCity>fallbackCurrentCityGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackCurrentCityGETByID()---ID : "+id);
	CurrentCity currentCity=currentCityRepository.getById(id);
	return ResponseEntity.ok().body(currentCity);
}


//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackHomeTownGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/homeTown/getAll/{uid}")
public ResponseEntity<List<HomeTown>> getAllHomeTownByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllHomeTownByUID()---UID : "+uid);
	
	
	ResponseEntity<List<HomeTown>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_HOMETOWN_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<HomeTown>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackHomeTownGETAll
public ResponseEntity<List<HomeTown>>fallbackHomeTownGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackHomeTownGETAll()---UID : "+uid);
	List<HomeTown> homeTowns=homeTownRepository.getAllHomeTownByUID(uid);
	return ResponseEntity.ok().body(homeTowns);
}

//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackHomeTownGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/homeTown/single/{id}")
public ResponseEntity<HomeTown> getSingleHomeTownByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSingleHomeTownByID()---ID : "+id);
	
	
	ResponseEntity<HomeTown> responseEntity =
	        restTemplate.exchange(GET_SINGLE_HOMETOWN_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<HomeTown>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackHomeTownGETByID
public ResponseEntity<HomeTown>fallbackHomeTownGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackHomeTownGETByID()---ID : "+id);
	HomeTown homeTown=homeTownRepository.getById(id);
	return ResponseEntity.ok().body(homeTown);
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackotherPlacesLivedGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/otherPlacesLived/getAll/{uid}")
public ResponseEntity<List<OtherPlacesLived>> getAllotherPlacesLivedByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllotherPlacesLivedByUID()---UID : "+uid);
	
	
	ResponseEntity<List<OtherPlacesLived>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_OTHERPLACES_LIVED_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<OtherPlacesLived>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackotherPlacesLivedGETAll
public ResponseEntity<List<OtherPlacesLived>>fallbackotherPlacesLivedGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackotherPlacesLivedGETAll()---UID : "+uid);
	List<OtherPlacesLived> otherPlacesLiveds=otherPlacesLivedRepository.getAllOtherPlacesLivedByUID(uid);
	return ResponseEntity.ok().body(otherPlacesLiveds);
}

//-------------------------------------------
//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackotherPlacesLivedGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/otherPlacesLived/single/{id}")
public ResponseEntity<OtherPlacesLived> getSingleotherPlacesLivedByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSingleotherPlacesLivedByID()---ID : "+id);
	
	
	ResponseEntity<OtherPlacesLived> responseEntity =
	        restTemplate.exchange(GET_SINGLE_OTHERPLACES_LIVED_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<OtherPlacesLived>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackotherPlacesLivedGETByID
public ResponseEntity<OtherPlacesLived>fallbackotherPlacesLivedGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackotherPlacesLivedGETByID()---ID : "+id);
	OtherPlacesLived otherPlacesLived=otherPlacesLivedRepository.getById(id);
	return ResponseEntity.ok().body(otherPlacesLived);
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackcontactInformationGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/contactInformation/getAll/{uid}")
public ResponseEntity<List<ContactInformation>> getAllcontactInformationByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllcontactInformationByUID()---UID : "+uid);
	
	
	ResponseEntity<List<ContactInformation>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_CONTACT_INFORMATION_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<ContactInformation>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackcontactInformationGETAll
public ResponseEntity<List<ContactInformation>>fallbackcontactInformationGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackcontactInformationGETAll()---UID : "+uid);
	List<ContactInformation> contactInformations=contactInformationRepository.getAllContactInformationByUID(uid);
	return ResponseEntity.ok().body(contactInformations);
}

//-------------------------------------------
//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackcontactInformationGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/contactInformation/single/{id}")
public ResponseEntity<ContactInformation> getSinglecontactInformationByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSinglecontactInformationByID()---ID : "+id);
	
	
	ResponseEntity<ContactInformation> responseEntity =
	        restTemplate.exchange(GET_SINGLE_CONTACT_INFORMATION_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<ContactInformation>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackcontactInformationGETByID
public ResponseEntity<ContactInformation>fallbackcontactInformationGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackcontactInformationGETByID()---ID : "+id);
	ContactInformation contactInformation=contactInformationRepository.getById(id);
	return ResponseEntity.ok().body(contactInformation);
}





//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackwebSiteAndSocialLinkGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/webSiteAndSocialLink/getAll/{uid}")
public ResponseEntity<List<WebSiteAndSocialLink>> getAllwebSiteAndSocialLinkByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllwebSiteAndSocialLinkByUID()---UID : "+uid);
	
	
	ResponseEntity<List<WebSiteAndSocialLink>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_WEBSITE_AND_SOCIAL_LINK_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<WebSiteAndSocialLink>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackwebSiteAndSocialLinkGETAll
public ResponseEntity<List<WebSiteAndSocialLink>>fallbackwebSiteAndSocialLinkGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackwebSiteAndSocialLinkGETAll()---UID : "+uid);
	List<WebSiteAndSocialLink> webSiteAndSocialLinks=webSiteAndSocialLinkRepository.getAllWorkplacesByUID(uid);
	return ResponseEntity.ok().body(webSiteAndSocialLinks);
}

//-------------------------------------------
//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfallbackwebSiteAndSocialLinkGETAllGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/webSiteAndSocialLink/single/{id}")
public ResponseEntity<WebSiteAndSocialLink> getSinglewebSiteAndSocialLinkByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSinglewebSiteAndSocialLinkByID()---ID : "+id);
	
	
	ResponseEntity<WebSiteAndSocialLink> responseEntity =
	        restTemplate.exchange(GET_SINGLE_WEBSITE_AND_SOCIAL_LINK_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<WebSiteAndSocialLink>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackfallbackwebSiteAndSocialLinkGETAllGETByID
public ResponseEntity<WebSiteAndSocialLink>fallbackfallbackwebSiteAndSocialLinkGETAllGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackfallbackwebSiteAndSocialLinkGETAllGETByID()---ID : "+id);
	WebSiteAndSocialLink webSiteAndSocialLink=webSiteAndSocialLinkRepository.getById(id);
	return ResponseEntity.ok().body(webSiteAndSocialLink);
}


//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackbasicInformationGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/basicInformation/getAll/{uid}")
public ResponseEntity<List<BasicInformation>> getAllbasicInformationByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllbasicInformationByUID()---UID : "+uid);
	
	
	ResponseEntity<List<BasicInformation>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_BASIC_INFORMATION_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<BasicInformation>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackbasicInformationGETAll
public ResponseEntity<List<BasicInformation>>fallbackbasicInformationGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackbasicInformationGETAll()---UID : "+uid);
	List<BasicInformation> basicInformations=basicInformationRepository.getAllBasicInformationByUID(uid);
	return ResponseEntity.ok().body(basicInformations);
}

//-------------------------------------------
//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackbasicInformationGETAllGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/basicInformation/single/{id}")
public ResponseEntity<BasicInformation> getSinglebasicInformationByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSinglebasicInformationByID()---ID : "+id);
	
	
	ResponseEntity<BasicInformation> responseEntity =
	        restTemplate.exchange(GET_SINGLE_BASIC_INFORMATION_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<BasicInformation>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackbasicInformationGETAllGETByID
public ResponseEntity<BasicInformation>fallbackbasicInformationGETAllGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackbasicInformationGETAllGETByID()---ID : "+id);
	BasicInformation basicInformation=basicInformationRepository.getById(id);
	return ResponseEntity.ok().body(basicInformation);
}

//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackrelationShipGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/relationShip/getAll/{uid}")
public ResponseEntity<List<RelationShip>> getAllrelationShipByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllrelationShipByUID()---UID : "+uid);
	
	
	ResponseEntity<List<RelationShip>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_RELATIONSHIP_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<RelationShip>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackrelationShipGETAll
public ResponseEntity<List<RelationShip>>fallbackrelationShipGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackrelationShipGETAll()---UID : "+uid);
	List<RelationShip> relationShips=relationShipRepository.getAllRelationShipByUID(uid);
	return ResponseEntity.ok().body(relationShips);
}

//-------------------------------------------
//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackrelationShipGETAllGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/relationShip/single/{id}")
public ResponseEntity<RelationShip> getSinglerelationShipByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSinglerelationShipByID()---ID : "+id);
	
	
	ResponseEntity<RelationShip> responseEntity =
	        restTemplate.exchange(GET_SINGLE_RELATIONSHIP_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<RelationShip>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackrelationShipGETAllGETByID
public ResponseEntity<RelationShip>fallbackrelationShipGETAllGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackrelationShipGETAllGETByID()---ID : "+id);
	RelationShip relationShip=relationShipRepository.getById(id);
	return ResponseEntity.ok().body(relationShip);
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfamilyMembersGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/familyMembers/getAll/{uid}")
public ResponseEntity<List<FamilyMembers>> getAllfamilyMembersByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllfamilyMembersByUID()---UID : "+uid);
	
	
	ResponseEntity<List<FamilyMembers>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_FAMILYMEMBERS_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<FamilyMembers>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackfamilyMembersGETAll
public ResponseEntity<List<FamilyMembers>>fallbackfamilyMembersGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackfamilyMembersGETAll()---UID : "+uid);
	List<FamilyMembers> familyMembers=familyMembersRepository.getAllFamilyMembersByUID(uid);
	return ResponseEntity.ok().body(familyMembers);
}

//-------------------------------------------
//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfamilyMembersGETAllGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/familyMembers/single/{id}")
public ResponseEntity<FamilyMembers> getSinglefamilyMembersByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSinglefamilyMembersByID()---ID : "+id);
	
	
	ResponseEntity<FamilyMembers> responseEntity =
	        restTemplate.exchange(GET_SINGLE_FAMILYMEMBERS_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<FamilyMembers>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackfamilyMembersGETAllGETByID
public ResponseEntity<FamilyMembers>fallbackfamilyMembersGETAllGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackfamilyMembersGETAllGETByID()---ID : "+id);
	FamilyMembers familyMembers =familyMembersRepository.getById(id);
	return ResponseEntity.ok().body(familyMembers);
}
//-----------------------------------------------------------------------------------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfavoriteQuotesGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/favoriteQuotes/getAll/{uid}")
public ResponseEntity<List<FavoriteQoutes>> getAllfavoriteQuotesByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method :  getAllfavoriteQuotesByUID()---UID : "+uid);
	
	
	ResponseEntity<List<FavoriteQoutes>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_FAVORITE_QUOTES_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<FavoriteQoutes>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackfavoriteQuotesGETAll
public ResponseEntity<List<FavoriteQoutes>>fallbackfavoriteQuotesGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class AboutGETController,method : fallbackfavoriteQuotesGETAll()---UID : "+uid);
	List<FavoriteQoutes> favoriteQoutes=favoriteQuotesRepository.getAllWorkplacesByUID(uid);
	return ResponseEntity.ok().body(favoriteQoutes);
}

//-------------------------------------------
//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackfavoriteQuotesGETAllGETByID")
//GET ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/favoriteQuotes/single/{id}")
public ResponseEntity<FavoriteQoutes> getSinglefavoriteQuotesByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : getSinglefavoriteQuotesByID()---ID : "+id);
	
	
	ResponseEntity<FavoriteQoutes> responseEntity =
	        restTemplate.exchange(GET_SINGLE_FAVORITE_QUOTES_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<FavoriteQoutes>() {
	            });
	
	
	
	return responseEntity;


}
//HYSTRIX fallbackfavoriteQuotesGETAllGETByID
public ResponseEntity<FavoriteQoutes>fallbackfavoriteQuotesGETAllGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class AboutGETController,method : fallbackfavoriteQuotesGETAllGETByID()---ID : "+id);
	FavoriteQoutes favoriteQoutes =favoriteQuotesRepository.getById(id);
	return ResponseEntity.ok().body(favoriteQoutes);
}

}
