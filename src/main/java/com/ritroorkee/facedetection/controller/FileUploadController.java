package com.ritroorkee.facedetection.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ritroorkee.facedetection.model.FileUpload;
import com.ritroorkee.facedetection.service.FaceDetectionServiceImpl;
import com.ritroorkee.facedetection.service.FileStorageService;

@Controller
public class FileUploadController {

	@Autowired
	private FileStorageService fileStorageService;
	
	@Autowired
	private FaceDetectionServiceImpl faceDetectionServiceImpl;
	
	@GetMapping("/upload")
	public String upload(Model model) {
		model.addAttribute("fileUpload", new FileUpload());
		return "fileupload";
	}

	@PostMapping("/upload")
	public String upload(Model model, @ModelAttribute("fileUpload") FileUpload fileUpload) {
		File file = fileStorageService.save(fileUpload.getFile());
		System.out.println(fileUpload.getFile().getOriginalFilename());
		System.out.println(file.getAbsolutePath());
		File x = new File(fileUpload.getFile().getOriginalFilename());
		x = faceDetectionServiceImpl.detectFace(file, x);
		System.out.println(x.getAbsolutePath());
		model.addAttribute("fileUpload", new FileUpload());
		return "fileupload";
	}
}
