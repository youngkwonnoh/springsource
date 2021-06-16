package com.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UploadAjaxController {
	
	// uploadFormAjax
	@GetMapping("/uploadFormAjax")
	public void uploadFormAjaxGet() {
		log.info("uploadFormAjax 요청");
	}
	
	@PostMapping("/uploadAjax")
	public void uploadFormPost(MultipartFile[] uploadFile) {
		log.info("파일 업로드 요청");
		
		for(MultipartFile f:uploadFile) {
			log.info("upload File Name : " + f.getOriginalFilename());
			log.info("upload File size : " + f.getSize());
			
			// 서버 폴더에 전송된 파일 저장하기
			try {
				f.transferTo(new File("D:\\upload", f.getOriginalFilename()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
