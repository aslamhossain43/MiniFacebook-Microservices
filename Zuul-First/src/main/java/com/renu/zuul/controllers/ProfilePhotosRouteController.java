package com.renu.zuul.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.renu.zuul.config.RibbonConfiguration;
@RestController
@RequestMapping(value="/zuul-profileStock")
@RibbonClient(name = "zuul-ribbon", configuration = RibbonConfiguration.class)
public class ProfilePhotosRouteController {
private static final Logger LOGGER=LoggerFactory.getLogger(ProfilePhotosRouteController.class);
//PHOTO ALL GET URL
	private static final String GET_PROFILE_PHOTO_INFORMATION="http://minifacebookstock-service/photo/uid/";

	// LAST PHOTO GET URL
		private static final String GET_LAST_PROFILE_PHOTO_INFORMATION="http://minifacebookstock-service/photo/uid/last/";
	
	//PHOTO GET BY ALL PHOTOS PHOTO CODE
		private static final String GET_PROFILE_ALL_PHOTOS="http://minifacebookstock-service/photo/getProfilePhoto/";
	
		// SINGLE PHOTO GET BU UID
				private static final String GET_PROFILE_SINGLE_PHOTO="http://minifacebookstock-service/photo/getProfilePhoto/single/";
			
		// PHOTO ADD URL
		private static final String PHOTO_ADD_URL="http://minifacebookstock-service/image/addImage";
		//DELETE SINGLE PROFILE PHOTO
		private static final String DELETE_SINGLE_PROFILE_PHOTO_URL="http://minifacebookstock-service/delete/profilePhoto/single/";
	//FOR RIBBON
	@Autowired
	RestTemplate restTemplate;
	
	// SEND UID TO GET PROFILE PHOTOS INFORMATIONS
	@RequestMapping(value="/getprofilephotoinformation/{uid}")
	public ResponseEntity<?>getprofilephotoinformation(@PathVariable("uid") String uid) {
		LOGGER.info("FROM class ProfileStockServiceController,method : getprofilephotoinformation()--ENTER--UID : "+uid);

		ResponseEntity<List<?>> profilePhotosEntities =
		        restTemplate.exchange(GET_PROFILE_PHOTO_INFORMATION+uid,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
		            });
		
		
		
		return profilePhotosEntities;
		
		
	}
	
	// SEND UID TO GET LAST PROFILE PHOTO INFORMATION
		@RequestMapping(value="/getprofilephotoinformation/last/{uid}")
		public ResponseEntity<?>getLastProfilephotoinformation(@PathVariable("uid") String uid) {
			LOGGER.info("FROM class ProfileStockServiceController,method : getLastProfilephotoinformation()--ENTER--UID : "+uid);

			ResponseEntity<List<?>> profilePhotosEntities =
			        restTemplate.exchange(GET_LAST_PROFILE_PHOTO_INFORMATION+uid,
			            HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
			            });
			
			
			
			return profilePhotosEntities;
			
			
		}
	
	
	
	
	//ADD PROFILE PHOTO
	@RequestMapping(value="/profileimageadd")
	public ResponseEntity<?>profileimageadd(@RequestParam("selectedProfileImage") MultipartFile selectedProfileImage, @RequestParam("uid") String uid) throws Exception {
		LOGGER.info("FROM class ProfileStockServiceController,method : profileimageadd()--ENTER--UID : "+uid);

		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String,Object>();
		map.add("selectedProfileImage", new MultipartFileResource(selectedProfileImage.getInputStream(), selectedProfileImage.getOriginalFilename()));
		map.add("uid", uid);
		String response=restTemplate.postForObject(PHOTO_ADD_URL,map, String.class);
		return ResponseEntity.ok().body(response);
	}
	
	// SEND PHOTO CODE TO GET ALL PHOTOS ACCORDING TO UID
	@RequestMapping(value="/photoCode/{photoCode}")
	public ResponseEntity<?>getProfileAllPhotos(@PathVariable("photoCode") String photoCode) {
		LOGGER.info("FROM class ProfileStockServiceController,method : getProfileAllPhotos()--ENTER--photoCode : "+photoCode);

		ResponseEntity<?> profilePhoto =
		        restTemplate.getForEntity(GET_PROFILE_ALL_PHOTOS+photoCode,Resource.class);
		
		
		
		return profilePhoto;
		
		
	}
	
	
	
	// SEND PHOTO CODE TO GET SINGLE PHOTO
		@RequestMapping(value="/single/photoCode/{photoCode}")
		public ResponseEntity<Resource>getProfileSinglePhoto(@PathVariable("photoCode") String photoCode) {
			LOGGER.info("FROM class ProfileStockServiceController,method : getProfileSinglePhoto()--ENTER--photoCode : "+photoCode);

			ResponseEntity<Resource> profilePhoto =
			        restTemplate.getForEntity(GET_PROFILE_SINGLE_PHOTO+photoCode,Resource.class);
			
			
			
			return profilePhoto;
			
			
		}
		
		//  DELETE PROFILE SINGLE PHOTO BY ID
				@RequestMapping(value="/delete/profilePhoto/single/{id}")
				public ResponseEntity<?>deleteProfileSinglePhoto(@PathVariable("id") String id) {
					LOGGER.info("FROM class ProfileStockServiceController,method : deleteProfileSinglePhoto()--ENTER--ID : "+id);
					
					ResponseEntity<?>responseEntity=restTemplate.getForEntity(DELETE_SINGLE_PROFILE_PHOTO_URL+id, String.class);
					
					
					
					return responseEntity;
					
					
				}
				
				
				
				
	
	
}

