package com.example.mapper_oracle;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.DayVO;
import com.example.domain.DepositVO;

public interface DepositMapper {
   public List<DepositVO> Dlist(String compnayCode);
   
   public DepositVO read(String Depositaccountcode);

   public List<HashMap<String, Object>> depositpercent(String companyCode);
   
   public List<HashMap<String, Object>> depositTotal(@Param("companyCode")String companyCode, @Param("date")String date);
   
   public List<DayVO> dailyYearList();
      
   public List<DayVO> dailyMonthList(String date);
   
   public List<HashMap<String, Object>> depositAccountList();
	public Date depositMaxDayList(String code);
	public int depositBalanceList(@Param("code") String code, @Param("date") Date date);
}