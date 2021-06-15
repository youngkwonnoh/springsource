/**
 * 댓글 스크립트 - 자바스크립트 모듈(관련있는 함수들의 모임) 구성
 */
	
var replyService=(function(){
	// private
	function add(reply,callback) {
		console.log("add method 호출");
		
		$.ajax({
			type:'post',
			url:'/replies/new',
			contentType:'application/json',
			data:JSON.stringify(reply),
			success:function(result){
				if(callback) {
					callback(result);
				}
			}
		})
	} // add 종료
	
	function getList(param,callback) {
		
		var bno = param.bno;
		var page = param.page||1;
		
		$.getJSON({
			url:'/replies/pages/'+bno+'/'+page,
			success:function(data){
				if(callback){
					callback(data);
				}
			}
		})
	} // getList 종료
	
	function remove(rno,callback){
		$.ajax({
			url:'/replies/'+rno, // replies/3
			type:'delete',
			success:function(result){
				if(callback){
					callback(result);
				}
			}
		})
	} // remove 종료
	
	function update(reply,callback){
		$.ajax({
			url:'/replies/'+reply.rno,
			type:'put',
			data:JSON.stringify(relpy),
			contentType:'application/json',
			success:function(result){
				if(callback) {
					callback(result);
				}
			}
		})
	} // update 종료
	
	function get(rno,callback){
		$.getJSON({
			url:'/replies/'+rno,
			success:function(data){
				if(callback){
					callback(data);
				}
			}
		})
	}
	
	// public
	return {
		add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get
	}
})();