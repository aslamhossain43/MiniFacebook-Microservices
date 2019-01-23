package com.renu.profilestock.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/image")
public class ProfileImageManageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileImageManageController.class);

	@PostMapping(value = "/addImage")
	public static ResponseEntity<?> addProfileImage(
			@RequestParam("selectedProfileImage") MultipartFile selectedProfileImage) throws Exception {
		LOGGER.info("FROM class ProfileImageManageController,method : addProfileImage()--ENTER--");

		ProfileImageCompressionController.profileImageCompression(selectedProfileImage,
				UUID.randomUUID().toString().substring(26).toUpperCase());

		return ResponseEntity.ok().body(null);
	}

}
