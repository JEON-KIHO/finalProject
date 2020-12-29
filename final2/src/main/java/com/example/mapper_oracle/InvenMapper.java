package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

import com.example.domain.DayVO;

public interface InvenMapper {
   public List<HashMap<String, Object>> invenList(String date);
   
   public List<DayVO> invenDailyYearList();
   
   public List<DayVO> invenDailyMonthList(String date);
   
   public List<DayVO> invenDailyList(String date);
   
   public List<HashMap<String, Object>> endInvenList(String companyCode);
}