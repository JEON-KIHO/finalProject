package com.example.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.CostVO;
import com.example.domain.DayVO;
import com.example.mapper_oracle.CostMapper;

@Controller
public class CostController {
   @Autowired
   CostMapper mapper;
   
   @RequestMapping("insertDay.json")
   @ResponseBody
   public void insertDay() {
      GregorianCalendar cal = new GregorianCalendar();
      int thisYear = cal.get(GregorianCalendar.YEAR);
      int thisMonth = cal.get(GregorianCalendar.MONTH)+1;
      int thisDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
      
      for(int y = thisYear; y <= thisYear; y++) {
         cal.set(GregorianCalendar.YEAR, y);
         String year = y+"";
         
         for(int m = 1; m <= 12; m++) {
            
            if(y==thisYear) {
               if(m >= thisMonth) {
                  cal.set(GregorianCalendar.MONTH, m-1);
                  String month = m+"";
                  if(month.length() == 1) {
                     month = "0" + month;
                  }
                  cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
                  int maxDay = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
                     
                     if(thisDay == 1) {
                        for(int d = 1; d <= maxDay; d++) {
                           cal.set(GregorianCalendar.DAY_OF_MONTH, d);
                           String day = d + "";
                           if (day.length() == 1) {
                              day = "0" + day;
                           }
                           String strDate = y +"/"+ m + "/" + d;
                           Date date = cal.getTime();
                           System.out.println(date + "/" + cal.get(GregorianCalendar.WEEK_OF_MONTH));
                            mapper.insert(strDate, cal.get(GregorianCalendar.WEEK_OF_MONTH));
                        }
                     } else {
                        for(int d = thisDay; d <= maxDay; d++) {
                           cal.set(GregorianCalendar.DAY_OF_MONTH, d);
                           String day = d + "";
                           if (day.length() == 1) {
                              day = "0" + day;
                           }
                           String strDate = y +"/"+ m + "/" + d;
                           Date date = cal.getTime();
                           System.out.println(date + "/" + cal.get(GregorianCalendar.WEEK_OF_MONTH));
                            mapper.insert(strDate, cal.get(GregorianCalendar.WEEK_OF_MONTH));
                        }
                        thisDay = 1;
                     }
               }
            } else {
               cal.set(GregorianCalendar.MONTH, m-1);
               String month = m+"";
               if(month.length() == 1) {
                  month = "0" + month;
               }
               cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
               int maxDay = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
               
               for(int d = 1; d <= maxDay; d++) {
                  cal.set(GregorianCalendar.DAY_OF_MONTH, d);
                  String day = d+"";
                  if(day.length() == 1) {
                     day = "0" + day;
                  }
                  String strDate = y +"/"+ m + "/" + d;
                  Date date = cal.getTime();
                  System.out.println(date + "/" + cal.get(GregorianCalendar.WEEK_OF_MONTH));
                  mapper.insert(strDate, cal.get(GregorianCalendar.WEEK_OF_MONTH));
               }
            }
            
         }
      }
   }
   
   @RequestMapping("data.json")
   @ResponseBody
   public List<HashMap<String, Object>> dataJson(String date) throws ParseException {
      String strDate = date.substring(2);
      String year = strDate.split("/")[0];
      String month = strDate.split("/")[1];
      String day = strDate.split("/")[2];
      if(day.length() == 1) {
         day = "0" + day;
      }
      strDate = year +"/"+ month +"/"+ day;
      System.out.println("------------------" + strDate);
      return mapper.dataList(strDate);
   }
   
   @RequestMapping("dailyYear.json")
   @ResponseBody
   public List<DayVO> dailyYearJson() {
      List<DayVO> array = mapper.dailyYearList();
      return array;
   }
   
   @RequestMapping("dailyMonth.json")
   @ResponseBody
   public List<DayVO> dailyMonthJson(String date) {
      String year = date.substring(2);
      List<DayVO> array = mapper.dailyMonthList(year);
      return array;
   }
   
   @RequestMapping("daily.json")
   @ResponseBody
   public List<DayVO> dailyJson(String date) {
      String year = date.split("/")[0].substring(2);
      String month = date.split("/")[1];
      date = year+"/"+month;
      List<DayVO> array = mapper.dailyList(date);
      return array;
   }
   
   @RequestMapping("calendar")
   public void calendar(Model model, String date) {
      String year = date.split("/")[0].substring(2,4);
      String month = date.split("/")[1];
      String day = date.split("/")[2];
      if(day.length() == 1) {
         day = "0" + day;
      }
      String strDate = year +"/"+ month +"/"+ day;
      model.addAttribute("list", mapper.dataList(strDate));
   }
   
   
   @RequestMapping("costList.json")
   @ResponseBody
   public List<CostVO> costListJson(String date) {
      String year = date.split("/")[0].substring(2);
      String month = date.split("/")[1];
      String strDate = year +"/"+ month;
      List<CostVO> array = mapper.costList(strDate);
      return array;
   }
   
   @RequestMapping("costGraphList.json")
   @ResponseBody
   public List<ArrayList<Object>> costGraphListJson(String date, String monthlyCost, HttpSession session) {
	   String companyCode = (String)session.getAttribute("companyCode");
	   
      String year = date.split("/")[0].substring(2);
      String month = date.split("/")[1];
      String day = date.split("/")[2];
      String strDate = year +"/"+ month +"/"+ day;
      List<CostVO> array = mapper.costGraphList(strDate);
      
      List<ArrayList<Object>> listArr = new ArrayList<>();
      ArrayList<Object> arr = new ArrayList<>();
      arr.add(" ");
      arr.add("���");
      listArr.add(arr);
      
      for(CostVO vo:array) {
         arr = new ArrayList<>();
         arr.add(" ");
         arr.add(vo.getCostAmount());
         listArr.add(arr);
      }
      
      return listArr;
   }
   
   @RequestMapping("cost")
   public void cost() {
   }
   
   @RequestMapping("dataList.json")
   @ResponseBody
   public List<HashMap<String, Object>> dataListJson(String date) {
	   System.out.println(date);
      String strDate = date.substring(0,7);
      String year = strDate.split("/")[0].substring(2,4);
      String month = strDate.split("/")[1];
//      String day = strDate.split("/")[2];
      date = year +"/"+ month;
      return mapper.dataList(date);
   }
   
   
}