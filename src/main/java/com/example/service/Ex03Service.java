package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Ex03Domain;
import com.example.repository.Ex03Repository;

@Service
@Transactional
public class Ex03Service {

	@Autowired
	private Ex03Repository ex03Repository;

	public List<Ex03Domain> find(Integer gender, String color) {
		return ex03Repository.findByItem(gender, color);
	}
}
