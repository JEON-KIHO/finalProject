package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.UserVO;
import com.example.mapper.MessageMapper;
import com.example.mapper.UserMapper;

@Controller
public class UserController {
	@Autowired
	UserMapper mapper;
	
	@Autowired
	MessageMapper mMapper;
	
	@RequestMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",mapper.list());
	}
	
	@RequestMapping("/send") // 보낸 메세지
	public void send(Model model, String user_id) {
		model.addAttribute("vo", mapper.read(user_id));
		model.addAttribute("list", mapper.list());
	}
	
	@RequestMapping("/receive") // 받은 메세지
	public void receive(Model model, String user_id) {
		model.addAttribute("vo", mapper.read(user_id));
	}
	
	@ResponseBody
	@RequestMapping("/read")
	public UserVO read(String user_id) {
		
		return mapper.read(user_id);
	}
	
	
	
}
