package com.spring.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.domain.BookRowMapper;
import com.spring.domain.BookVO;

import java.util.List;

@Repository
public class BookDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(BookVO vo) {
		String sql = "insert into BookTBL(code, title, writer, price) values(?, ?, ?, ?)";
		return jdbcTemplate.update(sql, vo.getCode(), vo.getTitle(), vo.getWriter(), vo.getPrice());
	}

	public int update(BookVO vo) {
		String sql = "update BookTBL set price = ? where code = ?";
		return jdbcTemplate.update(sql, vo.getPrice(), vo.getCode());
	}
	
	public int delete(int code) {
		String sql = "delete from bookTBL where code=?";
		return jdbcTemplate.update(sql, code);
	}
	public BookVO getRow(int code) {
		String sql = "select * from bookTBL where code=?";
		return jdbcTemplate.queryForObject(sql, new BookRowMapper(), code);
	}
	public List<BookVO> getList() {
		String sql = "select * from bookTBL";
		return jdbcTemplate.query(sql,  new BookRowMapper());
	}
}
