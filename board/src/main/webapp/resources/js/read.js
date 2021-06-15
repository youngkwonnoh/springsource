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
	
	// 댓글 작업
	

	// 모달 영역 가져오기
	let modal = $(".modal");
	
	$("#addReplyBtn").click(function(){
		modal.modal("show");
	})

	// 댓글 삽입 - bno, reply(댓글 내용), replyer(작성자)
	$("#modalRegisterBtn").click(function() {
		replyService.add({bno:bno, reply:'댓글 테스트 중', replyer:'테스트'}, function(result) {
			
			if(result) {
				alert(result);
			}
		}); // add 종료
	 }) // #modalRegisterBtn 종료
	
	// 댓글 목록 가져오기
	replyService.getList({bno:bno, page:1}, function(data) {
		console.log(data);
	})
	
	// 댓글 삭제
	$("modalRemoveBtn").click(function() {
		
		replyService.remove(3, function(result){
			alert(result);
		});
	
	}) // #modalRemoveBtn 종료
	
	// 댓글 수정
	$("modalModifyBtn").click(function() {
		
		replyService.update({rno:1, relpy:'댓글 수정이다'}, function(result){
			if(result) {
				alert(result);
			}
		});
	}) // #modalModifyBtn 종료
	
	replyService.get(5, function(data){
		console.log(data);
	})
	
})





