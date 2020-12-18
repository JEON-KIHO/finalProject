package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.DayVO;

public interface SalesMapper {

   public List<HashMap<String, Object>> salesCategoryCount();
   
   public List<HashMap<String, Object>> cashPayType(String date);
   public List<HashMap<String, Object>> cardPayType(String date);
   public List<HashMap<String, Object>> etcPayType(String date);
   
   public List<HashMap<String, Object>> refundCategoryCount();
   
   public List<HashMap<String, Object>> refundCashPayType(String date);
   public List<HashMap<String, Object>> refundCardPayType(String date);
   public List<HashMap<String, Object>> refundEtcPayType(String date);
   
   public List<HashMap<String, Object>> lCategoryPayType(@Param("lC")String LCATEGORY,@Param("pay")String PAYTYPE);
   public List<HashMap<String, Object>> subTotal(@Param("date")String date, @Param("LCATEGORY")String LCATEGORY);
   public List<HashMap<String, Object>> refundSubTotal(@Param("date")String date, @Param("LCATEGORY")String LCATEGORY);
   public List<HashMap<String, Object>> mCategoryPay(String MCATEGORY);
   
   public List<HashMap<String, Object>> salesCategoryPayType(@Param("date")String date, @Param("payType") String payType, @Param("lCategory") String lCategory);
   public List<HashMap<String, Object>> salesMCategoryPayType(@Param("date")String date, @Param("mCategory") String mCategory);
      
   public List<HashMap<String, Object>> refundCategoryPayType(@Param("date")String date, @Param("payType") String payType, @Param("lCategory") String lCategory);
   public List<HashMap<String, Object>> refundMCategoryPayType(@Param("date")String date, @Param("MCATEGORY") String MCATEGORY);
   
   
   
   
   
   public List<HashMap<String, Object>> salesPayTypeList(@Param("date") String date, @Param("companyCode") String companycode, @Param("payType") String payType, @Param("lCategory") String lCategory);
   public List<HashMap<String, Object>> refundPayTypeList(@Param("date") String date, @Param("companyCode") String companycode, @Param("payType") String payType, @Param("lCategory") String lCategory);
   public List<HashMap<String, Object>> salesMCategoryList(@Param("date") String date, @Param("companyCode") String companycode, @Param("mCategory") String mCategory, @Param("lCategory") String lCategory);
   public List<HashMap<String, Object>> refundMCategoryList(@Param("date") String date, @Param("companyCode") String companycode, @Param("mCategory") String mCategory, @Param("lCategory") String lCategory);
   public List<HashMap<String, Object>> salesSubTotalList(@Param("date") String date, @Param("companyCode") String companycode, @Param("lCategory") String lCategory);
   public List<HashMap<String, Object>> refundSubTotalList(@Param("date") String date, @Param("companyCode") String companycode, @Param("lCategory") String lCategory);
   public List<HashMap<String, Object>> salesTotalList(@Param("date") String date, @Param("companyCode") String companycode, @Param("payType") String payType);
   public List<HashMap<String, Object>> refundTotalList(@Param("date") String date, @Param("companyCode") String companycode, @Param("payType") String payType);
   public int salesAmount(@Param("date") String date, @Param("companyCode") String companyCode);
   public int refundAmount(@Param("date") String date, @Param("companyCode") String companyCode);
   public List<HashMap<String, Object>> SRdailyYearList(String companyCode);
   public List<HashMap<String, Object>> SRdailyMonthList(@Param("year") String year, @Param("companyCode") String companyCode);
   public List<Integer> SRYearList(String companyCode);
   public List<Integer> SRMonthList(@Param("year") String year, @Param("companyCode") String companyCode);
}
