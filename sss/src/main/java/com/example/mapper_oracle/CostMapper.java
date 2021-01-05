package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.CostVO;
import com.example.domain.DayVO;

public interface CostMapper {
   public void insert(@Param("date") String date, @Param("wom") int wom);
   
   public List<HashMap<String, Object>> dataList(String date);
   
   public List<DayVO> dailyYearList();
   
   public List<DayVO> dailyMonthList(String date);
   
   public List<DayVO> dailyList(String date);
   
   public List<CostVO> costList(String date);
   
   public List<CostVO> costGraphList(String date);
   
   public List<HashMap<String, Object>> salesCategoryCount();
}