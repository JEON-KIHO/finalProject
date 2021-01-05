package com.example.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.DayVO;
import com.example.mapper_oracle.CostMapper;
import com.example.mapper_oracle.SalesMapper;
import com.example.mapper_oracle.TMLMapper;
import com.example.mapper_oracle.TotalMapper;


@Controller
public class TotalController {

   @Autowired
   TotalMapper mapper;
   @Autowired
   SalesMapper salesMapper;
   
   @Autowired
   CostMapper costMapper;
   
   @Autowired
   TMLMapper TMLMapper;
   @RequestMapping("totalYearList.json")
   @ResponseBody
   public List<DayVO> totalYearListJson() {
      return mapper.totalYearList();
   }
   
   @RequestMapping("totalMonthList.json")
   @ResponseBody
   public List<DayVO> totalMonthListJson(String year) {
      year = year.substring(2);
      return mapper.totalMonthList(year);
   }
   
   @RequestMapping("salesMonthlyAmount.json")
   @ResponseBody
   public List<HashMap<String, Object>> salesMonthlyAmountJson(String year) {
      year = year.substring(2);
      List<HashMap<String, Object>> sArray = mapper.salesMonthlyAmount(year);
      return sArray;
   }
   
   @RequestMapping("refundMonthlyAmount.json")
   @ResponseBody
   public List<HashMap<String, Object>> refundMonthlyAmountJson(String year) {
      year = year.substring(2);
      return mapper.refundMonthlyAmount(year);
   }
   
   @RequestMapping("costMonthlyAmount.json")
   @ResponseBody
   public List<HashMap<String, Object>> costMonthlyAmountJson(String year) {
      year = year.substring(2);
      return mapper.costMonthlyAmount(year);
   }
   
   @RequestMapping("totalMonthlyAmount.json")
   @ResponseBody
   public List<ArrayList<Object>> totalMonthlyAmountJson(String year) {
      year = year.substring(2);
      List<HashMap<String, Object>> sArray = mapper.salesMonthlyAmount(year);
      List<HashMap<String, Object>> rArray = mapper.refundMonthlyAmount(year);
      List<HashMap<String, Object>> cArray = mapper.costMonthlyAmount(year);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("��¥");
      arr.add("����");
      arr.add("ȯ��");
      arr.add("���");
      listArr.add(arr);
      
      for(int i = 0; i < sArray.size(); i++) {
         arr = new ArrayList<>();
         arr.add(sArray.get(i).get("MONTH") + "��");
         arr.add(sArray.get(i).get("SALESAMOUNT"));
         arr.add(rArray.get(i).get("REFUNDAMOUNT"));
         arr.add(cArray.get(i).get("COSTAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("salesYearlyAmount.json")
   @ResponseBody
   public List<HashMap<String, Object>> salesYearlyAmountJson() {
      return mapper.salesYearlyAmount();
   }
   
   @RequestMapping("refundYearlyAmount.json")
   @ResponseBody
   public List<HashMap<String, Object>> refundYearlyAmountJson() {
      return mapper.refundYearlyAmount();
   }
   
   @RequestMapping("costYearlyAmount.json")
   @ResponseBody
   public List<HashMap<String, Object>> costYearlyAmountJson() {
      return mapper.costYearlyAmount();
   }
   
   @RequestMapping("totalYearlyAmount.json")
   @ResponseBody
   public List<ArrayList<Object>> totalYearlyAmounJson() {
      List<HashMap<String, Object>> sArray = mapper.salesYearlyAmount();
      List<HashMap<String, Object>> rArray = mapper.refundYearlyAmount();
      List<HashMap<String, Object>> cArray = mapper.costYearlyAmount();
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("��¥");
      arr.add("����");
      arr.add("ȯ��");
      arr.add("���");
      listArr.add(arr);
      
      for(int i = 0; i < sArray.size(); i++) {
         arr = new ArrayList<>();
         arr.add("20" + sArray.get(i).get("YEAR") + "��");
         arr.add(sArray.get(i).get("SALESAMOUNT"));
         arr.add(rArray.get(i).get("REFUNDAMOUNT"));
         arr.add(cArray.get(i).get("COSTAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("salesYearlyPayTypeList.json")
   @ResponseBody
   public List<ArrayList<Object>> salesYearlyPayTypeListJson(String year) {
      year = year.substring(2);
      List<HashMap<String, Object>> sArray = mapper.salesYearlyPayTypeList(year);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("����Ÿ��");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      arr = new ArrayList<>();
      for(int i = 0; i < sArray.size(); i++) {
         arr = new ArrayList<>();
         arr.add(sArray.get(i).get("PAYTYPE"));
         arr.add(sArray.get(i).get("SALESAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("refundYearlyPayTypeList.json")
   @ResponseBody
   public List<ArrayList<Object>> refundYearlyPayTypeListJson(String year) {
      year = year.substring(2);
      List<HashMap<String, Object>> rArray = mapper.refundYearlyPayTypeList(year);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("����Ÿ��");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      for(int i = 0; i < rArray.size(); i++) {
         arr = new ArrayList<>();
         arr.add(rArray.get(i).get("PAYTYPE"));
         arr.add(rArray.get(i).get("REFUNDAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("salesMonthlyPayTypeList.json")
   @ResponseBody
   public List<ArrayList<Object>> salesMonthlyPayTypeListJson(String year, String month) {
      year = year.substring(2);
      List<HashMap<String, Object>> array = mapper.salesMonthlyPayTypeList(year, month);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("����Ÿ��");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      for(int i = 0; i < array.size(); i++) {
         arr = new ArrayList<>();
         arr.add(array.get(i).get("PAYTYPE"));
         arr.add(array.get(i).get("SALESAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("refundMonthlyPayTypeList.json")
   @ResponseBody
   public List<ArrayList<Object>> refundMonthlyPayTypeListJson(String year, String month) {
      year = year.substring(2);
      List<HashMap<String, Object>> array = mapper.refundMonthlyPayTypeList(year, month);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("����Ÿ��");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      for(int i = 0; i < array.size(); i++) {
         arr = new ArrayList<>();
         arr.add(array.get(i).get("PAYTYPE"));
         arr.add(array.get(i).get("REFUNDAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("salesYearlyCategoryList.json")
   @ResponseBody
   public List<ArrayList<Object>> salesYearlyCategoryListJson(String year) {
      year = year.substring(2);
      List<HashMap<String, Object>> array = mapper.salesYearlyCategoryList(year);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("��ǰ");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      for(int i = 0; i < array.size(); i++) {
         arr = new ArrayList<>();
         arr.add(array.get(i).get("LCATEGORY"));
         arr.add(array.get(i).get("SALESAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("refundYearlyCategoryList.json")
   @ResponseBody
   public List<ArrayList<Object>> refundYearlyCategoryListJson(String year) {
      year = year.substring(2);
      List<HashMap<String, Object>> array = mapper.refundYearlyCategoryList(year);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("��ǰ");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      for(int i = 0; i < array.size(); i++) {
         arr = new ArrayList<>();
         arr.add(array.get(i).get("LCATEGORY"));
         arr.add(array.get(i).get("REFUNDAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("refundMonthlyCategoryList.json")
   @ResponseBody
   public List<ArrayList<Object>> refundMonthlyCategoryListJson(String date) {
      date = date.substring(2);
      List<HashMap<String, Object>> array = mapper.refundMonthlyCategoryList(date);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("��ǰ");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      for(int i = 0; i < array.size(); i++) {
         arr = new ArrayList<>();
         arr.add(array.get(i).get("LCATEGORY"));
         arr.add(array.get(i).get("REFUNDAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("totalMonthlyBalance.json")
   @ResponseBody
   public List<ArrayList<Object>> depositYearlyBalanceJsonJson(String year) {
      year = year.substring(2);
      String companyCode = "347-88-00867";
      List<HashMap<String, Object>> dArray = mapper.depositMonthlyBalance(year, companyCode);
      List<HashMap<String, Object>> lArray = mapper.loansMonthlyBalance(year, companyCode);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("��¥");
      arr.add("����");
      arr.add("����");
      listArr.add(arr);
      
      for(int i = 0; i < dArray.size(); i++) {
         arr = new ArrayList<>();
         arr.add(dArray.get(i).get("MONTH") + "��");
         arr.add(dArray.get(i).get("ENDBALANCE"));
         arr.add(lArray.get(i).get("LOANSBALANCE"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("salesMonthlyCategoryList.json")
   @ResponseBody
   public List<ArrayList<Object>> salesMonthlyCategoryListJson(String date) {
      date = date.substring(2);
      List<HashMap<String, Object>> array = mapper.salesMonthlyCategoryList(date);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add("��ǰ");
      arr.add("�ݾ�");
      listArr.add(arr);
      
      for(int i = 0; i < array.size(); i++) {
         arr = new ArrayList<>();
         arr.add(array.get(i).get("LCATEGORY"));
         arr.add(array.get(i).get("SALESAMOUNT"));
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("total")
   public void total() {
   }
   @RequestMapping("thisMonthList.json")
   @ResponseBody
   public List<HashMap<String, Object>> thisMonthListJson(HttpSession session) {
      GregorianCalendar cal = new GregorianCalendar();
      String thisYear = cal.get(GregorianCalendar.YEAR)+"";
      String thisMonth = cal.get(GregorianCalendar.MONTH)+1+"";
      String date = thisYear +"/"+ "03";
      String companyCode = (String) session.getAttribute("companyCode");
        date = date.substring(2);
      int salesAmount = salesMapper.salesAmount(date, companyCode);
      int refundAmount = salesMapper.refundAmount(date, companyCode);
      HashMap<String, Object> cMap = costMapper.monthlyCostList(date, companyCode);
      List<HashMap<String, Object>> tMap = TMLMapper.targetList(date, companyCode);
      HashMap<String, Object> map = new HashMap<>();
      List<HashMap<String, Object>> array = new ArrayList<>();
      map.put("date", date);
      map.put("salesAmount", salesAmount);
      map.put("refundAmount", refundAmount);
      map.put("costAmount", cMap.get("COSTAMOUNT"));
      for(HashMap<String, Object> m:tMap) {
         map.put("targetSales", m.get("TARGETSALES"));
         map.put("targetCost", m.get("TARGETCOST"));
      }
      
      int year = Integer.parseInt(date.split("/")[0]);
      int month = Integer.parseInt(date.split("/")[1]);
      if(month > 01 && month < 12) {
         month--;
         if(month <= 9) {
            for(int i = 1; i <= 9; i++) {
                if(month == i) {
                   String strYear = year+"";
                   String strMonth = "0" + i;
                   date = strYear+"/"+strMonth;
                }
             }
         }
         if(month >= 10) {
            date = year+"/"+month;
         }
      }
      else if(month == 12) {
         month--;
         date = year+"/"+month;
      }
      else if(month == 01) {
         year = year - 1;
         month = 12;
         date = year+"/"+month;
      }
      int lastSalesAmount = salesMapper.salesAmount(date, companyCode);
      int lastRefundAmount = salesMapper.refundAmount(date, companyCode);
      HashMap<String, Object> lastcMap = costMapper.monthlyCostList(date, companyCode);
      if(lastSalesAmount != 0 && lastRefundAmount != 0 && lastcMap != null) {
         map.put("lastSalesAmount", lastSalesAmount);
          map.put("lastRefundAmount", lastRefundAmount);
          map.put("lastCostAmount", lastcMap.get("COSTAMOUNT"));
          array.add(map);
      }
      
      return array;
   }
//   @RequestMapping("main")
//   public void main() {
//   }
}