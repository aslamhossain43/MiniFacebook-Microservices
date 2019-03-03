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
//---------------------------------------------------------------------------------------------------------
@Autowired
CurrentCityRepository currentCityRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
HomeTownRepository homeTownRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
OtherPlacesLivedRepository otherPlacesLivedRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
ContactInformationRepository contactInformationRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
WebSiteAndSocialLinkRepository webSiteAndSocialLinkRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
BasicInformationRepository basicInformationRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
RelationShipRepository relationShipRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
FamilyMembersRepository familyMembersRepository;
//---------------------------------------------------------------------------------------------------------
@Autowired
FavoriteQuotesRepository favoriteQuotesRepository;
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
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/currentCity/update/{id}")
public ResponseEntity<String>updateCurrentCityById(@PathVariable Long id,@RequestBody CurrentCity currentCity){
	LOGGER.info("From class AboutUPDATEController,method : updateCurrentCityById()---ENTER--ID : "+id);
CurrentCity currentCity2=currentCityRepository.getById(id);
currentCity2.setCurrentCity(currentCity.getCurrentCity());
currentCityRepository.save(currentCity2);
LOGGER.info("From class AboutUPDATEController,method : updateCurrentCityById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/homeTown/update/{id}")
public ResponseEntity<String>updateHomeTownById(@PathVariable Long id,@RequestBody HomeTown homeTown){
	LOGGER.info("From class AboutUPDATEController,method : updateHomeTownById()---ENTER--ID : "+id);
HomeTown homeTown2=homeTownRepository.getById(id);
homeTown2.setHomeTown(homeTown.getHomeTown());
homeTownRepository.save(homeTown2);
LOGGER.info("From class AboutUPDATEController,method : updateHomeTownById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/otherPlacesLived/update/{id}")
public ResponseEntity<String>updateotherPlacesLivedById(@PathVariable Long id,@RequestBody OtherPlacesLived otherPlacesLived){
	LOGGER.info("From class AboutUPDATEController,method : updateotherPlacesLived()---ENTER--ID : "+id);
OtherPlacesLived otherPlacesLived2=otherPlacesLivedRepository.getById(id);
otherPlacesLived2.setOtherPlacesLived(otherPlacesLived.getOtherPlacesLived());
otherPlacesLivedRepository.save(otherPlacesLived2);
LOGGER.info("From class AboutUPDATEController,method : updateotherPlacesLivedById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/contactInformation/update/{id}")
public ResponseEntity<String>updatecontactInformationById(@PathVariable Long id,@RequestBody ContactInformation contactInformation){
	LOGGER.info("From class AboutUPDATEController,method : updatecontactInformation()---ENTER--ID : "+id);
ContactInformation contactInformation2=contactInformationRepository.getById(id);
contactInformation2.setContactInformation(contactInformation.getContactInformation());
contactInformationRepository.save(contactInformation2);
LOGGER.info("From class AboutUPDATEController,method : updatecontactInformationById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/webSiteAndSocialLink/update/{id}")
public ResponseEntity<String>updatewebSiteAndSocialLinkById(@PathVariable Long id,@RequestBody WebSiteAndSocialLink webSiteAndSocialLink){
	LOGGER.info("From class AboutUPDATEController,method : updatewebSiteAndSocialLink()---ENTER--ID : "+id);
WebSiteAndSocialLink webSiteAndSocialLink2=webSiteAndSocialLinkRepository.getById(id);
webSiteAndSocialLink2.setWebSiteAndSocialLink(webSiteAndSocialLink.getWebSiteAndSocialLink());
webSiteAndSocialLinkRepository.save(webSiteAndSocialLink2);
LOGGER.info("From class AboutUPDATEController,method : updatewebSiteAndSocialLinkById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/basicInformation/update/{id}")
public ResponseEntity<String>updatebasicInformationById(@PathVariable Long id,@RequestBody BasicInformation basicInformation){
	LOGGER.info("From class AboutUPDATEController,method : updatebasicInformation()---ENTER--ID : "+id);
BasicInformation basicInformation2=basicInformationRepository.getById(id);
basicInformation2.setBasicInformation(basicInformation.getBasicInformation());
basicInformationRepository.save(basicInformation2);
LOGGER.info("From class AboutUPDATEController,method : updatebasicInformationkById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}
//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/relationShip/update/{id}")
public ResponseEntity<String>updaterelationShipById(@PathVariable Long id,@RequestBody RelationShip relationShip){
	LOGGER.info("From class AboutUPDATEController,method : updaterelationShip()---ENTER--ID : "+id);
RelationShip relationShip2=relationShipRepository.getById(id);
relationShip2.setRelationShip(relationShip.getRelationShip());
relationShipRepository.save(relationShip2);
LOGGER.info("From class AboutUPDATEController,method : updaterelationShipById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}

//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/familyMembers/update/{id}")
public ResponseEntity<String>updatefamilyMembersById(@PathVariable Long id,@RequestBody FamilyMembers familyMembers){
	LOGGER.info("From class AboutUPDATEController,method : updatefamilyMembers()---ENTER--ID : "+id);
FamilyMembers familyMembers2=familyMembersRepository.getById(id);
familyMembers2.setFamilyMembers(familyMembers.getFamilyMembers());
familyMembers2.setRelation(familyMembers.getRelation());
familyMembersRepository.save(familyMembers2);
LOGGER.info("From class AboutUPDATEController,method : updatefamilyMembersById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}

//--------------------------------------------------------------------------------------------------------
@PutMapping(value="/favoriteQuotes/update/{id}")
public ResponseEntity<String>updatefavoriteQuotesById(@PathVariable Long id,@RequestBody FavoriteQoutes favoriteQoutes){
	LOGGER.info("From class AboutUPDATEController,method : updatefavoriteQuotes()---ENTER--ID : "+id);
FavoriteQoutes favoriteQoutes2=favoriteQuotesRepository.getById(id);
favoriteQoutes2.setFavoriteQuote(favoriteQoutes.getFavoriteQuote());
favoriteQuotesRepository.save(favoriteQoutes2);
LOGGER.info("From class AboutUPDATEController,method : updatefavoriteQuotesById()---UPDATED--ID : "+id);
return ResponseEntity.ok().body("success update !!!");



}


}
