package com.example.mapper;

import java.util.List;

import com.example.domain.AddressVO;

public interface AddressMapper {
	public List<AddressVO> list();
	
	public AddressVO read(int ano);
	
	public void insert(AddressVO vo);
	
	public void update(AddressVO vo);
	
	public void delete(int ano);
}
