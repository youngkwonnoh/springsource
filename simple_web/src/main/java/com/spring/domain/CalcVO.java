package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CalcVO {
	private int num1;
	private int num2;
	private String op;
}
