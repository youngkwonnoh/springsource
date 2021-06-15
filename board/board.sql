-- rownum : 가상 컬럼
select rownum, bno, title from spring_board;

select rownum, bno, title from spring_board where rownum<=10;

-- 더미 테이터 생성
insert into SPRING_BOARD(bno, title, content, writer)
(select seq_board.nextval, title, content, writer from spring_board);

select count(*) from spring_board;

-- 최신글 10개 추출
select rownum, bno, title, writer
from(select bno, title, writer from spring_board where bno>0 order by bno desc)
where rownum<=10;

-- 1 => 최신글 10 개
select *
from (select rownum rn, bno, title, writer
	  from(select bno, title, writer from spring_board where bno>0 order by bno desc)
	  where rownum<=10)
where rn>0;

-- 2 => 그 다음 최신글
select *
from (select rownum rn, bno, title, writer
	  from(select bno, title, writer from spring_board where bno>0 order by bno desc)
	  where rownum<=20)
where rn>10;

-- 오라클 힌트 이용하기
select *
from (select /*+INDEX_DESC(spring_board pk_spring_board) */
	  rownum rn, bno, title, writer
	  from SPRING_BOARD
	  where rownum<=10)
where rn>0;


-- 페이지 나누기 + 검색
-- T를 선택, 검색어 자바
select *
from (select /*+INDEX_DESC(spring_board pk_spring_board) */
	  rownum rn, bno, title, writer
	  from SPRING_BOARD
	  where rownum <= (1 * 20) and (title like '%자바%'))
where rn > ((1-1) * 20);

-- TC 선택, 검색어 자바
select *
from (select /*+INDEX_DESC(spring_board pk_spring_board) */
	  rownum rn, bno, title, writer
	  from SPRING_BOARD
	  where rownum <= (1 * 20) and (title like '%자바%' or content like '%자바%'))
where rn > ((1-1) * 20);

-- TCW 선택, 검색어 자바
select *
from (select /*+INDEX_DESC(spring_board pk_spring_board) */
	  rownum rn, bno, title, writer
	  from SPRING_BOARD
	  where rownum <= (1 * 20) and (title like '%자바%' or content like '%자바%' or writer like '%자바%'))
where rn > ((1-1) * 20);

-- 댓글 테이블 작성
create table spring_reply(
	rno number(10,0) constraint pk_reply primary key, -- 댓글 글번호
	bno number(10,0) not null, -- 원본 글번호
	reply varchar2(1000) not null, -- 댓글 내용
	replyer varchar2(50) not null, -- 댓글 작성자
	replydate date default sysdate,
	updatedate date default sysdate,
	constraint fk_reply_board foreign key(bno) references spring_board(bno)
);

create sequence seq_reply;

select * from spring_reply;

update spring_reply set reply='댓글 수정', updatedate=sysdate where rno=1;

-- 댓글 index 생성
create index idx_reply on spring_reply(bno desc, rno asc);



select rno, bno, reply, replyer, replydate, updatedate
from ( /*+INDEX(spring_reply idx+reply)*/
	  select rownum rn, rno, bno, reply, replyer, replydate, updatedate 
	  from spring_reply
	  where bno=330 and rno > 0 and rownum <= 2 * 10
	  )
where rn > (2-1) * 10

select * from spring_reply where bno=330;
