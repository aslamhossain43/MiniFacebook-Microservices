package com.renu.zuul.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.renu.zuul.config.RibbonConfiguration;

@RestController
@RequestMapping(value="/zuul-profileStock")
@RibbonClient(name = "zuul-ribbon", configuration = RibbonConfiguration.class)
public class ProfileStockServiceController {
private static final Logger LOGGER=LoggerFactory.getLogger(ProfileStockServiceController.class);
//PHOTO GET URL
	private static final String PHOTO_GET_URL="http://profileStock-service/photo/uid/";
	// PHOTO ADD URL
		private static final String PHOTO_ADD_URL="http://profileStock-service/image/addImage";
	//FOR RIBBON
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping(value="/getprofilephotoinformation/{uid}")
	public ResponseEntity<?>getprofilephotoinformation(@PathVariable("uid") String uid) {
		LOGGER.info("FROM class ProfileStockServiceController,method : getprofilephotoinformation()--ENTER--UID : "+uid);

		ResponseEntity<List<?>> profilePhotosEntities =
		        restTemplate.exchange(PHOTO_GET_URL+uid,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
		            });
		
		
		
		return profilePhotosEntities;
		
		
	}
	
	
	
	
	@RequestMapping(value="/profileimageadd")
	public ResponseEntity<?>profileimageadd(@RequestParam("selectedProfileImage") MultipartFile selectedProfileImage, @RequestParam("uid") String uid) throws Exception {
		LOGGER.info("FROM class ProfileStockServiceController,method : profileimageadd()--ENTER--UID : "+uid);

		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String,Object>();
		map.add("selectedProfileImage", new MultipartFileResource(selectedProfileImage.getInputStream(), selectedProfileImage.getOriginalFilename()));
		map.add("uid", uid);
		String response=restTemplate.postForObject(PHOTO_ADD_URL,map, String.class);
		return ResponseEntity.ok().body(response);
	}
	
	
	
	
	
}

