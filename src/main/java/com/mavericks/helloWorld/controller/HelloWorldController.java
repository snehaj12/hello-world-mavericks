package com.mavericks.helloWorld.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/home")
	public String getHomePage(@RequestParam(name="name", required=false, defaultValue="Mavericks") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome.html";
	}
}
