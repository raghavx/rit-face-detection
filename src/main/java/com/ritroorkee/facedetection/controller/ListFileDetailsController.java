package com.ritroorkee.facedetection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ritroorkee.facedetection.model.FileDetails;
import com.ritroorkee.facedetection.repository.FileDetailsRepository;

@Controller
public class ListFileDetailsController {

	@Autowired
	private FileDetailsRepository fileDetailsRepository;

	@GetMapping("/list/files")
	public String listFiles(Model model) {
		List<FileDetails> allFiles = fileDetailsRepository.findAll();
		model.addAttribute("allFiles", allFiles);
		
		for (FileDetails fd : allFiles) {
			System.out.println(fd.getName() + " " + fd.getPath());
		}
		return "listfiles";
	}
}
