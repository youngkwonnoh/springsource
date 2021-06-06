package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

@Service("service") // 이름을 안주면 bookServiceImpl로 자동으로 생성됨
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper mapper;
		
	@Override
	public boolean insert(BookVO vo) {
		return mapper.insert(vo) > 0 ? true:false;
	}

	@Override
	public boolean update(BookVO vo) {
		return mapper.update(vo) > 0 ? true:false;
	}

	@Override
	public boolean delete(int code) {
		return mapper.delete(code) > 0 ? true:false;
	}

	@Override
	public BookVO getRow(int code) {
		return mapper.read(code);
	}

	@Override
	public List<BookVO> getList() {
		return mapper.list();
	}

}
