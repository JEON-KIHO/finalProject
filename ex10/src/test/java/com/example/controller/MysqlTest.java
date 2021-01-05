package com.example.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.Criteria;
import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;

@RunWith(SpringJUnit4ClassRunner.class) //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class MysqlTest {
	@Autowired
	private ProductMapper mapper;
	
	@Test
	public void list() {
		Criteria cri = new Criteria();
		cri.setSearchType("price1");
		cri.setKeyword("900000000");
		mapper.list(cri);
		
	}
	
	@Test
	public void totalCount() {
		Criteria cri = new Criteria();
		mapper.totalCount(cri);
	}
}
