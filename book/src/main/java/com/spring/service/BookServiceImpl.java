package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

public class BookServiceImpl implements BookService {

	@Autowired
	public BookMapper mapper;
	
	@Override
	public boolean insert(BookVO vo) {
		return mapper.insert(vo)>0 ? true:false;
	}

	
}
