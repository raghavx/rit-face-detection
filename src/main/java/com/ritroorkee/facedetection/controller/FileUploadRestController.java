package com.ritroorkee.facedetection.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ritroorkee.facedetection.model.FileUpload;

@RestController
public class FileUploadRestController {

	@GetMapping("/api/v1/upload")
	public FileUpload upload() {
		return new FileUpload();

	}

	@PostMapping("/api/v1/upload")
	public FileUpload upload(@RequestBody FileUpload fileUpload) {
		System.out.println(fileUpload.getFile().getName());

		return fileUpload;
	}
}
