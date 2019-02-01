package com.renu.zuul.controllers;

import java.io.InputStream;

import org.springframework.core.io.InputStreamResource;

public class MultipartFileResource extends InputStreamResource {

	  private String filename;
	public MultipartFileResource(InputStream inputStream, String filename) {
	    super(inputStream);
	    this.filename = filename;
	  }
	  @Override
	  public String getFilename() {
	    return this.filename;
	  }
	  @Override
	    public long contentLength(){
	        return -1; // we do not want to generally read the whole stream into memory ...
	    }
	}