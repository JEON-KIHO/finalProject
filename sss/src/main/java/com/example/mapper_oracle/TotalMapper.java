package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.DayVO;

public interface TotalMapper {
	  public List<DayVO> totalYearList();
	   public List<DayVO> totalMonthList(String year);
	   public List<HashMap<String, Object>> salesMonthlyAmount(String year);
	   public List<HashMap<String, Object>> refundMonthlyAmount(String year);
	   public List<HashMap<String, Object>> costMonthlyAmount(String year);
	   public List<HashMap<String, Object>> salesYearlyAmount();
	   public List<HashMap<String, Object>> refundYearlyAmount();
	   public List<HashMap<String, Object>> costYearlyAmount();
	   public List<HashMap<String, Object>> salesYearlyPayTypeList(String year);
	   public List<HashMap<String, Object>> refundYearlyPayTypeList(String year);
	   public List<HashMap<String, Object>> salesMonthlyPayTypeList(@Param("year") String year, @Param("month") String month);
	   public List<HashMap<String, Object>> refundMonthlyPayTypeList(@Param("year") String year, @Param("month") String month);
	   public List<HashMap<String, Object>> salesYearlyCategoryList(String year);
	   public List<HashMap<String, Object>> refundYearlyCategoryList(String year);
	   public List<HashMap<String, Object>> salesMonthlyCategoryList(String date);
	   public List<HashMap<String, Object>> refundMonthlyCategoryList(String date);
	   public List<HashMap<String, Object>> depositMonthlyBalance(@Param("year") String date, @Param("companyCode") String companyCode);
	   public List<HashMap<String, Object>> loansMonthlyBalance(@Param("year") String date, @Param("companyCode") String companyCode);
	
	public List<HashMap<String, Object>> total();
}
