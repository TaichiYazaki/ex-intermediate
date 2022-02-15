package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Ex02Domain;
import com.example.service.Ex02Service;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {

	@Autowired
	private Ex02Service ex02Service;

	@RequestMapping("")
	public String index() {
		return "/ex02show";
	}

	@RequestMapping("/show")
	public String show(Integer price, Model model) {
		List<Ex02Domain> ex02List=null;
		if (price == null) {
			 ex02List = ex02Service.show();
			
		}else{
			 ex02List = ex02Service.find(price);
		}
		model.addAttribute("ex02List", ex02List);
		return "ex02show";

	}
}
