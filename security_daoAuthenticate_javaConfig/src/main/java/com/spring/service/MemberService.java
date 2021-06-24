package com.spring.service;

import com.spring.security.SpUser;
import com.spring.security.SpUserAuthority;

public interface MemberService {
	public boolean register(SpUser user);
	//public boolean registerAuth(SpUserAuthority auth);
}
