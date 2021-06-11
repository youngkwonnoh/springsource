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
<%-- 페이지 나누기를 위해 필요한 값 --%>
<form action="" id="operForm">
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="bno" value="${vo.bno}"/>
</form>
<script>

</script>
<script src="/resources/js/read.js"></script>
<%@include file="../includes/footer.jsp"%>
