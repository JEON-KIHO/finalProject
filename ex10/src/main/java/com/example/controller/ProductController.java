package com.example.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;

@Controller
public class ProductController {
	@Resource(name = "uploadPath")
	String path;

	@Autowired
	ProductMapper mapper;
	
	@Autowired
	ProductService service;

	@RequestMapping("insert")
	public void insert() {
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertPost(ProductVO vo, MultipartHttpServletRequest multi) throws Exception {
		
		// 대표 이미지 업로드
		MultipartFile file = multi.getFile("file");
		if (!file.isEmpty()) {
			// upload할 이지미에 랜덤이름값 추가 >> 중복될 가능성 제로에 수렴
			UUID uid = UUID.randomUUID();
			String savedName = uid.toString() + "_" + file.getOriginalFilename();

			// 선택한 파일을 지정한 path에 저장
			File target = new File(path, savedName);
			FileCopyUtils.copy(file.getBytes(), target);
			vo.setImage(savedName);
		}
		
		// 추가 이미지 업로드
		List<MultipartFile> files = multi.getFiles("files");
		if(files.size() > 0) {
			File mkPath = new File(path + "/attach");
			if(!mkPath.exists()) mkPath.mkdir();
		}
		
		ArrayList<String> images = new ArrayList<String>();
		for (MultipartFile image : files) {
			if (!image.isEmpty()) {
				// upload할 이지미에 랜덤이름값 추가 >> 중복될 가능성 제로에 수렴
				UUID uid = UUID.randomUUID();
				String savedName = uid.toString() + "_" + image.getOriginalFilename();

				// 선택한 파일을 지정한 path에 저장
				File target = new File(path + "/attach", savedName);
				FileCopyUtils.copy(image.getBytes(), target);

				images.add(savedName);
			}
		}
		vo.setImages(images);
		service.insert(vo);
			
		return "redirect:list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePost(ProductVO vo, MultipartHttpServletRequest multi) throws Exception {
		// 대표이미지
		MultipartFile file = multi.getFile("file");
		if (!file.isEmpty()) {
			// 기존 이미지 지우기
			if (!vo.getImage().equals("")) { // 기존 이미지가 존재할 때 삭제
				new File(path + "/" + vo.getImage()).delete();
			}

			// upload할 이지미에 랜덤이름값 추가 >> 중복될 가능성 제로에 수렴
			UUID uid = UUID.randomUUID();
			String savedName = uid.toString() + "_" + file.getOriginalFilename();

			// 선택한 파일을 지정한 path에 저장
			File target = new File(path, savedName);
			FileCopyUtils.copy(file.getBytes(), target);
			vo.setImage(savedName);
		}

		// 첨부 이지미 수정
		List<MultipartFile> files = multi.getFiles("files");
			
		// 새로운 첨부이미지들을 업로드
		ArrayList<String> images = new ArrayList<>();
		for (MultipartFile image : files) {
			if (!image.isEmpty()) {
				// upload할 이지미에 랜덤이름값 추가 >> 중복될 가능성 제로에 수렴
				UUID uid = UUID.randomUUID();
				String savedName = uid.toString() + "_" + image.getOriginalFilename();

				// 선택한 파일을 지정한 path에 저장
				File target = new File(path + "/attach", savedName);
				FileCopyUtils.copy(image.getBytes(), target);

				images.add(savedName);
			}
		}
		if (images.size() > 0) {
			List<String> oldImages = mapper.getImage(vo.getPcode());
			if (oldImages.size() > 0) {
				for (String oldImage : oldImages) {
					new File(path + "/attach/" + oldImage).delete();
				}
			}
		}
		vo.setImages(images);
		
		service.update(vo);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(ProductVO vo) {
		if(!vo.getImage().equals("")) {
			new File(path + "/" + vo.getImage()).delete();
		}
		List<String> oldImages = mapper.getImage(vo.getPcode());
		for(String oldImage:oldImages) {
			new File(path + "/attach/" + oldImage).delete();
		}
		
		service.delete(vo.getPcode());
		return "redirect:list";
	}
	
	// ouput image
	@RequestMapping("display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName) throws Exception{
	 ResponseEntity<byte[]> result=null;
	 
	 //display fileName이 있는 경우
	 if(!fileName.equals("")) {
	 File file=new File(path + File.separator + fileName);
	 HttpHeaders header=new HttpHeaders();
	 header.add("Content-Type", Files.probeContentType(file.toPath()));
	 result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
	 }
	 return result;
	}
	
	@RequestMapping("list")
	public String list(Criteria cri, Model model,HttpServletRequest request, HttpSession session) {
		
		// 쿠키에 로그인 정보가 있으면 로그인 유지
		Cookie cookie = WebUtils.getCookie(request, "user_id");
		if(cookie != null) {
			request.getSession().setAttribute("user_id", cookie.getValue());
		}
		
		String dest = (String)session.getAttribute("dest");
		System.out.println("dest......................" + dest);
		if(dest != null) {
			session.removeAttribute("dest");
			return "redirect:" + dest;
		}
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(cri));
		model.addAttribute("pm", pm);
		model.addAttribute("list", mapper.list(cri));
		
		return "list";
	}
	
	@RequestMapping("read")
	public void read(int pcode, Model model) {
		model.addAttribute("vo", mapper.read(pcode));
		model.addAttribute("images", mapper.getImage(pcode));
	}

}
