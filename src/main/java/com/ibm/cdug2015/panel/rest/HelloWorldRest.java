package com.ibm.cdug2015.panel.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldRest {
	String message = "Welcome to Spring MVC!";

	@RequestMapping("/hello")
	@ResponseBody
	public String randomPerson() {
		return message;
	}

}
