package com.ritroorkee.facedetection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ritroorkee.facedetection.model.User;

@RestController
public class HomeRestController {

	@GetMapping("/api/v1/user")
	public User getUser() {
		return new User();
	}
	
	@PostMapping("/api/v1/user")
	public User getUser( @RequestBody User user) {
		System.out.println(user.getUserName());
		return user;
	}
}
