package com.mavericks.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/home")
	public String getHomePage() {
		return "Hello World, from Team Mavericks. This is version6";
	}
	
	@GetMapping("/")
	public String welcome() {
		return "Service is Up!!!";
	}
}
