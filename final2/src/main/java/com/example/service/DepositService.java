package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.example.domain.CategoryVO;
import com.example.domain.DepositAccountVO;
import com.example.domain.DepositVO;
import com.example.domain.LoansaccountVO;
import com.example.domain.LoansVO;
import com.example.mapper_oracle.CategoryMapper;
import com.example.mapper_oracle.DepositAccountMapper;
import com.example.mapper_oracle.LoansAccountMapper;

@Service
public class DepositService {
	@Autowired
	DepositAccountMapper mapper;
	@Autowired
	LoansAccountMapper lmapper;
	@Autowired
	CategoryMapper cmapper;
	
	
	//���� ��� �� ���� ������ �����ܾ� ����
	@Transactional
	public void depositinsert(DepositVO vo) {
		mapper.depositinsert(vo);
		mapper.depositaccountupdate(vo.getDepositBalance(),vo.getDeposit_depositAccountCode());
	}
	
	//���� ���� ��� �� ���� tab�� insert
	@Transactional
	public void depositaccountinsert(DepositAccountVO vo) {
		mapper.depositaccountinsert(vo);
		DepositVO dvo=new DepositVO();
		dvo.setDeposit_companyCode("153-60-00064");
		dvo.setDeposit_day(vo.getDepositAccount_startday());
		dvo.setDeposit_depositAccountCode(vo.getDepositAccountCode());
		dvo.setDepositAccountAmount(0);
		dvo.setDepositBalance(vo.getDepositAccountAmount());
		dvo.setDepositType("�Ա�");
		mapper.depositinsert(dvo);
	}
	
	
	//���� ���� ��� �� ���� tab�� insert
	@Transactional
	public void loansaccountinsert(LoansaccountVO vo) {
		lmapper.loansaccountinsert(vo);
		LoansVO lvo=new LoansVO();
		lvo.setLoans_companyCode("153-60-00064");
		lvo.setLoans_loansAccountCode(vo.getLoansAccountCode());
		lvo.setLoans_repaymentDay(vo.getLoansAccount_startDay());
		lvo.setLoansAmount(0);
		lvo.setLoansBalance(vo.getLoansAccountAmount());
		lmapper.loansinsert(lvo);
	}
	
	//��з� �� �ߺз� ī�װ� ���� or �߰��� update/insert
//	@Transactional
//	public void categoryupdate(CategoryVO vo){
//		String companyCode="153-60-00064";
//		String companyName="��彺Ź";
//		List<HashMap<String, Object>> oldarray=cmapper.categorylist(companyCode);//���� �ִ� ������
//	
//		//��з� ����
//		cmapper.categoryupdate(vo);
//		
//		//��з� �߰�
//		cmapper.categoryinsert(vo);
//		List<HashMap<String, Object>> newarray=cmapper.categorylist(companyCode);
//		
//		
//		
//		//�ߺз� �߰�
//		String mcode="001";
//		vo.setCategorycode(vo.getCategorycode().substring(0,17)+mcode);
//		vo.setCategoryname(vo.getCategoryname().split("/")[0]+"/"+vo.getCategoryname().split("/")[1]+"/"+"");
//		cmapper.categoryinsert(vo);
//		
//		
//		}
}
