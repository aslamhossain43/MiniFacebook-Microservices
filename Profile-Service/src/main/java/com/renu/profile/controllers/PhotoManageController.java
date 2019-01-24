package com.renu.profile.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.profile.models.ProfilePhotosEntity;
import com.renu.profile.repositories.ProfilePhotosEntityRepository;

@RestController
@RequestMapping(value="/photos")
public class PhotoManageController {
private static final Logger LOGGER=LoggerFactory.getLogger(PhotoManageController.class);
@Autowired
private ProfilePhotosEntityRepository profilePhotosEntityRepository;


@RequestMapping(value="/add")
public ResponseEntity<String>addPhotos(@RequestBody ProfilePhotosEntity profilePhotosEntity){
	LOGGER.info("FROM  class PhotoManageController,method : add()--ENTER--");
	profilePhotosEntityRepository.save(profilePhotosEntity);
	return ResponseEntity.ok().body("success--from profile service");
}




}
