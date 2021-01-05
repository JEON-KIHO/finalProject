package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.MessageVO;
import com.example.mapper.MessageMapper;
import com.example.service.UserService;

@RestController
public class MessageController {
	@Autowired
	MessageMapper mapper;
	
	@Autowired
	UserService service;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(MessageVO vo) {
		service.insert(vo);
	}

	@RequestMapping("/sendList")
	public List<MessageVO> sendList(String sender) {
		return mapper.sendList(sender);
	}
	
	@RequestMapping("/receiveList")
	public List<MessageVO> receiveList(String receiver) {
		return mapper.receiveList(receiver);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(int mno) {
		mapper.delete(mno);
	}
	
	@RequestMapping("/readMessage")
	public MessageVO readMessage(int mno) {
		return service.readMessage(mno);
	}
}
