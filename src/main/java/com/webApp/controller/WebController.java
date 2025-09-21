package com.webApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohd Raghib Khan
 */
@RestController
public class WebController {
	
@GetMapping
	public List<String> getData() {
		
		List<String> list=new ArrayList<>();
		list.add("hello this is from jenkins");
		list.add("this is our first jenkins project ");
		return list;
	}
}
