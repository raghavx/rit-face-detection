package com.ritroorkee.facedetection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ritroorkee.facedetection.model.FileUpload;

@Controller
public class FileUploadController {

	@GetMapping("/upload")
	public String upload(Model model) {
		model.addAttribute("fileUpload", new FileUpload());
		return "fileupload";
	}

	@PostMapping("/upload")
	public String upload(Model model, @ModelAttribute("fileUpload") FileUpload fileUpload) {
		System.out.println(fileUpload.getFile().getOriginalFilename());
		model.addAttribute("fileUpload", new FileUpload());
		return "fileupload";
	}
}
