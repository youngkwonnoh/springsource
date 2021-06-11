package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	private int pageNum; // 사용자가 클릭하는 페이지 번호
	private int amount; // 하나의 페이지에 보여줄 게시물 갯수
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int paheNum, int amount) {
		super();
		this.pageNum = paheNum;
		this.amount = amount;
	}
}
