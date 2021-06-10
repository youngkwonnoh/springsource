package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	public boolean insert(BoardVO vo);
	public boolean delete(int bno);
	public boolean update(BoardVO vo);
	public List<BoardVO> list();
	public BoardVO read(int bno);
}
