package com.renu.profilestock.controllers;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.profilestock.models.ProfilePhotosEntity;
import com.renu.profilestock.repositories.ProfilePhotosEntityRepository;

@RestController
@RequestMapping(value="/photo")
public class GetProfilePhotoManageController {
private static final Logger LOGGER=LoggerFactory.getLogger(GetProfilePhotoManageController.class);
//PHOTO GET URL
	private static final String PHOTO_GET_URL="http://profile-service/photo/uid/";
	//GET PROFILE PHOTO URL
		private static final Path PROOFILE_PHOTO_URL = Paths.get("H:\\MiniFacebook-All-Images-Compressed\\");

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



//GET ALL PROFILE PHOTOS
public Resource loadProfileAllPhotos(String photoCode) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : loadProfileAllPhotos()---photoCode : "+photoCode);
	try {
		Path file = PROOFILE_PHOTO_URL.resolve(photoCode+".jpeg");
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


@GetMapping("/getProfilePhoto/{photoCode}")
public ResponseEntity<Resource> getAllPhotos(@PathVariable("photoCode")String photoCode) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : getAllPhotos()---photoCode : "+photoCode);
	
	Resource file = loadProfileAllPhotos(photoCode);
	return ResponseEntity.ok().body(file);
}


//GET  PROFILE SINGLE PHOTO
public Resource loadProfileSinglePhoto(String photoCode) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : loadProfileSinglePhoto()---photoCode : "+photoCode);
	try {
		Path file = PROOFILE_PHOTO_URL.resolve(photoCode+".jpeg");
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


@GetMapping("/getProfilePhoto/single/{uid}")
public ResponseEntity<Resource> getSingleProfilePhoto(@PathVariable("uid")String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : getSingleProfilePhoto()---UID : "+uid);
	//GET LATEST SINGLE VALUES
	List<ProfilePhotosEntity>list=new ArrayList<>();
	list=profilePhotosEntityRepository.getSingleProfilePhotoByUid(uid);
	ProfilePhotosEntity profilePhotosEntity=list.get(list.size()-1);
	String singlePhotoCode=profilePhotosEntity.getPhotoCode();
	
	Resource file = loadProfileSinglePhoto(singlePhotoCode);
	return ResponseEntity.ok().body(file);
}



}
