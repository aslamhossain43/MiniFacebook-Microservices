package com.renu.zuul.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renu.zuul.models.Workplace;

@RestController
@RequestMapping(value="/zuul-profileAbout")
public class ProfileAboutRouteController {
private static final Logger LOGGER=LoggerFactory.getLogger(ProfileAboutRouteController.class);
// REST TEMPLATE
@Autowired
RestTemplate restTemplate;
// WORKPLACE ADD URL
private static final String WORKPLACE_ADD_URL="http://aboutStock-service/aboutStock-post/add";
//GET ALL WORKPLACES URL
private static final String GET_ALL_WORKPLACES_URL="http://aboutStock-service/aboutStock-get/workplace/getAll/";
//GET WORKPLACE BY ID URL
private static final String GET_SINGLE_WORKPLACE_URL="http://aboutStock-service/aboutStock-get/workplace/single/";
//UPDATE WORKPLACE BY ID URL
private static final String UPDATE_SINGLE_WORKPLACE_URL="http://aboutStock-service/aboutStock-update/workplace/update/";
//DELETE WORKPLACE BY ID URL
private static final String DELETE_SINGLE_WORKPLACE_URL="http://aboutStock-service/aboutStock-get/workplace/single/delete/";
@RequestMapping(value="/workplace/add")
public ResponseEntity<?>workplaceAdd(@RequestBody Workplace workplace){
	LOGGER.info("From class ProfileAboutRouteController,method : workplaceAdd()--ENTER--workplace : "+workplace.getWorkPlace());

Workplace responseEntity=restTemplate.postForObject(WORKPLACE_ADD_URL,workplace,Workplace.class);
return ResponseEntity.ok().body(responseEntity);
}

//---------------------
//GET ALL WORKPLACES
	@RequestMapping(value="/workplace/getAll/{uid}")
	public ResponseEntity<?>getAllWorkplaces(@PathVariable("uid") String uid) {
		LOGGER.info("FROM class ProfileStockServiceController,method : getAllWorkplaces()--ENTER--UID : "+uid);

		ResponseEntity<List<?>> profilePhotosEntities =
		        restTemplate.exchange(GET_ALL_WORKPLACES_URL+uid,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
		            });
		
		
		
		return profilePhotosEntities;
		
		
	}

//---------------------

	//GET WORKPLACE BY ID
		@RequestMapping(value="/workplace/single/{id}")
		public ResponseEntity<?>getSingleWorkplace(@PathVariable("id") Long id) {
			LOGGER.info("FROM class ProfileStockServiceController,method : getSingleWorkplace()--ENTER--ID : "+id);

			ResponseEntity<Workplace> profilePhotosEntity =
			        restTemplate.exchange(GET_SINGLE_WORKPLACE_URL+id,
			            HttpMethod.GET, null, new ParameterizedTypeReference<Workplace>() {
			            });
			
			
			
			return profilePhotosEntity;
			
			
		}

		//---------------------

		//DELETE WORKPLACE BY ID
			@RequestMapping(value="/workplace/single/delete/{id}")
			public ResponseEntity<?>getSingleDELETEWorkplace(@PathVariable("id") Long id) {
				LOGGER.info("FROM class ProfileStockServiceController,method : getSingleWorkplace()--ENTER--ID : "+id);

				ResponseEntity<String> profilePhotosEntity =
				        restTemplate.exchange(DELETE_SINGLE_WORKPLACE_URL+id,
				            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				            });
				
				
				
				return profilePhotosEntity;
				
				
			}

			//---------------------

			//UPDATE WORKPLACE BY ID
				@RequestMapping(value="/workplace/update/{id}")
				public ResponseEntity<?>updateSingleWorkplace(@RequestBody Workplace workplace,@PathVariable("id") Long id) {
					LOGGER.info("FROM class ProfileStockServiceController,method : updateSingleWorkplace()--ENTER--ID : "+id);
                restTemplate.put(UPDATE_SINGLE_WORKPLACE_URL+id, workplace);
					return ResponseEntity.ok().body("success update");
					
				}

}
