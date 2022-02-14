package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Ex01Domain;
import com.example.repository.Ex01Reository;

@Service
@Transactional
public class Ex01Service {

	@Autowired
	private Ex01Reository ex01Repository;
	
	public List<Ex01Domain> show1(){
		return ex01Repository.findAll();
	}
}
