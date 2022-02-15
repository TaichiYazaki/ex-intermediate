package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Ex03Domain;

@Repository
public class Ex03Repository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Ex03Domain> EX03_ROW_MAPPER = new BeanPropertyRowMapper<>(Ex03Domain.class);

	public List<Ex03Domain> findByItem(Integer gender, String color) {
		String sql = "SELECT * FROM clothes WHERE gender=:gender AND color=:color";
		SqlParameterSource param= new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);
		List<Ex03Domain> ex03List = template.query(sql, param, EX03_ROW_MAPPER);
		System.out.println(ex03List);
		return ex03List;
	}
}
