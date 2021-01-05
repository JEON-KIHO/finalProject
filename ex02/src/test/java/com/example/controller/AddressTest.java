package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AddressVO;
import com.example.mapper.AddressMapper;

@RunWith(SpringJUnit4ClassRunner.class) //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class AddressTest {
	@Autowired
	private AddressMapper mapper;
	
	@Test
	public void list() {
		mapper.list();
	}
//	@Test
//	public void read() {
//		mapper.read(1);
//	}
//	@Test
//	public void insert() {
//		AddressVO vo = new AddressVO();
//		vo.setName("전희진");
//		vo.setTel("010-6666-7777");
//		vo.setAddress("서울특별시 관악구 신림동");
//		mapper.insert(vo);
//	}
//	@Test
//	public void update() {
//		AddressVO vo = new AddressVO();
//		vo.setAno(1);
//		vo.setName("김현진");
//		vo.setTel("010-7777-8888");
//		vo.setAddress("서울특별시 구로구 구로동");
//		mapper.update(vo);
//	}
//	@Test
//	public void delete() {
//		mapper.delete(2);
//	}
}
