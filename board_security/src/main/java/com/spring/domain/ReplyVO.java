package com.spring.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
	private int rno;
	private int bno;
	private String reply; 
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}