package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.domain.CostVO;
import com.example.domain.DayVO;
import com.example.mapper_oracle.AdminMapper;
import com.example.mapper_oracle.GrapeMapper;
import com.example.service.AdminService;

@Controller
public class SController {
	@Autowired
	AdminMapper aMapper;
	@Autowired
	GrapeMapper gMapper;
	
	@Autowired
	AdminService service;

///e달력 데이터
//	@RequestMapping("costList.json")
//	@ResponseBody
//	public List<CostVO> costList(String date) {
//		 String year = date.split("/")[0].substring(2);
//	      String month = date.split("/")[1];
//	      String strDate = year+"/"+month;
//	      List<CostVO> array = gMapper.costList(strDate);
//	      return array;
//	}
//	 @RequestMapping("daily.json")
//	   @ResponseBody
//	   public List<DayVO> dailyJson(String date) {
//	      String year = date.split("/")[0].substring(2);
//	      String month = date.split("/")[1];
//	      date = year+"/"+month;
//	      List<DayVO> array = gMapper.dailyList(date);
//	      return array;
//	   }
//	@RequestMapping("dailyYear.json")
//	   @ResponseBody
//	   public List<DayVO> dailyYearJson() {
//	      List<DayVO> array = gMapper.dailyYearList();
//	      return array;
//	   }
//	   
//	   @RequestMapping("dailyMonth.json")
//	   @ResponseBody
//	   public List<DayVO> dailyMonthJson(String date) {
//	      String year = date.substring(2);
//	      List<DayVO> array = gMapper.dailyMonthList(year);
//	      return array;
//	   }
	   //
	 //카드,현금,기타별 총금액
		@RequestMapping("payTypeList.json")
		@ResponseBody
		public List<HashMap<String, Object>> payTypeList(String date){
			String  strDate = date.substring(2);
			String year = strDate.split("/")[0];
			String month = strDate.split("/")[1];
			String day = strDate.split("/")[2];
			date = year +"/"+ month +"/"+ day;
			List<HashMap<String,Object>> sArray=gMapper.salesAmount(strDate);
			List<HashMap<String,Object>> rArray=gMapper.refundAmount(strDate);
			HashMap<String,Object> cMap=gMapper.costTotalView(strDate);
			
			HashMap<String,Object> stMap=gMapper.salesTotalView(date);
			HashMap<String,Object> rtMap=gMapper.refundTotalView(date);
			
			List<HashMap<String, Object>> list = new ArrayList<>();
			for(HashMap<String, Object> map : sArray) {
				list.add(map);
			}
			
			for(HashMap<String, Object> map : rArray) {
				list.add(map);
			}
			HashMap<String, Object> map = new HashMap<>();
			map.put("COSTTOTAL", cMap.get("COSTTOTAL"));
			list.add(map);
			
			return list;
		}
	   
	   
	//환불 매출그래프	
		@RequestMapping("costrefundList.json")
		@ResponseBody
		public List<ArrayList<Object>> costrefundList(String date) {
			String strDate = date.substring(2);
			String year = strDate.split("/")[0];
			String month = strDate.split("/")[1];
			String day = strDate.split("/")[2];
			date = year +"/"+ month +"/"+ day;
			HashMap<String,Object> sMap=gMapper.salesTotalView(date);
			HashMap<String,Object> rMap=gMapper.refundTotalView(date);
			
			List<ArrayList<Object>> listArr=new ArrayList<>();
			ArrayList<Object> arr=new ArrayList<>();
			arr.add("");
			arr.add("매출");
			arr.add("환불");
			listArr.add(arr);
			
			arr = new ArrayList<>();
			arr.add("");
			arr.add(sMap.get("SALESTOTAL"));
			arr.add(rMap.get("REFUNDTOTAL"));
			listArr.add(arr);
			
			return listArr;
		}
	//달렷 그래프
	@RequestMapping("GraphList.json")
	@ResponseBody
	public List<ArrayList<Object>> GraphList(String date) {
		String strDate = date.substring(2);
		String year = strDate.split("/")[0];
		String month = strDate.split("/")[1];
		String day = strDate.split("/")[2];
		date = year +"/"+ month +"/"+ day;
		HashMap<String,Object> sMap=gMapper.salesTotalView(date);
		HashMap<String,Object> rMap=gMapper.refundTotalView(date);
		HashMap<String,Object> cMap=gMapper.costTotalView(date);
		
		List<ArrayList<Object>> listArr=new ArrayList<>();
		ArrayList<Object> arr=new ArrayList<>();
		arr.add(" ");
		arr.add("매출");
		arr.add("환불");
		arr.add("비용");
		listArr.add(arr);
		
		arr = new ArrayList<>();
		arr.add("date");
		arr.add(sMap.get("SALESTOTAL"));
		arr.add(rMap.get("REFUNDTOTAL"));
		arr.add(cMap.get("COSTTOTAL"));
		listArr.add(arr);
		
		return listArr;
	}

	@RequestMapping("calen")
	public void calen() {
	}

	@RequestMapping("salesCategoryAmountList.json")
	@ResponseBody
	public List<ArrayList<Object>> salesCategoryAmountListJson(String date) {
		String companyCode ="347-88-00867"; 
		date = date.substring(2);
		List<HashMap<String, Object>> array = gMapper.salesCategoryAmountList(date, companyCode);
		
		List<ArrayList<Object>> listArr=new ArrayList<>();
		ArrayList<Object> arr=new ArrayList<>();
		for(HashMap<String, Object> map:array) {
			arr=new ArrayList<>();
			arr.add(map.get("LCATEGORY"));
			arr.add(map.get("SALESAMOUNT"));
			listArr.add(arr);
		}
		return listArr;
	}
	
	@RequestMapping("refundCategoryAmountList.json")
	@ResponseBody
	public List<ArrayList<Object>> refundCategoryAmountListJson(String date) {
		String companyCode ="347-88-00867";
		date = date.substring(2);
		List<HashMap<String, Object>> array = gMapper.refundCategoryAmountList(date, companyCode);
		
		List<ArrayList<Object>> listArr=new ArrayList<>();
		ArrayList<Object> arr=new ArrayList<>();
		System.out.println(array.size());
		for(HashMap<String, Object> map:array) {
			arr=new ArrayList<>();
			arr.add(map.get("LCATEGORY"));
			arr.add(map.get("REFUNDAMOUNT"));
			listArr.add(arr);
		}
		return listArr;
	}
	
	@RequestMapping("salesTotalAmount.json")
	@ResponseBody
	public HashMap<String, Object> salesTotalAmountJson(String date) {
		String companyCode ="347-88-00867";
		date = date.substring(2);
		return gMapper.salesTotalAmount(date, companyCode);
	}
	
	@RequestMapping("refundTotalAmount.json")
	@ResponseBody
	public HashMap<String, Object> refundTotalAmountJson(String date) {
		String companyCode ="347-88-00867";
		date = date.substring(2);
		return gMapper.refundTotalAmount(date, companyCode);
	}
	
	@RequestMapping("costTotalAmount")
	@ResponseBody
	public HashMap<String, Object> costTotalAmountJson(String date) {
		String companyCode ="347-88-00867";
		date = date.substring(2);
		return gMapper.costTotalAmount(date, companyCode);
	}

	@RequestMapping("categoryList.json")
	@ResponseBody
	public List<ArrayList<Object>> categoryListJson(String date) {
		String companyCode = "347-88-00867";
		List<HashMap<String, Object>> cList = gMapper.categoryList();
		List<HashMap<String, Object>> scArray = gMapper.salesCategoryAmountList(date, companyCode);
		List<HashMap<String, Object>> rcArray = gMapper.refundCategoryAmountList(date, companyCode);
		HashMap<String, Object> sMap = gMapper.salesTotalAmount(date, companyCode);
		HashMap<String, Object> rMap = gMapper.refundTotalAmount(date, companyCode);
		
		List<ArrayList<Object>> listArr=new ArrayList<>();
		ArrayList<Object> arr=new ArrayList<>();
		arr.add("대분류");
		arr.add("매출액");
		arr.add("환불액");
		listArr.add(arr);
		for(int i = 0; i < cList.size(); i++) {
			int scnt = 0;
			int rcnt = 0;
			arr=new ArrayList<>();
			String LC = (String) cList.get(i).get("LCATEGORY");
			arr.add(cList.get(i).get("LCATEGORY"));
			
			for(int sc = 0; sc < scArray.size(); sc++) {
				String SLC = (String) scArray.get(sc).get("LCATEGORY");
				if(LC.equals(SLC)) {
					arr.add(scArray.get(sc).get("SALESAMOUNT"));
					scnt++;
				}
			}
			
			for(int rc = 0; rc < rcArray.size(); rc++) {
				String RLC = (String) rcArray.get(rc).get("LCATEGORY");
				if(LC.equals(RLC)) {
					arr.add(rcArray.get(rc).get("REFUNDAMOUNT"));
					rcnt++;
				}
			}
			
			if(scnt==0) {
				arr.add(0);
			}
			if(rcnt==0) {
				arr.add(0);
			}
			
			if(arr.size() > 1) {
				listArr.add(arr);	
			}
		}
		return listArr;
	}
	 @RequestMapping("dataLists.json")
	   @ResponseBody
	   public List<HashMap<String, Object>> dataListsJson(String date) {
	      String strDate = date.substring(2);
	      String year = strDate.split("/")[0];
	      String month = strDate.split("/")[1];
	      String day = strDate.split("/")[2];
	      date = year +"/"+ month+"/"+day;
	      
	      return gMapper.dataLists(date);
	   }
	 
	 @RequestMapping("readTarget.json")
	 @ResponseBody
	 public int readTargetJson(String date) {
		 date = date.substring(2);
		 String companyCode = "347-88-00867";
		 return aMapper.readTarget(date, companyCode);
	 }

//	@RequestMapping("list")
//	public String list(Model model, HttpSession session, HttpServletRequest request) {
//		Cookie cookie = WebUtils.getCookie(request, "adminId");
//		if (cookie != null) {
//			session.setAttribute("adminId", cookie.getValue());
//		}
//
//		String dest = (String) session.getAttribute("dest");
//		if (session.getAttribute("dest") != null) {
//			session.removeAttribute("dest");
//			return "redirect:" + dest;
//		}
//		model.addAttribute("list", aMapper.list());
//		return "list";
//	}

//	@RequestMapping("read")
//	public void read(Model model, String adminId) {
//		model.addAttribute("vo", aMapper.read(adminId));
//	}
//	
	//비밀번호 변경
//	@RequestMapping("pwUpdate")
//	public void pwUpdate(){
//		
//	}
//	@RequestMapping("insert")
//	public void insert() {
//	}
//
//	@RequestMapping(value = "insert", method = RequestMethod.POST)
//	public void insertPost() {
//
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "calendarFrm", method = RequestMethod.POST)
//	public int calendarFrmPost() {
//		return 0;
//
//	}
//
//	@RequestMapping("regi")
//	public void regi() {
//
//	}
//	@ResponseBody
//	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
//	public int idCheck(String adminId) {
//		int count = aMapper.idCheck(adminId);
//		return count;
//	}

//	// 로그인
//	@RequestMapping("login")
//	public void logIn() {
//
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public int loginPost(AdminVO vo, boolean chkLogin, HttpSession session, HttpServletResponse response) {
//		AdminVO resultVO = aMapper.read(vo.getAdminId());
//
//		if (resultVO != null) {
//			if (!resultVO.getAdminPassword().equals(vo.getAdminPassword())) {
//				return 2;
//				// FAILED PW
//			} else {
//				session.setAttribute("adminId", vo.getAdminId());
//				if (chkLogin) {// login유지
//					Cookie cookie = new Cookie("adminId", vo.getAdminId());
//					cookie.setPath("/");
//					cookie.setMaxAge(60 * 60 * 24 * 7);
//					response.addCookie(cookie);
//				}
//				return 1; // SUCCESS
//			}
//		}
//		return 0; // NO ID
//	}
//
//	@RequestMapping("logOut")
//	public String logOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
//		session.invalidate();
//
//		Cookie cookie = WebUtils.getCookie(request, "adminId");
//		if (cookie != null) {
//			cookie.setPath("/");
//			cookie.setMaxAge(0);
//			response.addCookie(cookie);
//		}
//		return "redirect:list";
//	}
//
//	@RequestMapping("idCheck")
//	public void idCheck() {
//	}

	
//		//사업자 번호 셀리늄
//	 @RequestMapping("regi.json")
//	   @ResponseBody
//	   public HashMap<String, String> companyJson(String number) throws Exception {
//	      HashMap<String, String> array = new HashMap<>();
//	      System.setProperty("webdriver.chrome.driver", "d:/spring/chromedriver.exe"); //  뱶 씪誘몃쾭  젙 쓽
//	      ChromeOptions options= new ChromeOptions();
//	      options.addArguments("headless");
//	      WebDriver driver = new ChromeDriver(options);
//	      driver.get("https://teht.hometax.go.kr/websquare/websquare.html?w2xPath=/ui/ab/a/a/UTEABAAA13.xml");
//	      
//
//	      
//	      WebElement insert= driver.findElement(By.xpath("//*[@id='bsno']"));
//	      insert.sendKeys(number);
//	      
//	      
//	      WebElement btnSearch = driver.findElement(By.xpath("//*[@id='trigger5']"));
//	      btnSearch.click();
//	      
//	      WebDriverWait wait = new WebDriverWait(driver, 6);
//	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid2_cell_0_1']")));
//	      
//	      WebElement result = driver.findElement(By.xpath("//*[@id='grid2_cell_0_1']"));
//	      array.put("result", result.getText());
//	      System.out.println(result.getText());
//	      
//	      
//	      driver.quit();
//	      return array;
//	   }
	   
	
}
