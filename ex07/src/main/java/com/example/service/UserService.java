package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.MessageVO;
import com.example.mapper.MessageMapper;
import com.example.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper uMapper;
	
	@Autowired
	MessageMapper mMapper;
	
	@Transactional
	public void insert(MessageVO vo) {
		mMapper.insert(vo);
		uMapper.updatePoint(vo.getSender(), 10);
	}
	
	@Transactional
	public MessageVO readMessage(int mno) {
		MessageVO vo = mMapper.read(mno);
		if(vo.getReadDate()==null) {
			uMapper.updatePoint(vo.getReceiver(), 5);
			mMapper.updateReadDate(mno);
		}
		return mMapper.read(mno);
	}
}
