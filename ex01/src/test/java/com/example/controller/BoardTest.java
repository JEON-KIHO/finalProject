package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 먼저 SpringJUnit4ClassRunner.class
										// import한다.
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })

public class BoardTest {
	@Autowired
	private BoardMapper mapper;

//	@Test
//	public void list() {
//		mapper.list();
//	}
//	
//	@Test
//	public void insert() {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("insert title");
//		vo.setContent("insert content");
//		vo.setWriter("insert writer");
//		mapper.insert(vo);
//	}
//	
//	@Test
//	public void read() {
//		mapper.read(1);
//	}
//	
//	@Test
//	public void update() {
//		BoardVO vo = new BoardVO();
//		vo.setBno(1);
//		vo.setTitle("update title");
//		vo.setContent("update content");
//		vo.setWriter("update wirter");
//		mapper.update(vo);
//		mapper.read(1);
//	}
	
	@Test
	public void delete() {
		mapper.delete(8);
		mapper.list();
	}
}
