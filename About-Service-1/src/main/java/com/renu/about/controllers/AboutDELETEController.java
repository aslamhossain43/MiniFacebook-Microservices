package com.renu.about.controllers;

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
		@Autowired
		CurrentCityRepository currentCityRepository;
		// ---------------------------------------------------------------------------------------------------------------
				@Autowired
				HomeTownRepository homeTownRepository;
				// ---------------------------------------------------------------------------------------------------------------
				@Autowired
				OtherPlacesLivedRepository otherPlacesLivedRepository;
				
				// ---------------------------------------------------------------------------------------------------------------
				@Autowired
				ContactInformationRepository contactInformationRepository;
				// ---------------------------------------------------------------------------------------------------------------
				@Autowired
				WebSiteAndSocialLinkRepository webSiteAndSocialLinkRepository;
				// ---------------------------------------------------------------------------------------------------------------
				@Autowired
				BasicInformationRepository basicInformationRepository;
				// ---------------------------------------------------------------------------------------------------------------
				@Autowired
				RelationShipRepository relationShipRepository;
				// ---------------------------------------------------------------------------------------------------------------
				@Autowired
				FamilyMembersRepository familyMembersRepository;
				// ---------------------------------------------------------------------------------------------------------------
				@Autowired
				FavoriteQuotesRepository favoriteQuotesRepository;
				
				
				
				
				
				
				
				
				
				
				
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

		// DELETE HIGH SCHOOL BY ID
		@GetMapping(value = "/highSchool/single/delete/{id}")
		public ResponseEntity<String> deleteSingleHighSchoolByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSingleHighSchoolByID()--ENTER--ID : " + id);
			HighSchool highSchool=highSchoolRepository.getById(id);
			highSchoolRepository.delete(highSchool);
			LOGGER.info("From class AboutDELETEController,method : deleteSingleHighSchoolByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}
		// ------------------------------------------------------------------------------------------------------------------

		// DELETE CURRENT CITY BY ID
		@GetMapping(value = "/currentCity/single/delete/{id}")
		public ResponseEntity<String> deleteSingleCurrentCityByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSingleCurrentCityByID()--ENTER--ID : " + id);
			CurrentCity currentCity=currentCityRepository.getById(id);
			currentCityRepository.delete(currentCity);
			LOGGER.info("From class AboutDELETEController,method : deleteSingleCurrentCityByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}
		// ------------------------------------------------------------------------------------------------------------------

		// DELETE HOME TOWN ID
		@GetMapping(value = "/homeTown/single/delete/{id}")
		public ResponseEntity<String> deleteSingleHomeTownByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSingleHomeTownByID()--ENTER--ID : " + id);
			HomeTown homeTown=homeTownRepository.getById(id);
			homeTownRepository.delete(homeTown);
			LOGGER.info("From class AboutDELETEController,method : deleteSingleHomeTownByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}
		// ------------------------------------------------------------------------------------------------------------------

		// DELETE OTHER PLACES LIVED ID
		@GetMapping(value = "/otherPlacesLived/single/delete/{id}")
		public ResponseEntity<String> deleteSingleotherPlacesLivedByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSingleotherPlacesLivedByID()--ENTER--ID : " + id);
			OtherPlacesLived otherPlacesLived=otherPlacesLivedRepository.getById(id);
			otherPlacesLivedRepository.delete(otherPlacesLived);;
			LOGGER.info("From class AboutDELETEController,method : deleteSingleotherPlacesLivedByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}

		
		// ------------------------------------------------------------------------------------------------------------------

		// DELETE CONTACT INFORMATION ID
		@GetMapping(value = "/contactInformation/single/delete/{id}")
		public ResponseEntity<String> deleteSinglecontactInformationByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSinglecontactInformationByID()--ENTER--ID : " + id);
			ContactInformation contactInformation=contactInformationRepository.getById(id);
			contactInformationRepository.delete(contactInformation);
			LOGGER.info("From class AboutDELETEController,method : deleteSinglecontactInformationByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}

		// ------------------------------------------------------------------------------------------------------------------

		// DELETE webSiteAndSocialLink ID
		@GetMapping(value = "/webSiteAndSocialLink/single/delete/{id}")
		public ResponseEntity<String> deleteSinglewebSiteAndSocialLinkByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSinglewebSiteAndSocialLinkByID()--ENTER--ID : " + id);
			WebSiteAndSocialLink webSiteAndSocialLink=webSiteAndSocialLinkRepository.getById(id);
			webSiteAndSocialLinkRepository.delete(webSiteAndSocialLink);
			LOGGER.info("From class AboutDELETEController,method : deleteSinglewebSiteAndSocialLinkByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}
		// ------------------------------------------------------------------------------------------------------------------

		// DELETE basicInformation ID
		@GetMapping(value = "/basicInformation/single/delete/{id}")
		public ResponseEntity<String> deleteSinglebasicInformationByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSinglebasicInformationByID()--ENTER--ID : " + id);
			BasicInformation basicInformation=basicInformationRepository.getById(id);
			basicInformationRepository.delete(basicInformation);
			LOGGER.info("From class AboutDELETEController,method : deleteSinglebasicInformationByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}
		// ------------------------------------------------------------------------------------------------------------------

		// DELETE relationShip ID
		@GetMapping(value = "/relationShip/single/delete/{id}")
		public ResponseEntity<String> deleteSinglerelationShipByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSinglerelationShipByID()--ENTER--ID : " + id);
			RelationShip relationShip=relationShipRepository.getById(id);
			relationShipRepository.delete(relationShip);
			LOGGER.info("From class AboutDELETEController,method : deleteSinglerelationShipByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}
		// ------------------------------------------------------------------------------------------------------------------

		// DELETE familyMembers ID
		@GetMapping(value = "/familyMembers/single/delete/{id}")
		public ResponseEntity<String> deleteSinglefamilyMembersByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSinglefamilyMembersByID()--ENTER--ID : " + id);
			FamilyMembers familyMembers=familyMembersRepository.getById(id);
			familyMembersRepository.delete(familyMembers);
			LOGGER.info("From class AboutDELETEController,method : deleteSinglefamilyMembersByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}
		
		// ------------------------------------------------------------------------------------------------------------------

		// DELETE favoriteQuotes ID
		@GetMapping(value = "/favoriteQuotes/single/delete/{id}")
		public ResponseEntity<String> deleteSinglefavoriteQuotesByID(@PathVariable("id") Long id) {
			LOGGER.info("From class AboutDELETEController,method : deleteSinglefavoriteQuotesByID()--ENTER--ID : " + id);
			FavoriteQoutes favoriteQoutes=favoriteQuotesRepository.getById(id);
			favoriteQuotesRepository.delete(favoriteQoutes);
			LOGGER.info("From class AboutDELETEController,method : deleteSinglefavoriteQuotesByID()--DELETED--ID : " + id);

			return ResponseEntity.ok().body("SuccessCallback delete");
		}
		
		
		
		
		
		
}
