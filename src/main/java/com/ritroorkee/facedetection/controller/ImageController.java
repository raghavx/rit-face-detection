package com.ritroorkee.facedetection.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ritroorkee.facedetection.model.FileDetails;
import com.ritroorkee.facedetection.repository.FileDetailsRepository;

@RestController
public class ImageController {

	@Autowired
	private FileDetailsRepository fileDetailsRepository;

	// without throws 
	@GetMapping(value = "/image/{id}", 
			produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImages(@PathVariable("id") String id) 
	{
		FileDetails fd = 
				fileDetailsRepository.findById(id).get();
		String path = fd.getPath();
		try {
			return Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			return new byte[] {};
		}
	}

	
	
	
	
	// with throws 
	@GetMapping(value = "/images/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage(@PathVariable("id") String id) throws Exception {
		FileDetails fd = fileDetailsRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(fd.getPath()));
	}
}
