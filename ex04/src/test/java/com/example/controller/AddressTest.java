package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import com.example.domain.Criteria;
import com.example.mapper.AddressMapper;

@RunWith(SpringJUnit4ClassRunner.class) //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class AddressTest {
	@Autowired
	private AddressMapper mapper;
	
	@Test
	public void list() {
		Criteria cri = new Criteria();
		cri.setPerPageNum(10);
		cri.setPage(1);
		cri.setSearchType("tel");
		cri.setKeyword("7777");
		mapper.list(cri);
		
		mapper.totalCount(cri);
		
	}
}
