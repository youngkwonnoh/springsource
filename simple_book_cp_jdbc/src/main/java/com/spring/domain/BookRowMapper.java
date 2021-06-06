package com.spring.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<BookVO> {
	
	@Override
	public BookVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookVO vo = new BookVO();
		vo.setCode(rs.getInt("code"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setPrice(rs.getInt("price"));
		return vo;
	}

}
