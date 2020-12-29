package com.example.mapper;

import java.util.List;

import com.example.domain.AddressVO;
import com.example.domain.Criteria;

public interface AddressMapper {
	public List<AddressVO> list(Criteria cri);
	
	public AddressVO read();
	
	public void insert();
	
	public void update();
	
	public void delete();
	
	public int totalCount(Criteria cri);
}
