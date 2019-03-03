package com.renu.profile.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.profile.models.ProfilePhotosEntity;
import com.renu.profile.repositories.ProfilePhotosEntityRepository;



@RestController
@RequestMapping(value="/delete")
public class PhotoDELETEController {
private static final Logger LOGGER=LoggerFactory.getLogger(PhotoDELETEController.class);


@Autowired
ProfilePhotosEntityRepository profilePhotosEntityRepository;
//DELETE PROFILE PHOTO BY ID
@RequestMapping(value="/profilePhoto/single/{id}")
public ResponseEntity<?>deleteSingleProfilePhotoById(@PathVariable("id")Long id){
LOGGER.info("From class PhotoDELETEController, method:deleteSingleProfilePhotoById()--ENTER--ID : "+id);
ProfilePhotosEntity profilePhotosEntity=profilePhotosEntityRepository.getById(id);
profilePhotosEntityRepository.delete(profilePhotosEntity);
return  ResponseEntity.ok().body("success delete !!");

}

}
