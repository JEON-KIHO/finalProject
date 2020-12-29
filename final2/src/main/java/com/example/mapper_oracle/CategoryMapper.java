package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.CategoryVO;
import com.example.domain.DayVO;


public interface CategoryMapper {

	public void categoryinsert(CategoryVO vo);
	public List<HashMap<String, Object>> categorylist(String companyCode); //���ʼ�����_�ߺз� �Է�
	public List<HashMap<String, Object>> lcategorylist(String companyCode); //�Է½�_�ߺз� �Է�
	public void categoryupdate(CategoryVO vo);
	public List<DayVO> dailyList(String date);
	   public CategoryVO categoryread(@Param("categorycode") String categorycode, @Param("categoryname") String categoryname);
}
