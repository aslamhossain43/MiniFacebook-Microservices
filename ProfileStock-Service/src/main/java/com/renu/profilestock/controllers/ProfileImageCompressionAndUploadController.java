package com.renu.profilestock.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

public class ProfileImageCompressionAndUploadController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileImageCompressionAndUploadController.class);

	private static final String COMPRESSED_PROOFILE_IMAGE_URL = "H:\\MiniFacebook-All-Images-Compressed\\";
	private static final Path PRE_COMPRESSION_ABS_PATH = Paths
			.get("H:\\MiniFacebook-All-Images-Pre-Compression-Dont-Delete-this\\");

	static String profileImageCode = null;

	public static void profileImageCompression(MultipartFile profileImage, String pImageode) throws Exception {
		LOGGER.info("FROM class ProfileImageCompressionController,method: profileImageCompression()--ENTER--");
		profileImageCode = pImageode;
		FileImageOutputStream output;
		BufferedImage realProfileImageToCompresse = null;
		Files.copy(profileImage.getInputStream(), PRE_COMPRESSION_ABS_PATH.resolve(profileImageCode + ".jpg"));
		File forCompressionProfileImage = new File(PRE_COMPRESSION_ABS_PATH + profileImageCode + ".jpg");

		// MUST USE STRING URL NOT A VARIABLE
		String prefix = "H:\\MiniFacebook-All-Images-Pre-Compression-Dont-Delete-this\\";
		String[] ids = { profileImageCode };
		String ext = ".jpg";
		Image[] images = new Image[ids.length];
		for (int i = 0; i < images.length; i++) {
			String path = prefix + ids[i] + ext;
			realProfileImageToCompresse = ImageIO.read(new File(path));
		}

		// CONVERT INTO STREAM
		OutputStream os = new FileOutputStream(forCompressionProfileImage);
		// NEED A WRITER TO CONVERT A SPECIFIC FORMAT
		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
		ImageWriter writer = (ImageWriter) writers.next();

		// CREATE IMAGE OUTPUT STREAM
		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();

		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(0.9f); // compress the quality value you prefer
		File file = new File(COMPRESSED_PROOFILE_IMAGE_URL + profileImageCode + ".jpg");
		output = new FileImageOutputStream(file);
		writer.setOutput(output);
		writer.write(null, new IIOImage(realProfileImageToCompresse, null, null), param);

		os.close();
		ios.close();
		writer.dispose();
		// MUST USE STRING URL NOT A VARIABLE
		File afterCompressedImageFile = new File(
				"H:\\MiniFacebook-All-Images-Pre-Compression-Dont-Delete-this\\" + profileImageCode + ".jpg");
		afterCompressedImageFile.delete();
		LOGGER.info("FROM class ProfileImageCompressionController,method: profileImageCompression()--DELETED--"
				+ profileImageCode + ".jpg");
		profileImageCode = null;
	}

}
