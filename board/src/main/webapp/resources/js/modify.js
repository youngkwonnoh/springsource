/**
 *  modify.jsp 스크립트
 */
$(function() {
	// remove와 list를 위한 폼 가져오기	
	var operForm = $("#operForm");
	
	$("button").click(function(e) {
		// button submit 기능 제거
		e.preventDefault();
		
		var oper = $(this).data("oper");
		
		if(oper == "modify") {
			operForm=$("form[role='form']");
		} else if(oper == "remove") {
			operForm.attr('action', '/board/remove');
		} else if(oper == "list") {
			operForm.find("input[name='bno']").remove();
			operForm.attr('method', 'get');
			operForm.attr('action', '/board/list');
		}
		operForm.submit();
	})
})