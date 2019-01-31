package com.renu.profilestock.controllers;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.profilestock.config.RibbonConfiguration;
import com.renu.profilestock.models.ProfilePhotosEntity;

@RestController
@RequestMapping(value = "/image")
@RibbonClient(name = "profileStock-stock", configuration = RibbonConfiguration.class)
public class ProfilePhotosManageController {
  
	// LOGGER
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePhotosManageController.class);
	//NOT STATIC OTHERWISE NOT WORKS
	@Autowired
	RestTemplate restTemplate;
	// PHOTO CODE
	private static String photoCode;
	// PHOTO ADD URL
	private static final String PHOTO_ADD_URL="http://profile-service/photos/add";
    //GET PROFILE PHOTO URL
	private static final Path PROOFILE_PHOTO_URL = Paths.get("H:\\MiniFacebook-All-Images-Compressed\\");
	
	// CIRCUIT BREAKER
	// ADD PROFILE IMAGE METHOD
	@HystrixCommand(fallbackMethod = "fallback")
	@PostMapping(value = "/addImage")
	public  ResponseEntity<String> addProfileImage(
			@RequestParam("selectedProfileImage") MultipartFile selectedProfileImage, @RequestParam("uid") String uid)
			throws Exception {

		LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--ENTER--");
		LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--UID: " + uid);

		if (selectedProfileImage.getContentType().equals("image/jpeg")
				|| selectedProfileImage.getContentType().equals("image/jpg")
				|| selectedProfileImage.getContentType().equals("image/png")
				|| selectedProfileImage.getContentType().equals("image/gif")) {

			photoCode = "PP" + UUID.randomUUID().toString().substring(26).toUpperCase();

			ProfilePhotosCompressionAndUploadController.profileImageCompression(selectedProfileImage, photoCode);
			ProfilePhotosEntity profilePhotosEntity = new ProfilePhotosEntity();
			profilePhotosEntity.setUid(uid);
			profilePhotosEntity.setPhotoCode(photoCode);

			LOGGER.info(
					"FROM class ProfileImageManageController,method : addProfileImage()--PHOTO CODE : " + photoCode);
			
			ProfilePhotosEntity response = restTemplate.postForObject(PHOTO_ADD_URL, profilePhotosEntity,
					ProfilePhotosEntity.class);
			LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--Getting Response : "
					+ response);

			photoCode = null;
			return ResponseEntity.ok().body("Photo add success !!");
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	public ResponseEntity<String> fallback(@RequestParam("selectedProfileImage") MultipartFile selectedProfileImage,
			@RequestParam("uid") String uid,Throwable hystrixCommand) {
		return ResponseEntity.ok().body("success");
	}
	
	
	
	public Resource loadProfilePhoto() {
		try {
			Path file = PROOFILE_PHOTO_URL.resolve("photoName.png");
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	
	@GetMapping("/getProfilePhoto")
	public ResponseEntity<Resource> getFile() {
		Resource file = loadProfilePhoto();
		return ResponseEntity.ok().body(file);
	}
	
	

}

