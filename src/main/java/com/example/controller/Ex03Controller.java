package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Ex03Domain;
import com.example.service.Ex03Service;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	@Autowired
	private Ex03Service ex03Service;
	
	@RequestMapping("")
	public String index() {
		return "/ex03show";
	}
	
	@RequestMapping("/show")
	public String show(String gender, String color, Model model) {
		List<Ex03Domain> ex03List= ex03Service.find(Integer.parseInt(gender), color);
		model.addAttribute("ex03List", ex03List);
		return "/ex03show";
	}

}
