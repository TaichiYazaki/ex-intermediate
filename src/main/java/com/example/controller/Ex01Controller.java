package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Ex01Domain;
import com.example.service.Ex01Service;


@Controller
@RequestMapping("/ex01")
public class Ex01Controller {

	@Autowired
	private Ex01Service ex01Service;
	
	@RequestMapping("/show1")
	public String show1(Model model) {
		List<Ex01Domain> ex01List = ex01Service.show1();
		model.addAttribute("ex01List", ex01List);
		return "/ex01show";
	}
	@RequestMapping("/show2")
	public String showDetail(Integer id, Model model) {
		Ex01Domain ex01Domain = ex01Service.showDetail(id);
		model.addAttribute("ex01Domain", ex01Domain);
		return "ex01result";
	}
}