package com.renu.profilestock.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.renu.profilestock.models.ProfilePhotosEntity;

@RestController
@RequestMapping(value = "/image")
public class ProfilePhotosManageController {
	// LOGGER
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePhotosManageController.class);
    //REST TEMPLATE
	@Autowired
	private static RestTemplate restTemplate;
	//PHOTO CODE
	private static  String photoCode;
	// PHOTO ADD URL
	private static final String PHOTO_ADD_URL="http://PROFILE-SERVICE:8084/photos/add";
	//ADD PROFILE IMAGE METHOD
	@PostMapping(value = "/addImage")
	public static ResponseEntity<String> addProfileImage(
			@RequestParam("selectedProfileImage") MultipartFile selectedProfileImage,
			@RequestParam("uid") String uid) throws Exception {
		LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--ENTER--");
		LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--UID: "+uid);
         
		
		if (selectedProfileImage.getContentType().equals("image/jpeg") || selectedProfileImage.getContentType().equals("image/jpg")
				|| selectedProfileImage.getContentType().equals("image/png") || selectedProfileImage.getContentType().equals("image/gif")) {

			photoCode = "PP" + UUID.randomUUID().toString().substring(26).toUpperCase();
		
		ProfilePhotosCompressionAndUploadController.profileImageCompression(selectedProfileImage,photoCode);
          
		ProfilePhotosEntity profilePhotosEntity=new ProfilePhotosEntity();
		profilePhotosEntity.setUid(uid);
		profilePhotosEntity.setPhotoCode(photoCode);
		
		LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--PHOTO CODE : "+photoCode);
          // Send request with POST method.
		 HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    HttpEntity<String> entity = new HttpEntity<String>(profilePhotosEntity.toString(),headers);
		    restTemplate.put(PHOTO_ADD_URL,entity);
				
	      photoCode=null;
		return ResponseEntity.ok().body("Photo add success !!");
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}

}

