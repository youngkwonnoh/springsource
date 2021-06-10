/**
 *  read.jsp에서 사용할 스크립트 
 */
$(function() {
	// operform 가져온 후 전송하기
	var operForm = $("#operForm");
	
	// Modify 버튼 클릭 시 get방식 /board/modify
	$(".btn-default").click(function() {
		operForm.attr('action', '/board/modify');
		operForm.submit();
	})
	
	// List 버튼 클릭 시 get방식 /board/list
	$(".btn-info").click(function() {
		operForm.find("input[name='bno']").remove();
		operForm.attr('action', '/board/list');
		operForm.submit();
	})
})