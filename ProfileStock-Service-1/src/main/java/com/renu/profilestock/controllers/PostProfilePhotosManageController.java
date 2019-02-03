package com.renu.profilestock.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.profilestock.config.RibbonConfiguration;
import com.renu.profilestock.models.ProfilePhotosEntity;
import com.renu.profilestock.repositories.ProfilePhotosEntityRepository;

@RestController
@RequestMapping(value = "/image")
@RibbonClient(name = "profileStock-service", configuration = RibbonConfiguration.class)
public class PostProfilePhotosManageController {
  
	// LOGGER
	private static final Logger LOGGER = LoggerFactory.getLogger(PostProfilePhotosManageController.class);
	//NOT STATIC OTHERWISE NOT WORKS
	@Autowired
	RestTemplate restTemplate;
	//BACKUP DATA
		@Autowired
		ProfilePhotosEntityRepository profilePhotosEntityRepository;
	// PHOTO CODE
	private String photoCode;
	// PHOTO ADD URL
	private static final String PHOTO_ADD_URL="http://profile-service/photos/add";
   //STORE RESPONSE
	ProfilePhotosEntity response =null;
	// CIRCUIT BREAKER
	// ADD PROFILE IMAGE METHOD
	@HystrixCommand(fallbackMethod = "fallbackForaddProfileImage")
	@PostMapping(value = "/addImage")
	public  ResponseEntity<ProfilePhotosEntity> addProfileImage(
			@RequestParam("selectedProfileImage") MultipartFile selectedProfileImage, @RequestParam("uid") String uid)
			throws Exception {

		LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--ENTER--");
		LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--UID: " + uid);

		
		
		if (selectedProfileImage.getContentType().equals("image/jpeg")
				|| selectedProfileImage.getContentType().equals("image/jpg")
				|| selectedProfileImage.getContentType().equals("image/png")
				|| selectedProfileImage.getContentType().equals("image/gif")) {
			
			this.photoCode = "PP" + UUID.randomUUID().toString().substring(26).toUpperCase();

			
			LOGGER.info(
					"FROM class ProfileImageManageController,method : addProfileImage()--PHOTO VALID AND CODE : " + photoCode);
			ProfilePhotosEntity profilePhotosEntity = new ProfilePhotosEntity();
			profilePhotosEntity.setUid(uid);
			profilePhotosEntity.setPhotoCode(this.photoCode);
			
			this.response = restTemplate.postForObject(PHOTO_ADD_URL, profilePhotosEntity,
					ProfilePhotosEntity.class);
			if (this.response!=null) {
				
			ProfilePhotosCompressionAndUploadController.profileImageCompression(selectedProfileImage, this.photoCode);

			this.photoCode = null;
			}
	           		
				
			
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.ok().body(null);
		}
           	
		
		
		
		
		
		
		
		
		
	}
//HYSTRIX fallbackForaddProfileImage
	public ResponseEntity<ProfilePhotosEntity> fallbackForaddProfileImage(@RequestParam("selectedProfileImage") MultipartFile selectedProfileImage,
			@RequestParam("uid") String uid,Throwable hystrixCommand) throws Exception {
		LOGGER.info("FROM class ProfileImageManageController,method : fallbackForaddProfileImage()--ENTER--");
		LOGGER.info("FROM class ProfileImageManageController,method : fallbackForaddProfileImage()--UID: " + uid);
		ProfilePhotosEntity profilePhotosEntity=null;
		if (selectedProfileImage.getContentType().equals("image/jpeg")
				|| selectedProfileImage.getContentType().equals("image/jpg")
				|| selectedProfileImage.getContentType().equals("image/png")
				|| selectedProfileImage.getContentType().equals("image/gif")) {

			profilePhotosEntity= new ProfilePhotosEntity();
			profilePhotosEntity.setUid(uid);
			profilePhotosEntity.setPhotoCode(this.photoCode);

			LOGGER.info(
					"FROM class ProfileImageManageController,method : fallbackForaddProfileImage()--PHOTO CODE : " + this.photoCode);
			
			
			profilePhotosEntityRepository.save(profilePhotosEntity);
			ProfilePhotosCompressionAndUploadController.profileImageCompression(selectedProfileImage, this.photoCode);
			
			
			
			this.photoCode = null;
			return ResponseEntity.ok().body(profilePhotosEntity);
		} else {
			return ResponseEntity.ok().body(profilePhotosEntity);
		}
	}
	
	


}

