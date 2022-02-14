package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Ex01Domain;


@Repository
public class Ex01Reository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Ex01Domain> EX01DOMAIN_ROW_MAPPER = new BeanPropertyRowMapper<>(Ex01Domain.class);
	
	public List<Ex01Domain> findAll() {
		String sql = "SELECT * FROM teams ORDER BY inauguration";
		List<Ex01Domain> ex01List = template.query(sql, EX01DOMAIN_ROW_MAPPER);
		return ex01List;
	}

}
