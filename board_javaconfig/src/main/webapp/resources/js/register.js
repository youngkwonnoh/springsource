/**
 *  파일 업로드
 */
$(function(){
	
	// 업로드 되는 파일의 종류와 크기 제한
	function checkExtension(fileName, fileSize){
		var regex = new RegExp("(.*?)\.(txt|jpg|gif|png|bmp)");
		var maxSize = 10242880; // 5MB
		
		if(fileSize > maxSize) {
			alert("파일 사이즈 초과");
			return false;
		}
		if(!regex.test(fileName)) {
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	$("input[type='file']").change(function() {
		// 첨부파일 가져오기
		var files = $("input[name='uploadFile']")[0].files;
		console.log(files);

		// 첨부파일을 formData로 만들어 전송
		var formData = new FormData();
		for (var i = 0; i < files.length; i++) {
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			formData.append("uploadFile", files[i]);
		}

		// enctype="multipart/form-data" => processData:false, contentType:false

		$.ajax({
			url: '/uploadAjax', // 도착지
			type: 'post',
			processData: false,
			contentType: false,
			data: formData,
			success: function(result) {
				console.log(result);
				showUploadedFile(result);
				$("input[name='uploadFile']").val("");
			},
			error: function(xhr, status, error) {
				console.log("에러");
			}
		})
	}) // input[type=file] 종료

	function showUploadedFile(uploadResultArr) {
		var str = "";
		var uploadResult = $(".uploadResult ul");

		$(uploadResultArr).each(function(i, obj) { // 첫번째 배열을 가져와 obj에 담기
			if (obj.fileType) { // image
				// 썸네일 이미지 경로 링크
				// 2021\\06\\17\\s_cb6e8d2e-0d0d-4565-8fe0-9c3ef15b5221_enemy.png
				var fileCallPath = encodeURIComponent(obj.uploadPath + "\\s_" + obj.uuid + "_" + obj.fileName);

				// 원본 이미지 경로
				var originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g), "/");


				str += "<li data-path='" + obj.uploadPath + "' data-uuid = '" + obj.uuid + "'";
				str += " data-filename='" + obj.fileName + "' data-type='" + obj.fileType + "'>";
				str += "<a href=\"javascript:showImage(\'" + originPath + "\')\">";
				str += "<span>" + obj.fileName + "</span>";
				str += "<button type='button' class='btn btn-warning btn-circle btn-sm' data-file='" + fileCallPath + "' data-type='image'>";
				str += "<i class='fa fa-times'></i></button><br>";
				str += "<img src='/display?fileName=" + fileCallPath + "'></a>";
				str += "</li>";
			} else {
				var fileCallPath = encodeURIComponent(obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName);
				str += "<li data-path='" + obj.uploadPath + "' data-uuid = '" + obj.uuid + "'";
				str += " data-filename='" + obj.fileName + "' data-type='" + obj.fileType + "'>";
				str += "<span>" + obj.fileName + "</span>";
				str += "<button type='button' class='btn btn-warning btn-circle btn-sm' data-file='" + fileCallPath + "' data-type='file'>";
				str += "<i class='fa fa-times'></i></button><br>";
				str += "<a herf='/download?'fileNam=" + fileCallPath + "'>";
				str += "<img src='/resources/img/attach.png'></a>";
				str += "</li>";
			}

		})
		uploadResult.append(str);
	} // showUploadedFile 종료
	
	// submit 버튼 중지
	$("button[type='submit']").click(function(e){
		e.preventDefault();
		
		var str = "";
		$(".uploadResult ul li").each(function(idx, obj){
			var job = $(obj);
			// 수집된 정보를 hidden 태그로 작성
			str += "<input type='hidden', name='attachList["+idx+"].uuid' value='"+job.data("uuid")+"'>";
			str += "<input type='hidden', name='attachList["+idx+"].uploadPath' value='"+job.data("path")+"'>";
			str += "<input type='hidden', name='attachList["+idx+"].fileName' value='"+job.data("filename")+"'>";
			str += "<input type='hidden', name='attachList["+idx+"].fileType' value='"+job.data("type")+"'>";
		})
		console.log(str);
		
		// 게시글 등록 폼 가져오기
		var form = $("form");
		// 수집된 내용 폼에 추가하기
		form.append(str);
		// 폼 전송하기
		form.submit();
	})
	
	// x 버튼 클릭 시 동작
	$(".uploadResult").on("click","button", function(){
		// 목록에 있는 첨부파일 삭제, 서버 폴더 첨부파일 삭제
		var targetFile = $(this).data("file");
		var type = $(this).data("type");
		
		// li 태그 가져오기
		var targetLi = $(this).closest("li");
		
		$.ajax({
			url:'/deleteFile',
			data:{
				fileName:targetFile,
				type:type
			},
			type:'post',
			success:function(result){
				console.log(result);
				targetLi.remove();
			}
		})
	})
})