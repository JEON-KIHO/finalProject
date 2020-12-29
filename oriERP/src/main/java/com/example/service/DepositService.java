package com.example.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.example.domain.CategoryVO;
import com.example.domain.DepositAccountVO;
import com.example.domain.DepositVO;
import com.example.domain.LoansAccountVO;
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
   
   
   // 삁湲   벑濡   썑  삁湲  怨꾩젙 쓽 湲곗큹 옍 븸 蹂 寃 
   @Transactional
   public void depositinsert(DepositVO vo) {
      mapper.depositinsert(vo);
      mapper.depositaccountupdate(vo.getDepositBalance(),vo.getDeposit_depositAccountCode());
   }
   
   // 삁湲  怨꾩젙  벑濡   썑  삁湲  tab 뿉 insert
//   @Transactional
//   public void depositaccountinsert(DepositAccountVO vo, HttpSession session) {
//      System.out.println(vo.toString());
//      mapper.depositaccountinsert(vo);
//      DepositVO dvo=new DepositVO();
//      String companyCode=(String)session.getAttribute("companyCode");
//      dvo.setDeposit_companyCode(companyCode);
//      dvo.setDeposit_day(vo.getDepositAccount_startday());
//      dvo.setDeposit_depositAccountCode(vo.getDepositAccountCode());
//      dvo.setDepositAccountAmount(0);
//      dvo.setDepositBalance(vo.getDepositAccountAmount());
//      dvo.setDepositType("입금");
//      mapper.depositinsert(dvo);
//      System.out.println(dvo.toString());
//   }
//   
//   
//   //  異  怨꾩젙  벑濡   썑   異  tab 뿉 insert
//   @Transactional
//   public void loansaccountinsert(LoansAccountVO vo) {
//      lmapper.loansaccountinsert(vo);
//      LoansVO lvo=new LoansVO();
//      lvo.setLoans_companyCode("153-60-00064");
//      lvo.setLoans_loansAccountCode(vo.getLoansAccountCode());
//      lvo.setLoans_repaymentDay(vo.getLoansAccount_startDay());
//      lvo.setLoansAmount(0);
//      lvo.setLoansBalance(vo.getLoansAccountAmount());
//      lmapper.loansinsert(lvo);
//   }
   
   //  遺꾨쪟 諛  以묐텇瑜  移댄뀒怨좊━ 蹂 寃  or 異붽  떆 update/insert
//   @Transactional
//   public void categoryupdate(CategoryVO vo){
//      String companyCode="153-60-00064";
//      String companyName="怨⑤뱶 뒪 긽";
//      List<HashMap<String, Object>> oldarray=cmapper.categorylist(companyCode);// 썝 옒  엳 뜕  뜲 씠 꽣
//   
//      //  遺꾨쪟  닔 젙
//      cmapper.categoryupdate(vo);
//      
//      //  遺꾨쪟 異붽 
//      cmapper.categoryinsert(vo);
//      List<HashMap<String, Object>> newarray=cmapper.categorylist(companyCode);
//      
//      
//      
//      //以묐텇瑜  異붽 
//      String mcode="001";
//      vo.setCategorycode(vo.getCategorycode().substring(0,17)+mcode);
//      vo.setCategoryname(vo.getCategoryname().split("/")[0]+"/"+vo.getCategoryname().split("/")[1]+"/"+"");
//      cmapper.categoryinsert(vo);
//      
//      
//      }
}