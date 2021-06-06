package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
	private String changPass;
}
