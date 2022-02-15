package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Ex02Domain;
import com.example.repository.Ex02Repository;

@Service
@Transactional
public class Ex02Service {

	@Autowired
	private Ex02Repository ex02Repository;
	
	public List<Ex02Domain> show(){
		return ex02Repository.findAll();
	}
	
	public List<Ex02Domain> find(Integer price){
		return ex02Repository.findByPrice(price);
	}
}
