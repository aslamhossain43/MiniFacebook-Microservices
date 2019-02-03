package com.renu.profilestock.controllers;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.profilestock.models.ProfilePhotosEntity;
import com.renu.profilestock.repositories.ProfilePhotosEntityRepository;

@RestController
@RequestMapping(value="/delete")
public class DeleteProfilePhotosController {
private static final Logger LOGGER=LoggerFactory.getLogger(DeleteProfilePhotosController.class);
private static final String COMPRESSED_PROOFILE_IMAGE_URL = "H:\\MiniFacebook-All-Images-Compressed\\";
private static final String DELETE_PROOFILE_PHOTO_URL = "http://profile-service/delete/profilePhoto/single/";
@Autowired
private ProfilePhotosEntityRepository profilePhotosEntityRepository;
@Autowired
RestTemplate restTemplate;
// DELETE SINGLE PROFILE PHOTO
@HystrixCommand(fallbackMethod="falbackDeleteSingleProfilePhotoById")
@RequestMapping(value="/profilePhoto/single/{id}")
public ResponseEntity<?>deleteSingleProfilePhotoById(@PathVariable("id")Long id){
	LOGGER.info("From class DeleteProfilePhotosController, method : deleteSingleProfilePhotoById()--ENTER--ID : "+id);
    ProfilePhotosEntity profilePhotosEntity=profilePhotosEntityRepository.getById(id);
    String photoCode=profilePhotosEntity.getPhotoCode();
    LOGGER.info("From class DeleteProfilePhotosController, method : deleteSingleProfilePhotoById()--Getting photoCode : "+photoCode);
   File photo=new File(COMPRESSED_PROOFILE_IMAGE_URL+photoCode+".jpeg");
   photo.delete();
   LOGGER.info("From class DeleteProfilePhotosController, method : deleteSingleProfilePhotoById()--DELETE : "+photoCode+".jpeg");
   ResponseEntity<?>pResponseEntity=restTemplate.getForEntity(DELETE_PROOFILE_PHOTO_URL+id,String.class);
   
return pResponseEntity;

}
public ResponseEntity<?>falbackDeleteSingleProfilePhotoById(@PathVariable("id")Long id){
	LOGGER.info("From class DeleteProfilePhotosController, method : falbackDeleteSingleProfilePhotoById--ENTER--ID : "+id);
    ProfilePhotosEntity profilePhotosEntity=profilePhotosEntityRepository.getById(id);
    profilePhotosEntityRepository.delete(profilePhotosEntity);
    LOGGER.info("From class DeleteProfilePhotosController, method : falbackDeleteSingleProfilePhotoById--DELETE COMPLETED--ID : "+id);
return ResponseEntity.ok().body("success delete !!");

}


}
