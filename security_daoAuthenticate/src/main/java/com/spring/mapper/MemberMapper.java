package com.spring.mapper;

import com.spring.security.SpUser;
import com.spring.security.SpUserAuthority;

public interface MemberMapper {
	public int register(SpUser user);
	public int registerAuth(SpUserAuthority auth);
	public SpUser select(String userid);
}
