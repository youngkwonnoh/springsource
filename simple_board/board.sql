-- board 생성
create table spring_board(
	bno number(10,0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);

alter table spring_board add constraint pk_spring_board primary key(bno);

-- 시퀀스 생성
create sequence seq_board;

select * from SPRING_BOARD;

-- 댓글 수 저장 컬럼 추가
alter table spring_board add(replycnt number default 0);

-- 이미 들어간 댓글 수 삽입
update SPRING_BOARD 
set replycnt = (select count(bno) 
				from SPRING_REPLY 
				where SPRING_BOARD.bno = SPRING_REPLY.bno);