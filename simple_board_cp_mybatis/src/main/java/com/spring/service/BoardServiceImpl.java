package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.mapper.BoardMapper;


// @Component("service")
@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public boolean insert(BoardVO vo) {
		return mapper.insert(vo) > 0 ? true:false;
	}

	@Override
	public boolean update(BoardVO vo) {
		return mapper.update(vo) > 0 ? true:false;
	}

	@Override
	public boolean delete(int bno) {
		return mapper.delete(bno) > 0 ? true:false;
	}

	@Override
	public BoardVO getRow(int bno) {
		return mapper.read(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.list();
	}

}
