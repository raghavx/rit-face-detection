package com.ritroorkee.facedetection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritroorkee.facedetection.model.User;

@RestController
public class HomeRestController {

	@GetMapping("/api/v1/user")
	public User getUser() {
		return new User();
	}
}
