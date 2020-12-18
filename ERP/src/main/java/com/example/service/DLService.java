package com.example.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper_oracle.DepositMapper;
import com.example.mapper_oracle.LoansMapper;

@Service
public class DLService {

	@Autowired
	LoansMapper lMapper;
	
	@Autowired
	DepositMapper dMapper;
	
	@Transactional
	public int sumLoansBalance() {
		int balance = 0;
		List<HashMap<String, Object>> array =  lMapper.loansAccountList();
		
		for(HashMap<String, Object> map:array) {
			String code = (String) map.get("LOANSACCOUNTCODE");
			Date date = lMapper.loansMaxDayList(code);
			int addBalance = lMapper.loansBalanceList(code, date);
			balance = balance + addBalance;
		}
		return balance;
	}
	
	@Transactional
	public int sumDepositBalance() {
		int balance = 0;
		List<HashMap<String, Object>> array =  dMapper.depositAccountList();
		
		for(HashMap<String, Object> map:array) {
			String code = (String) map.get("DEPOSITACCOUNTCODE");
			Date date = dMapper.depositMaxDayList(code);
			int addBalance = dMapper.depositBalanceList(code, date);
			balance = balance + addBalance;
		}
		return balance;
	}
}
