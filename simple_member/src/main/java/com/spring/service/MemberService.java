package com.spring.service;

import java.util.List;

import com.spring.domain.MemberVO;

public interface MemberService {
	public boolean insert(MemberVO vo);
	public boolean update(String userid, String password, String changPass);
	public boolean delete(String userid, String password);
	public MemberVO login(String userid, String password);
	public List<MemberVO> getList();
	
}
