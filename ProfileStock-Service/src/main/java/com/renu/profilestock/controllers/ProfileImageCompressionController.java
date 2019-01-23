package com.renu.profilestock.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class ProfileImageCompressionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileImageCompressionController.class);
	
	static FileImageOutputStream output = null;
    

	public static void profileImageCompression(MultipartFile profileImage, String profileImgaeCode) throws Exception {
		LOGGER.info("FROM class ProfileImageCompressionController,method: profileImageCompression()--ENTER--");
		File compressedImageFile = (File) profileImage;
		BufferedImage bufferedRealimage = ImageIO.read(compressedImageFile);
		// CONVERT INTO STREAM
		OutputStream os = new FileOutputStream(compressedImageFile);
		// NEED A WRITER TO CONVERT A SPECIFIC FORMAT
		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
		ImageWriter writer = (ImageWriter) writers.next();

		// CREATE IMAGE OUTPUT STREAM
		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();

		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(0.9f); // compress the quality value you prefer
		//File file = new File("F:\\s.jpeg");
		//output = new FileImageOutputStream(file);
		ProfileImageUploadController.profileImageUpload(writer, profileImgaeCode);
		//writer.setOutput(output);
		writer.write(null, new IIOImage(bufferedRealimage, null, null), param);

		os.close();
		ios.close();
		writer.dispose();

	}

}
