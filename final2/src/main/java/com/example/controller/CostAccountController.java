package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.CategoryVO;
import com.example.domain.CostVO;
import com.example.domain.DepositAccountVO;
import com.example.domain.DepositVO;
import com.example.domain.LoansVO;
import com.example.domain.LoansaccountVO;
import com.example.domain.SalesVO;
import com.example.mapper_oracle.CategoryMapper;
import com.example.mapper_oracle.CostAccountMapper;
import com.example.mapper_oracle.DepositAccountMapper;
import com.example.mapper_oracle.LoansAccountMapper;
import com.example.mapper_oracle.SalesMapper;
import com.example.service.DepositService;

import oracle.sql.DATE;

@Controller
public class CostAccountController {
	
	@Autowired
	CategoryMapper mapper;
	@Autowired
	CostAccountMapper cmapper;
	@Autowired
	DepositAccountMapper dmapper;
	@Autowired
	LoansAccountMapper lmapper;
	@Autowired
	SalesMapper smapper;
	@Autowired
	DepositService service;
	
	
		//��з� ī�װ� ���ʼ��� insert
		@RequestMapping(value="categoryinsert", method=RequestMethod.POST)
		@ResponseBody
		public void categoryinsert(CategoryVO vo, HttpSession session) {
			String companyCode =(String)session.getAttribute("companyCode");
			String companyName =(String)session.getAttribute("companyName");
			String code=companyCode+"/"+vo.getCategorycode();
			String name=companyName+"/"+vo.getCategoryname();
			vo.setCategorycode(code);
			vo.setCategoryname(name);
			System.out.println(vo.getCategorycode());
			mapper.categoryinsert(vo);
		}
		
		//�ߺз� ī�װ� ���ʼ��� �� �α��� �� ������ ��з� list �ҷ�����
		@RequestMapping("categorylist.json")
		@ResponseBody
		public List<HashMap<String, Object>> categorylist(HttpSession session) {
			
			String companyCode =(String)session.getAttribute("companyCode");
			List<HashMap<String, Object>> array = mapper.categorylist(companyCode);
			return array;
		}
		
		//���� ���� ���ʼ��� �� ����tab�� �����ܾ� �߰� transactional
		@RequestMapping(value="depositaccountinsert", method=RequestMethod.POST)
		@ResponseBody
		public void depositaccountinsert(DepositAccountVO vo){
			service.depositaccountinsert(vo);
		}
		
		//���� ���� ���ʼ��� �� ����tab�� �����ܾ� �߰� transactional
		@RequestMapping(value="loansaccountinsert", method=RequestMethod.POST)
		@ResponseBody
		public void loansaccountinsert(LoansaccountVO lvo){
			service.loansaccountinsert(lvo);
		}
		
		
	//��� ���� insert�� ����Ʈ ���	
	@RequestMapping("costaccount.json")
	@ResponseBody
	public List<HashMap<String, Object>> costaccount(){
		List<HashMap<String, Object>> array=cmapper.costaccountlist();
		return array;
	}
	
	
	//��� �Է� �� insert
	@RequestMapping(value="costinsert", method=RequestMethod.POST)
	@ResponseBody
	public void costinsert(CostVO vo) {
		if(vo.getDay() != null) {
			cmapper.costinsert(vo);
		}
	}
	
	//���� ���� insert�� ����Ʈ ���
	@RequestMapping("depositaccountlist.json")
	@ResponseBody
	public List<HashMap<String, Object>> depositlist(HttpSession session){
		
		String companyCode=(String)session.getAttribute("companyCode");
		List<HashMap<String, Object>> array=dmapper.depositaccountlist(companyCode);
		return array;
	}
	
	//���� �Է� �� insert
		@RequestMapping(value="depositinsert", method=RequestMethod.POST)
		public void depositinsert(DepositVO vo){
			service.depositinsert(vo);
		}
	
	//���� ���� insert�� ����Ʈ ���
	@RequestMapping("loansaccountlist.json")
	@ResponseBody
	public List<HashMap<String, Object>> loanslist(){
		List<HashMap<String, Object>> array=lmapper.loansaccountlist();
		return array;
	}
	
	//���� �Է� �� insert
	@RequestMapping(value="loansinsert", method=RequestMethod.POST)
	public void loansinsert(LoansVO vo){
		lmapper.loansinsert(vo);
	}
	
	//���� ȯ�� �Է� �� �α��� �� ���� �� ��з� ī�װ� ����Ʈ ���
	@RequestMapping("lcategorylist.json")
	@ResponseBody
	public List<HashMap<String, Object>> lcategorylist(HttpSession session) {
	
		String companyCode=	(String)session.getAttribute("companyCode");
		List<HashMap<String, Object>> array = mapper.lcategorylist(companyCode);
		return array;
	}
	
	//���� ȯ�� �Է� �� �ߺз� ī�װ� ����Ʈ ���
	@RequestMapping(value="categorylist", method=RequestMethod.POST)
	@ResponseBody
	public void categorylist(CategoryVO vo) {
		mapper.categoryinsert(vo);
	}
	
	//���� ȯ�� insert
	@RequestMapping(value="salesinsert", method=RequestMethod.POST)
	@ResponseBody
	public void salesinsert(SalesVO vo,HttpSession session){
		String companyCode=(String)session.getAttribute("companyCode");
		String sales_day="12-12-23";
		String paytype="����";
		List<SalesVO> array=smapper.saleslist(companyCode);
		
		for(int i=0; array.size()>i; i++){
			ArrayList<String> date=new ArrayList<>();
			date.add(array.get(i).getSales_day().substring(2,11));
			System.out.println(array.get(i).getSales_day().substring(2,11));
			System.out.println(date.get(i).toString());
		}
			
			
//				if(vo.getSales_day().equals(map)|| vo.getSales_day()!=null) {
					smapper.salesdelete(companyCode, sales_day, paytype);
			
//		}
		smapper.salesinsert(vo);
	}
	
	
		//�α��� �� �������� ��з� read �� update�� insert transactional
	@RequestMapping(value="categoryupdate", method=RequestMethod.POST)
	   @ResponseBody
	   public List<HashMap<String,Object>> categoryupdate(String categorycode, String categoryname,HttpSession session) {
//	      (String)session.getAttribute("companyCode");
	      String companyCode=(String)session.getAttribute("companyCode");
	      String companyName=(String)session.getAttribute("companyName");
	      categorycode=companyCode+"/"+categorycode+"/000";
	      categoryname=companyName+"/"+categoryname+"/empty";
	      
	      CategoryVO vo=mapper.categoryread(categorycode, categoryname);
	      CategoryVO newvo=new CategoryVO();
	      newvo.setCategorycode(categorycode);
	      newvo.setCategoryname(categoryname);
	      if(vo!=null){
	         if(vo.getCategorycode().equals(categorycode)&&!vo.getCategoryname().equals(categoryname)){
	            mapper.categoryupdate(newvo);
	         }
	      }
	      if(vo==null){
	         mapper.categoryinsert(newvo);
	         categorycode=categorycode.split("/")[1];
	         categorycode=companyCode+"/"+categorycode+"/001";
	         newvo.setCategorycode(categorycode);
	         categoryname=categoryname.split("/")[1];
	         categoryname=companyName+"/"+categoryname+"/";
	         newvo.setCategoryname(categoryname);
	         mapper.categoryinsert(newvo);
	      }
	      
	      List<HashMap<String,Object>> newarray=mapper.lcategorylist(companyCode);//���� �� ������
	      
	      return newarray;
	   }
	      
	   //�α��� �� �ߺз� update �� insert
	         @RequestMapping(value="mcategoryupdate", method=RequestMethod.POST)
	         @ResponseBody
	         public List<HashMap<String,Object>> mcategoryupdate(String categorycode, String categoryname,HttpSession session) {
//	            (String)session.getAttribute("companyCode");
	            String companyCode=(String)session.getAttribute("companyCode");
	            String companyName=(String)session.getAttribute("companyName");
	            categoryname=companyName+"/"+categoryname;
	            
	            CategoryVO vo=mapper.categoryread(categorycode, categoryname);
	            CategoryVO newvo=new CategoryVO();
	            newvo.setCategorycode(categorycode);
	            newvo.setCategoryname(categoryname);
	            if(vo!=null){
	               if(vo.getCategorycode().equals(categorycode)&&!vo.getCategoryname().equals(categoryname)){
	                  mapper.categoryupdate(newvo);
	               }
	            }
	            if(vo==null){
	               mapper.categoryinsert(newvo);
	               newvo.setCategorycode(categorycode);
	            }
	            
	            List<HashMap<String,Object>> newarray=mapper.lcategorylist(companyCode);//���� �� ������
	            
	            return newarray;
	         }
		
		//�α��� �� �������� ���� ����Ʈ read
		@RequestMapping("depositread.json")
		@ResponseBody
		public List<DepositAccountVO> depositread(HttpSession session) {
//			(String)session.getAttribute("companyCode");
			String companyCode="347-88-00867";
			List<DepositAccountVO> array=dmapper.depositread(companyCode);
			for(DepositAccountVO vo : array){
				String date=vo.getDepositAccount_startday().substring(0, 11);
				vo.setDepositAccount_startday(date);
			}
			return array;
		}
		
		//�α��� �� �������� ���� ����Ʈ read
		@RequestMapping("loansread.json")
		@ResponseBody
		public List<LoansaccountVO> loansread(HttpSession session) {
//			(String)session.getAttribute("companyCode");
			String companyCode="153-60-00064";
			List<LoansaccountVO> larray=lmapper.loansread(companyCode);
			for(LoansaccountVO vo : larray){
				String start=vo.getLoansAccount_startDay().substring(0, 11);
				String end=vo.getLoansAccount_endDay().substring(0, 11);
				vo.setLoansAccount_endDay(end);
				vo.setLoansAccount_startDay(start);
			}
			return larray;
		}
	
	//�������ʵ��
	@RequestMapping("category")
	public void category() {
		
	}
//	//�α��� �� �Է�
//	@RequestMapping("insert")
//	public void insert(){
//		
//	}
	//�α��� �� ����
	@RequestMapping("categoryread")
	public void categoryread(){
		
	}
}
