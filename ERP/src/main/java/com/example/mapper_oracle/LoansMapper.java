
package com.example.mapper_oracle;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.LoansVO;

public interface LoansMapper {

   public List<LoansVO> Llist(String companyCode);
   
   public List<HashMap<String, Object>> loanspercent(String companyCode);
   
   public List<HashMap<String, Object>> loansTotal(@Param("companyCode")String companyCode, @Param("date")String date);
   
   public List<HashMap<String, Object>> loansAccountList();
	public Date loansMaxDayList(String code);
	public int loansBalanceList(@Param("code") String code, @Param("date") Date date);
}