package com.ritroorkee.facedetection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ritroorkee.facedetection.model.FileUpload;

@RestController
public class FileUploadRestController {

	@GetMapping("/api/v1/upload")
	public FileUpload upload() {
		return new FileUpload();

	}

	@PostMapping("/api/v1/upload")
	public ResponseEntity<String> upload(
			@RequestParam("file") 
			MultipartFile multipartFile,
			@RequestParam("file1") 
			MultipartFile multipartFile1,
			@RequestParam("file2") 
			MultipartFile multipartFile2) {
		System.out.println(multipartFile.getOriginalFilename());
		System.out.println(multipartFile1.getOriginalFilename());
		
		return ResponseEntity.ok(
				multipartFile.getOriginalFilename()+" "+
				multipartFile1.getOriginalFilename()+" "+
				multipartFile2.getOriginalFilename());
	}
	
	
}
