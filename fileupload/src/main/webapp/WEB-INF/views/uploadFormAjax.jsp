<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload Ajax</h1>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" id="" multiple="multiple"/>
	</div>
	<button id="uploadBtn">submit</button>
	<div class="uploadResult">
		<ul></ul>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(function() {
			$("#uploadBtn").click(function(){
				var files = $("input[name='uploadFile']")[0].files;
				console.log(files);
				
				// 첨부파일을 formData로 만들어 전송
				var formData = new FormData();
				for(var i=0; i<files.length; i++){
					formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
					url:'/uploadAjax',
					type:'post',
					processData:false,
					contentType:false,
					data:formData,
					success:function(xhr, status, error){
						console.log("에러");
					}
				})
			})
		})
	</script>
</body>
</html>