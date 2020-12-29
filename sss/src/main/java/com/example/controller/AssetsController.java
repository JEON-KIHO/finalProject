package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.DayVO;
import com.example.domain.LoansVO;
import com.example.mapper_oracle.DepositMapper;
import com.example.mapper_oracle.LoansMapper;
import com.example.mapper_oracle.TotalMapper;

@Controller
public class AssetsController {
   @Autowired
   DepositMapper Dmapper;
   
   @Autowired
   LoansMapper Lmapper;
   
   @Autowired
   TotalMapper Tmapper;
   
   //����
   @ResponseBody
      @RequestMapping(value="login", method=RequestMethod.POST)
      public void loginPost(Model model, LoansVO vo, HttpSession session,HttpServletResponse response){
         session.setAttribute("number", vo.getLoans_companyCode());//��������
      }
   
   //deposit����
   @RequestMapping("/assets")
   public String list(Model model, HttpSession session){
      String companyCode = "347-88-00867";
      model.addAttribute("Dlist", Dmapper.Dlist(companyCode));
      model.addAttribute("Llist", Lmapper.Llist(companyCode));
      return "assets";
   }
   
   @RequestMapping("/read")
   public String read(String depositaccountcode, Model model){
      model.addAttribute("vo", Dmapper.read(depositaccountcode));
      return "read";
   }
   
   @RequestMapping("depositpercent.json")
   @ResponseBody
   public List<ArrayList<Object>> depositpercen(HttpSession session){
      String companyCode = "347-88-00867";
      List<HashMap<String, Object>> array = Dmapper.depositpercent(companyCode);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("���¹�ȣ:�����" );
      arr.add("�ܾ�");
      listArr.add(arr);
      
      for(HashMap<String, Object> map:array) {
         arr = new ArrayList<>();
         arr.add(map.get("DEPOSITACCOUNTCODE") + ":" + map.get("DEPOSITACCOUNTBANKNAME"));
         arr.add(map.get("DEPOSITPERCENT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("depositpercent")
   public void depositpercent(){
      
   }
   
   
   //loans����
   @RequestMapping("loanspercent.json")
   @ResponseBody
   public List<ArrayList<Object>> loanspercen(HttpSession session){
      String companyCode = "347-88-00867";
      List<HashMap<String, Object>> array = Lmapper.loanspercent(companyCode);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("���¹�ȣ:�����");
      arr.add("�ܾ�");
      listArr.add(arr);
      
      for(HashMap<String, Object> map:array) {
         arr = new ArrayList<>();
         arr.add(map.get("LOANSACCOUNTCODE") + ":" + map.get("LOANSACCOUNTBANKNAME"));
         arr.add(map.get("LOANSPERCENT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("loanspercent")
   public void loanspercent(){
      
   }
   
//total
   @RequestMapping("total.json")
   @ResponseBody
   public List<ArrayList<Object>> total(HttpSession session, String date){
      String companyCode = "347-88-00867";
//      String date = "19/12";
      String strDate = date.substring(2);
        String year = strDate.split("/")[0];
        String month = strDate.split("/")[1];
        date = year +"/"+ month;
        
      List<HashMap<String, Object>> Darray = Dmapper.depositTotal(companyCode, date);
      List<HashMap<String, Object>> Larray = Lmapper.loansTotal(companyCode, date);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      
      arr.add("�̸�");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      for(HashMap<String, Object> map:Darray){
         arr = new ArrayList<>();
         arr.add("���� �Ѿ�");
         arr.add(map.get("ENDBALANCE"));
         listArr.add(arr);
      }
      
      for(HashMap<String, Object> map:Larray){
         arr = new ArrayList<>();
         arr.add("���� �Ѿ�");
         arr.add(map.get("ENDBALANCE"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   
   //day
   
//   @RequestMapping("dailyYear.json")
//      @ResponseBody
//      public List<DayVO> dailyYearJson() {
//         List<DayVO> array = Dmapper.dailyYearList();
//         return array;
//      }
//      
//      @RequestMapping("dailyMonth.json")
//      @ResponseBody
//      public List<DayVO> dailyMonthJson(String date) {
//         String year = date.substring(2);
//         List<DayVO> array = Dmapper.dailyMonthList(year);
//         return array;
//      }
}