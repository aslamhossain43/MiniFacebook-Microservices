package com.renu.profilestock.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.profilestock.models.ProfilePhotosEntity;
import com.renu.profilestock.repositories.ProfilePhotosEntityRepository;

@RestController
@RequestMapping(value="/photo")
public class GetProfilePhotoManageController {
private static final Logger LOGGER=LoggerFactory.getLogger(GetProfilePhotoManageController.class);
//PHOTO GET URL
	private static final String PHOTO_GET_URL="http://profile-service/photo/uid/";


@Autowired
RestTemplate restTemplate;
//BACKUP DATA
		@Autowired
		ProfilePhotosEntityRepository profilePhotosEntityRepository;


//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackForStorUID")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/uid/{uid}")
public ResponseEntity<List<ProfilePhotosEntity>> storeUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : storeUID()---ENTER--");
	LOGGER.info("FROM class GetProfilePhotoManageController,method : storeUID()---UID : "+uid);
	
	
	
	ResponseEntity<List<ProfilePhotosEntity>> profilePhotosEntities =
	        restTemplate.exchange(PHOTO_GET_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<ProfilePhotosEntity>>() {
	            });
	
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackForStorUID
public ResponseEntity<List<ProfilePhotosEntity>> fallbackForStorUID(@PathVariable("uid") String uid,Throwable hystrixCommand) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackForStorUID---UID : "+uid);
	List<ProfilePhotosEntity> profilePhotosEntity=profilePhotosEntityRepository.getAllProfilePhotosByUid(uid);
	return ResponseEntity.ok().body(profilePhotosEntity);
}



}
