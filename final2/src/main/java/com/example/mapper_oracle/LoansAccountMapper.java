package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

import com.example.domain.LoansVO;
import com.example.domain.LoansaccountVO;

public interface LoansAccountMapper {

	public void loansaccountinsert(LoansaccountVO lvo);
	public List<HashMap<String, Object>> loansaccountlist();
	public void loansinsert(LoansVO vo);
	public List<LoansaccountVO> loansread(String companyCode);
}
