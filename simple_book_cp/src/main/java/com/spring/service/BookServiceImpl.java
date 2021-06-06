package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.persistence.BookDAO;

@Service("service") // 이름을 안주면 bookServiceImpl로 자동으로 생성됨
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO dao;
		
	@Override
	public boolean insert(BookVO vo) {
		return dao.insert(vo) > 0 ? true:false;
	}

	@Override
	public boolean update(BookVO vo) {
		return dao.update(vo) > 0 ? true:false;
	}

	@Override
	public boolean delete(int code) {
		return dao.delete(code) > 0 ? true:false;
	}

	@Override
	public BookVO getRow(int code) {
		return dao.getRow(code);
	}

	@Override
	public List<BookVO> getList() {
		return dao.getList();
	}

}
