package com.ritroorkee.facedetection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListFileDetailsController {

	// TODO 
	
	@GetMapping("/list/files")
	public String listFiles(Model model) {
		return "listfiles";
	}
}
