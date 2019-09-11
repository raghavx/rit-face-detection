package com.ritroorkee.facedetection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ritroorkee.facedetection.model.Enquiry;
import com.ritroorkee.facedetection.repository.EnquiryRepository;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryRepository enquiryRepository;
	
	@GetMapping("/enquiry")
	public String enquiry(Model model) {
		model.addAttribute("enquiry", new Enquiry());
		return "enquiry";
	}

	@PostMapping("/enquiry")
	public String enquiry(Model model, @ModelAttribute("enquiry") Enquiry enquiry) {
		enquiry = enquiryRepository.save(enquiry);
		model.addAttribute("enquiry", enquiry);
		return "enquiry";
	}
}
