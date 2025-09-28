package com.webApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohd Raghib Khan
 */
@RestController
@RequestMapping("/api")
public class WebController { 

	@GetMapping("/hello")
	public List<String> getData() {

		List<String> list = new ArrayList<>();
		list.add("hello this is from jenkins");
		list.add("this is our first jenkins project ");
		list.add("Application is successfully deployed");
		return list;
	}
}
