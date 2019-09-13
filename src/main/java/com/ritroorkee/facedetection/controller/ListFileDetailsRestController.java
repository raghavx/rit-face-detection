package com.ritroorkee.facedetection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritroorkee.facedetection.model.FileDetails;
import com.ritroorkee.facedetection.repository.FileDetailsRepository;

@RestController
public class ListFileDetailsRestController {

	@Autowired
	private FileDetailsRepository fileDetailsRepository;
	
	@GetMapping("/api/v1/list/files")
	public List<FileDetails> lists(){
		return fileDetailsRepository.findAll();
	}
}
