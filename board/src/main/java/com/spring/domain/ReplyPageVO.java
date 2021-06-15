package com.spring.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyPageVO {
	private int replyCnt; // 댓슬 전체 개수
	private List<ReplyVO> list;
}
