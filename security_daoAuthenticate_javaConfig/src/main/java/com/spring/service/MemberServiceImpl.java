package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.MemberMapper;
import com.spring.security.SpUser;
import com.spring.security.SpUserAuthority;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public boolean register(SpUser user) {
		
		// 회원정보 등록 전 비밀번호 암호화
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// 회원정보 등록
		boolean result = mapper.register(user)==1;
		
		// 회원권한 등록 = ADMIN의 경우 ROLE_ADMIN, ROLE_USER 둘 다 권한 부여
		SpUserAuthority auth = new SpUserAuthority();
		auth.setUserid(user.getUserid());
		auth.setAuthority("ROLE_ADMIN");
		mapper.registerAuth(auth);
		
		auth = new SpUserAuthority();
		auth.setUserid(user.getUserid());
		auth.setAuthority("ROLE_USER");
		mapper.registerAuth(auth);
		return result;
	}

}
