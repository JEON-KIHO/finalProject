package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@Resource(name="uploadPath") // servlet-context에 저장된 path id 불러오기
	private String path;
	
	@RequestMapping("formUpload")
	public void UploadForm() {
	}
		
	
	@RequestMapping(value="formUpload", method=RequestMethod.POST)
	public void UploadFormPost(MultipartFile file) throws Exception{
		System.out.println("upload " + path);
		System.out.println(file.getOriginalFilename());
		
		// upload할 이지미에 랜덤이름값 추가 >> 중복될 가능성 제로에 수렴
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + file.getOriginalFilename();
		System.out.println(savedName);
		
		// 선택한 파일을 지정한 path에 저장
		File target = new File(path, savedName);
		FileCopyUtils.copy(file.getBytes(), target);
	}
	
	@RequestMapping("ajaxUpload")
	public void UploadAjax() {
	}
	
	@ResponseBody
	@RequestMapping(value="uploadFile", method=RequestMethod.POST)
	public String uploadAjax(MultipartFile file) throws Exception {
		
		// upload할 이지미에 랜덤이름값 추가 >> 중복될 가능성 제로에 수렴
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + file.getOriginalFilename();
		System.out.println(savedName);

		// 선택한 파일을 지정한 path에 저장
		File target = new File(path, savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		return savedName;
	}
	
	// delete file
	@ResponseBody
	@RequestMapping(value="deleteFile", method=RequestMethod.POST)
	public void deleteFile(String fileName) {
		new File(path + "/" + fileName).delete();
	}
	
	// view image
	@ResponseBody
	@RequestMapping("displayFile")
	public byte[] displayFile(String fileName) throws Exception{
		FileInputStream in = new FileInputStream(path + "/" + fileName);
		byte[] image = IOUtils.toByteArray(in);
		in.close();
		return image;
	}
}
