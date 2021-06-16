<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="" role="form">
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name="bno"
							readonly="readonly" value=${vo.bno}>
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							readonly="readonly" value=${vo.title}>
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea class="form-control" rows="3" name="content"
							readonly="readonly">${vo.content}</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							readonly="readonly" value=${vo.writer}>
					</div>
					<button type="button" class="btn btn-default">Modify</button>
					<button type="reset" class="btn btn-info">List</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%-- 댓글 리스트 보여주는 부분 --%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>
				Reply
				<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
			</div>
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno='1'>
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2021-06-15 14:25</small>
								<p>Good Job!!</p>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="panel-footer"></div><!-- 댓글 페이지 나누기 -->
		</div>
	</div>
</div>

<%-- 댓글 작성 폼 --%>
<div class="modal" tabindex="-1" id="replyModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h5 class="modal-title">Reply</h5>
      </div>
      <div class="modal-body">
		<div class="form-group">
			<label for="">댓글 내용</label>
			<input type="text" name="reply" class="form-control" value="댓글내용"/>
		</div>
		<div class="form-group">
			<label for="">작성자</label>
			<input type="text" name="replyer" class="form-control" value="작성자"/>
		</div>
		<div class="form-group">
			<label for="">작성일</label>
			<input type="text" name="replyDate" class="form-control" value="작성일"/>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" id="modalRegisterBtn">등록</button>
        <button type="button" class="btn btn-warning" id="modalModifyBtn">수정</button>
        <button type="button" class="btn btn-danger" id="modalRemoveBtn">삭제</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" id="modalCloseBtn">종료</button>
      </div>
    </div>
  </div>
</div>
<%-- 페이지 나누기를 위해 필요한 값 --%>
<form action="" id="operForm">
	<input type="hidden" name="type" value="${cri.type}"/>
	<input type="hidden" name="keyword" value="${cri.keyword}"/>
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="bno" value="${vo.bno}"/>
</form>
<script>
	let bno = ${vo.bno};
</script>
<script src="/resources/js/read.js"></script>
<script src="/resources/js/reply.js"></script>
<%@include file="../includes/footer.jsp"%>
