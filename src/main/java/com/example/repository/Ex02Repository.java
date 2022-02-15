package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


import com.example.domain.Ex02Domain;

@Repository
public class Ex02Repository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Ex02Domain> EX02DOMAIN_ROW_MAPPER = new BeanPropertyRowMapper<>(Ex02Domain.class);
	
	public List<Ex02Domain> findAll(){
		String sql="SELECT * FROM hotels";
		List<Ex02Domain> ex02List = template.query(sql, EX02DOMAIN_ROW_MAPPER);
		return ex02List;
	}
	
	public List<Ex02Domain> findByPrice(Integer price){
		String sql ="SELECT * FROM hotels WHERE price <= :price";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List <Ex02Domain> ex02FindByList = template.query(sql, param, EX02DOMAIN_ROW_MAPPER);
		return ex02FindByList;
	}
}
