<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/attach.css">
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
	<div class="bigPictureWrapper">
		<div class="bigPicture"></div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(function() {
			$("#uploadBtn").click(function(){
				// 첨부파일 가져오기
				var files = $("input[name='uploadFile']")[0].files;
				console.log(files);
				
				// 첨부파일을 formData로 만들어 전송
				var formData = new FormData();
				for(var i=0; i<files.length; i++){
					formData.append("uploadFile", files[i]);
				}
				
				// enctype="multipart/form-data" => processData:false, contentType:false
				
				$.ajax({
					url:'/uploadAjax', // 도착지
					type:'post',
					processData:false,
					contentType:false,
					data:formData,
					success:function(result){
						console.log(result);
						showUploadedFile(result);
					},
					error:function(xhr,status,error){
						console.log("에러");
					}
				})
			}) // uploadBtn 종료
			
			function showUploadedFile(uploadResultArr) {
				var str = "";
				var uploadResult = $(".uploadResult ul");
				
				$(uploadResultArr).each(function(i, obj){ // 첫번째 배열을 가져와 obj에 담기
					if(obj.fileType) { // image
						// 썸네일 이미지 경로 링크
						// 2021\\06\\17\\s_cb6e8d2e-0d0d-4565-8fe0-9c3ef15b5221_enemy.png
						var fileCallPath = encodeURIComponent(obj.uploadPath + "\\s_" + obj.uuid + "_" + obj.fileName);
						
						// 원본 이미지 경로
						var originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
						originPath = originPath.replace(new RegExp(/\\/g), "/");
						
						
						str += "<li><a href=\"javascript:showImage(\'"+ originPath + "\')\">";
						str += "<img src='/display?fileName=" + fileCallPath + "'>" + obj.fileName + "</a>";
						str += "<span data-file='" + fileCallPath + "' data-type='image'> X </span>";
						str += "</li>";
					} else {
						var fileCallPath = encodeURIComponent(obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName);
						str += "<li><a href='/download?fileName=" + fileCallPath + "'>";
						str += "<img src='/resources/img/attach.png'>" + obj.fileName + "</a>";
						str += "<span data-file='" + fileCallPath + "' data-type='image'> X </span>";
						str += "</li>";
					}
						
				})
				uploadResult.append(str);
			}
			// 확대된 사진 영역 없애기
			$(".bigPictureWrapper").click(function(){
				$(".bigPicture").animate({width:'0%', height:'0%'}, 1000);
				
				// 확대된 영역 없애기
				setTimeout(function() {
					$(".bigPictureWrapper").hide();
				}, 1000);
			})
			
			// X버튼 이벤트(직접 이벤트 지정할 수 없고 이벤트를 위임)
			$(".uploadResult").on("click", "span", function(){
				// 삭제하고자 하는 파일 경로 및 이름, 파일 타입(이미지인 경우 썸네일 삭제, 원본 삭제)
				var targetFile = $(this).data("file"); // 경로
				var type = $(this).data("type"); // image or file
				
				var targetLi = $(this).closest("li");
				
				// 삭제 정보 넙겨주기 / li 태그 없애기
				$.ajax({
					url:'/deleteFile',
					type:'post',
					data:{
						fileName:targetFile,
						type:type
					},
					success:function(result){
						console.log(result);
						targetLi.remove();
					}
				})
			})
			
		})
		function showImage(fileCallPath){
			$(".bigPictureWrapper").css("display", "flex").show();
			
			$(".bigPicture").html("<img src='/display?fileName=" + fileCallPath + "'>").animate({width:'100%', height:'100%'}, 1000);
		}
		
	</script>
</body>
</html>