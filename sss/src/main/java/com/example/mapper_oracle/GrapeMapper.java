package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.CostVO;
import com.example.domain.DayVO;

public interface GrapeMapper {
	public List<DayVO> dailyYearList();

	public List<DayVO> dailyList(String date);

	public List<DayVO> dailyMonthList(String date);

//	public List<HashMap<String, Object>> totalSalesView();
 
	public List<CostVO> costList(String date);
	
	public HashMap<String, Object> salesTotalView(String date);
	
	public HashMap<String, Object> refundTotalView(String date);
	
	public HashMap<String, Object> costTotalView(String date);
	public List<HashMap<String, Object>> salesAmount(String date);
	public List<HashMap<String, Object>> refundAmount(String date);
	
	public List<HashMap<String, Object>> salesCategoryAmountList(@Param("date") String date, @Param("companyCode") String companyCode);
	public List<HashMap<String, Object>> refundCategoryAmountList(@Param("date") String date, @Param("companyCode") String companyCode);
	public HashMap<String, Object> salesTotalAmount(@Param("date") String date, @Param("companyCode") String companyCode);
	public HashMap<String, Object> refundTotalAmount(@Param("date") String date, @Param("companyCode") String companyCode);
	public HashMap<String, Object> costTotalAmount(@Param("date") String date, @Param("companyCode") String companyCode);
	  public List<HashMap<String, Object>> dataList(String date);
	  public List<HashMap<String, Object>> dataLists(String date);
	public List<HashMap<String, Object>> categoryList();
}
