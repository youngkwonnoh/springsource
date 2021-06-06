package com.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.mapper.MemberMapper;

@Service("service")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public boolean insert(MemberVO vo) {
		return mapper.insert(vo)>0? true:false;
	}

	@Override
	public boolean update(String userid, String password, String changPass) {
		return mapper.update(userid, password, changPass)>0? true:false;
	}

	@Override
	public boolean delete(String userid, String password) {
		return mapper.delete(userid, password)>0? true:false;
	}
	
	@Override
	public MemberVO login(String userid, String password) {
		return mapper.login(userid, password);
	}
	
	@Override
	public List<MemberVO> getList() {
		return mapper.list();
	}

	@Override
	public boolean update2(MemberVO vo) {
		return mapper.update2(vo)>0? true:false;
	}

	@Override
	public boolean delete2(MemberVO vo) {
		return mapper.delete2(vo)>0? true:false;
	}
}
