package com.renu.about.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value="/about-get")
public class AboutGETController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutGETController.class);
//---------------------------------------------------------------------------------------------------------------
@Autowired
WorkPlaceRepository workPlaceRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
ProfessionalSkillRepository professionalSkillRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
CollegeRepository collegeRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
HighSchoolRepository highSchoolRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
CurrentCityRepository currentCityRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
HomeTownRepository homeTownRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
OtherPlacesLivedRepository otherPlacesLivedRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
ContactInformationRepository contactInformationRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
WebSiteAndSocialLinkRepository webSiteAndSocialLinkRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
BasicInformationRepository basicInformationRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
RelationShipRepository relationShipRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
FamilyMembersRepository familyMembersRepository;
//---------------------------------------------------------------------------------------------------------------
@Autowired
FavoriteQuotesRepository favoriteQuotesRepository;
//---------------------------------------------------------------------------------------------------------------
// GET WORKPLACES ALL
@GetMapping(value="/workplace/getAll/{uid}")
public ResponseEntity<List<Workplace>>getAllWorkplacesByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllWorkplacesByUID()--ENTER--UID : "+uid);
	List<Workplace>workplaces=workPlaceRepository.getAllWorkplacesByUID(uid);
 return	ResponseEntity.ok().body(workplaces);
}
//-----------------

//GET WORKPLACE BY ID
@GetMapping(value="/workplace/single/{id}")
public ResponseEntity<Workplace>getSingleWorkplaceByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleWorkplaceByID()--ENTER--ID : "+id);
	Workplace workplace=workPlaceRepository.getById(id);
return	ResponseEntity.ok().body(workplace);
}

//-----------------------------------------------------------------------------------------------------------
//GET PROFESSIONAL SKILLS ALL
@GetMapping(value="/professionalSkills/getAll/{uid}")
public ResponseEntity<List<ProfessionalSkill>>getAllProfessionalSkillsByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllProfessionalSkillsByUID()--ENTER--UID : "+uid);
	List<ProfessionalSkill>professionalSkills=professionalSkillRepository.getAllProfessionalSkillsByUID(uid);
return	ResponseEntity.ok().body(professionalSkills);
}
//-----------------

//GET PROFESSIONAL SKILLS BY ID
@GetMapping(value="/professionalSkills/single/{id}")
public ResponseEntity<ProfessionalSkill>getSingleProfessionalSkillsByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleProfessionalSkillsByID()--ENTER--ID : "+id);
	ProfessionalSkill professionalSkill=professionalSkillRepository.getById(id);
return	ResponseEntity.ok().body(professionalSkill);
}

//-----------------------------------------------------------------------------------------------------------
//GET COLLEGE ALL
@GetMapping(value="/college/getAll/{uid}")
public ResponseEntity<List<College>>getAllCollegesByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllCollegesByUID()--ENTER--UID : "+uid);
	List<College>colleges=collegeRepository.getAllCollegesByUID(uid);
return	ResponseEntity.ok().body(colleges);
}
//-----------------

//GET COLLEGE BY ID
@GetMapping(value="/college/single/{id}")
public ResponseEntity<College>getSingleCollegeByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleCollegeByID()--ENTER--ID : "+id);
	College college=collegeRepository.getById(id);
return	ResponseEntity.ok().body(college);
}
//-----------------------------------------------------------------------------------------------------------
//GET HIGH SCHOOL ALL
@GetMapping(value="/highSchool/getAll/{uid}")
public ResponseEntity<List<HighSchool>>getAllHighSchoolByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllHighSchoolByUID()--ENTER--UID : "+uid);
	List<HighSchool>highSchools=highSchoolRepository.getAllHighSchoolByUID(uid);
return	ResponseEntity.ok().body(highSchools);
}
//-----------------

//GET HIGH SCHOOL BY ID
@GetMapping(value="/highSchool/single/{id}")
public ResponseEntity<HighSchool>getSingleHighSchoolByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleHighSchoolByID()--ENTER--ID : "+id);
	HighSchool highSchool=highSchoolRepository.getById(id);
return	ResponseEntity.ok().body(highSchool);
}
//-----------------------------------------------------------------------------------------------------------
//GET CURRENT CITY ALL
@GetMapping(value="/currentCity/getAll/{uid}")
public ResponseEntity<List<CurrentCity>>getAllCurrentCityByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllCurrentCityByUID()--ENTER--UID : "+uid);
	List<CurrentCity>currentCities=currentCityRepository.getAllCurrentCityByUID(uid);
return	ResponseEntity.ok().body(currentCities);
}
//-----------------

//GET CURRENT CITY BY ID
@GetMapping(value="/currentCity/single/{id}")
public ResponseEntity<CurrentCity>getSingleCurrentCityByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleCurrentCityByID()--ENTER--ID : "+id);
	CurrentCity currentCity=currentCityRepository.getById(id);
return	ResponseEntity.ok().body(currentCity);
}
//-----------------------------------------------------------------------------------------------------------
//GET HOME TOWN ALL
@GetMapping(value="/homeTown/getAll/{uid}")
public ResponseEntity<List<HomeTown>>getAllHomeTownByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllHomeTownByUID()--ENTER--UID : "+uid);
	List<HomeTown>homeTowns=homeTownRepository.getAllHomeTownByUID(uid);
return	ResponseEntity.ok().body(homeTowns);
}
//-----------------

//GET HOME TOWN BY ID
@GetMapping(value="/homeTown/single/{id}")
public ResponseEntity<HomeTown>getSingleHomeTownByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleHomeTownByID()--ENTER--ID : "+id);
	HomeTown homeTown=homeTownRepository.getById(id);
return	ResponseEntity.ok().body(homeTown);
}
//-----------------------------------------------------------------------------------------------------------
@GetMapping(value="/otherPlacesLived/getAll/{uid}")
public ResponseEntity<List<OtherPlacesLived>>getAllotherPlacesLivedByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllotherPlacesLivedByUID()--ENTER--UID : "+uid);
	List<OtherPlacesLived>otherPlacesLiveds=otherPlacesLivedRepository.getAllOtherPlacesLivedByUID(uid);
return	ResponseEntity.ok().body(otherPlacesLiveds);
}
//-----------------

@GetMapping(value="/otherPlacesLived/single/{id}")
public ResponseEntity<OtherPlacesLived>getSingleotherPlacesLivedByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSingleotherPlacesLivedByID()--ENTER--ID : "+id);
	OtherPlacesLived otherPlacesLived=otherPlacesLivedRepository.getById(id);
return	ResponseEntity.ok().body(otherPlacesLived);
}
//-----------------------------------------------------------------------------------------------------------
@GetMapping(value="/contactInformation/getAll/{uid}")
public ResponseEntity<List<ContactInformation>>getAllcontactInformationByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllcontactInformationByUID()--ENTER--UID : "+uid);
	List<ContactInformation>contactInformations=contactInformationRepository.getAllContactInformationByUID(uid);
return	ResponseEntity.ok().body(contactInformations);
}
//-----------------

@GetMapping(value="/contactInformation/single/{id}")
public ResponseEntity<ContactInformation>getSinglecontactInformationByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSinglecontactInformationByID()--ENTER--ID : "+id);
	ContactInformation contactInformation=contactInformationRepository.getById(id);
return	ResponseEntity.ok().body(contactInformation);
}
//-----------------------------------------------------------------------------------------------------------
@GetMapping(value="/webSiteAndSocialLink/getAll/{uid}")
public ResponseEntity<List<WebSiteAndSocialLink>>getAllwebSiteAndSocialLinkByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllwebSiteAndSocialLinkByUID()--ENTER--UID : "+uid);
	List<WebSiteAndSocialLink>webSiteAndSocialLinks=webSiteAndSocialLinkRepository.getAllWorkplacesByUID(uid);
return	ResponseEntity.ok().body(webSiteAndSocialLinks);
}
//-----------------

@GetMapping(value="/webSiteAndSocialLink/single/{id}")
public ResponseEntity<WebSiteAndSocialLink>getSinglewebSiteAndSocialLinkByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSinglewebSiteAndSocialLinkByID()--ENTER--ID : "+id);
	WebSiteAndSocialLink webSiteAndSocialLink=webSiteAndSocialLinkRepository.getById(id);
return	ResponseEntity.ok().body(webSiteAndSocialLink);
}
//-----------------------------------------------------------------------------------------------------------
@GetMapping(value="/basicInformation/getAll/{uid}")
public ResponseEntity<List<BasicInformation>>getAllbasicInformationByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllbasicInformationByUID()--ENTER--UID : "+uid);
	List<BasicInformation>basicInformations=basicInformationRepository.getAllBasicInformationByUID(uid);
return	ResponseEntity.ok().body(basicInformations);
}
//-----------------

@GetMapping(value="/basicInformation/single/{id}")
public ResponseEntity<BasicInformation>getSinglebasicInformationByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSinglebasicInformationByID()--ENTER--ID : "+id);
	BasicInformation basicInformation=basicInformationRepository.getById(id);
return	ResponseEntity.ok().body(basicInformation);
}
//-----------------------------------------------------------------------------------------------------------
@GetMapping(value="/relationShip/getAll/{uid}")
public ResponseEntity<List<RelationShip>>getAllrelationShipByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllrelationShipByUID()--ENTER--UID : "+uid);
	List<RelationShip>relationShips=relationShipRepository.getAllRelationShipByUID(uid);
return	ResponseEntity.ok().body(relationShips);
}
//-----------------

@GetMapping(value="/relationShip/single/{id}")
public ResponseEntity<RelationShip>getSinglerelationShipByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSinglerelationShipByID()--ENTER--ID : "+id);
	RelationShip relationShip=relationShipRepository.getById(id);
return	ResponseEntity.ok().body(relationShip);
}
//-----------------------------------------------------------------------------------------------------------
@GetMapping(value="/familyMembers/getAll/{uid}")
public ResponseEntity<List<FamilyMembers>>getAllfamilyMembersByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllfamilyMembersByUID()--ENTER--UID : "+uid);
	List<FamilyMembers>familyMembers=familyMembersRepository.getAllFamilyMembersByUID(uid);
return	ResponseEntity.ok().body(familyMembers);
}
//-----------------

@GetMapping(value="/familyMembers/single/{id}")
public ResponseEntity<FamilyMembers>getSinglefamilyMembersByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSinglefamilyMembersByID()--ENTER--ID : "+id);
	FamilyMembers familyMembers=familyMembersRepository.getById(id);
return	ResponseEntity.ok().body(familyMembers);
}
//-----------------------------------------------------------------------------------------------------------
@GetMapping(value="/favoriteQuotes/getAll/{uid}")
public ResponseEntity<List<FavoriteQoutes>>getAllfavoriteQuotesByUID(@PathVariable String uid){
	LOGGER.info("From class AboutGETController,method : getAllfavoriteQuotesByUID()--ENTER--UID : "+uid);
	List<FavoriteQoutes>favoriteQoutes=favoriteQuotesRepository.getAllWorkplacesByUID(uid);
return	ResponseEntity.ok().body(favoriteQoutes);
}
//-----------------

@GetMapping(value="/favoriteQuotes/single/{id}")
public ResponseEntity<FavoriteQoutes>getSinglefavoriteQuotesByID(@PathVariable("id") Long id){
	LOGGER.info("From class AboutGETController,method : getSinglefavoriteQuotesByID()--ENTER--ID : "+id);
	FavoriteQoutes favoriteQoutes=favoriteQuotesRepository.getById(id);
return	ResponseEntity.ok().body(favoriteQoutes);
}

}
