package com.renu.aboutStock.controllers;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renu.about.models.Workplace;
import com.renu.about.repositories.WorkPlaceRepository;

@RestController
@RequestMapping(value="/aboutStock-get")
public class AboutGETController {
private static final Logger LOGGER=LoggerFactory.getLogger(AboutGETController.class);
// WORKPLACE REPOSITORY
@Autowired
WorkPlaceRepository workPlaceRepository;
// REST TEMPLATE
@Autowired
RestTemplate restTemplate;
//GET ALL WORKPLACES URL
private static final String GET_ALL_WORKPLACES_URL="http://about-service/about-get/workplace/getAll/";
//GET WORKPLACE BY URL
private static final String GET_SINGLE_WORKPLACE_URL="http://about-service/about-get/workplace/single/";
//DELETE WORKPLACE BY URL
private static final String DELETE_SINGLE_WORKPLACE_URL="http://about-service/about-get/workplace/single/delete/";
//----------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceGETAll")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/getAll/{uid}")
public ResponseEntity<List<Workplace>> getAllWorkplaceByUID(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : getAllWorkplaceByUID()---UID : "+uid);
	
	
	ResponseEntity<List<Workplace>> profilePhotosEntities =
	        restTemplate.exchange(GET_ALL_WORKPLACES_URL+uid,
	            HttpMethod.GET, null, new ParameterizedTypeReference<List<Workplace>>() {
	            });
	
	
	
	return profilePhotosEntities;


}
//HYSTRIX FOR fallbackForStorUID
public ResponseEntity<List<Workplace>> fallbackWorkplaceGETAll(@PathVariable("uid") String uid) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackWorkplaceGETAll()---UID : "+uid);
	List<Workplace> profilePhotosEntity=workPlaceRepository.getAllWorkplacesByUID(uid);
	return ResponseEntity.ok().body(profilePhotosEntity);
}



//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceGETByID")
//GET UID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/single/{id}")
public ResponseEntity<Workplace> getSingleWorkplaceByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : getSingleWorkplaceByID()---ID : "+id);
	
	
	ResponseEntity<Workplace> profilePhotosEntity =
	        restTemplate.exchange(GET_SINGLE_WORKPLACE_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<Workplace>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceGETByID
public ResponseEntity<Workplace> fallbackWorkplaceGETByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackWorkplaceGETByID()---ID : "+id);
	Workplace profilePhotosEntity=workPlaceRepository.getById(id);
	return ResponseEntity.ok().body(profilePhotosEntity);
}


//-----------------------------------------

//HYSTRIX
@HystrixCommand(fallbackMethod = "fallbackWorkplaceDELETEByID")
//DELETE ID FOR HANDLING OTHER PROCESS
@GetMapping(value="/workplace/single/delete/{id}")
public ResponseEntity<String> deleteSingleWorkplaceByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : deleteSingleWorkplaceByID()---ID : "+id);
	
	
	ResponseEntity<String> profilePhotosEntity =
	        restTemplate.exchange(DELETE_SINGLE_WORKPLACE_URL+id,
	            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	            });
	
	
	
	return profilePhotosEntity;


}
//HYSTRIX fallbackWorkplaceDELETEByID
public ResponseEntity<String> fallbackWorkplaceDELETEByID(@PathVariable("id") Long id) {
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackWorkplaceDELETEByID---ID : "+id);
	Workplace profilePhotosEntity=workPlaceRepository.getById(id);
	workPlaceRepository.delete(profilePhotosEntity);
	LOGGER.info("FROM class GetProfilePhotoManageController,method : fallbackWorkplaceDELETEByID--DELETE--ID : "+id);
	return ResponseEntity.ok().body("success delete");
}

//-----------------------------

}
