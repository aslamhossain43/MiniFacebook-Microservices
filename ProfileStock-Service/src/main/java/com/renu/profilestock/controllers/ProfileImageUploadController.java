package com.renu.profilestock.controllers;

import java.io.File;

import javax.imageio.ImageWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileImageUploadController {
private static final Logger LOGGER=LoggerFactory.getLogger(ProfileImageUploadController.class);
private static final String PROOFILE_IMAGE_URL="F:\\";
public static void profileImageUpload(ImageWriter imageWriter,String profileImageCode) {
	LOGGER.info("FROM class ProfileImageUploadController,method : profileImageUpload()");
	File location=new File(PROOFILE_IMAGE_URL+profileImageCode+".jpeg");
	imageWriter.setOutput(location);
	
	
	
	
	
}




}
