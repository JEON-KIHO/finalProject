package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.UserVO;

public interface UserMapper {
	public List<UserVO> list();
	
	public UserVO read(String user_id);
	
	public void updatePoint(@Param("user_id") String user_id, @Param("amount") int amount);
}
