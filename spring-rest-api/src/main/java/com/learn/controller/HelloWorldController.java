package com.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//this annotation is a combination of @controller and @response body
// @controller is a spring mvc based controller 
//@Responsebody is used to convert form Java objects into JSON data
@RestController
public class HelloWorldController {
	
	//HTTP GET Request
	//We use @GetMapping annotation to map HTTP GET request onto specific handler method
	//http://localhost:8080/hello-world hit it onto the browser or postman client
	//in the braces of getmapping is a URI
	@GetMapping("/hello-world")
	public String helloWorld(){
		return "Hello world";
	}

}
