package com.renu.profile.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.profile.models.ProfilePhotosEntity;
import com.renu.profile.repositories.ProfilePhotosEntityRepository;

@RestController
@RequestMapping(value="/photo")
public class PhotoGETController {
private static final Logger LOGGER=LoggerFactory.getLogger(PhotoGETController.class);



@Autowired
ProfilePhotosEntityRepository profilePhotosEntityRepository;
//GET ALL PROFILE PHOTO INFORMATION

@GetMapping(value="/uid/{uid}")
public ResponseEntity<List<ProfilePhotosEntity>> getAllPhotosByUID(@PathVariable String uid) {
	LOGGER.info("FROM class PhotoGETController, method : getAllPhotosByUID()--UID: "+uid);
	List<ProfilePhotosEntity> profilePhotosEntity=profilePhotosEntityRepository.getAllProfilePhotosByUid(uid);
	return ResponseEntity.ok().body(profilePhotosEntity);
}

//GET LAST PROFILE PHOTO INFORMATION

@GetMapping(value="/uid/last/{uid}")
public ResponseEntity<List<ProfilePhotosEntity>> getLastPhoto(@PathVariable String uid) {
	LOGGER.info("FROM class PhotoGETController, method : getLastPhoto()--UID: "+uid);
	List<ProfilePhotosEntity> profilePhotosEntity=profilePhotosEntityRepository.getAllProfilePhotosByUid(uid);
	List<ProfilePhotosEntity>profilePhotosEntities=new ArrayList<ProfilePhotosEntity>();
	ProfilePhotosEntity profilePhotosEntity2=profilePhotosEntity.get(0);
	profilePhotosEntities.add(profilePhotosEntity2);
	return ResponseEntity.ok().body(profilePhotosEntities);
}



}
