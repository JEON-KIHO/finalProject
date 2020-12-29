package com.example.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.domain.AdminVO;
import com.example.mapper_oracle.AdminMapper;
import com.example.mapper_oracle.ProductMapper;
import com.example.service.AdminService;



@Controller
public class LoginController {
	   @Autowired
	   AdminService service;
	@Autowired
	AdminMapper aMapper;
	 @Autowired
	ProductMapper mapper;

	@Resource(name = "uploadPath")
	String path;
	
	@RequestMapping("login")
	public void login(){
	
	}
	
	
	@RequestMapping("company")
	public void company(){
		

	}
	@RequestMapping("mainlogin")
	public void mainlogin() {
		
		
	}

	@RequestMapping("main")
	public void main(){
		
	}
	
	@RequestMapping("insert")
	public void insert() {

	}
	
	@RequestMapping(value = "insert", method=RequestMethod.POST)
	   public String insertPost(AdminVO vo, @RequestParam("companyType") String companyType){
	      vo.setCompanyType(companyType);
	      System.out.println("Insert...........>>" + vo.toString());
	      mapper.insert(vo);
	      
	      return "redirect:login";
	   }
	// 비밀번호 변경
    @RequestMapping("pwUpdate")
    public void pwUpdate() {
    }

    @ResponseBody
    @RequestMapping(value = "pwUpdate", method = RequestMethod.POST)
    public String pwUpdatePost(AdminVO vo, HttpSession session, HttpServletResponse response, String adminPassword)
          throws Exception {
       AdminVO resultVO = aMapper.read(session.getAttribute("adminId").toString());
       // System.out.println(resultVO.toString()+session.getAttribute("adminId").toString());
       if (resultVO.getAdminId().equals(session.getAttribute("adminId"))) {
          // System.out.println("??????????????????????");
          aMapper.pwUpdate(vo.getAdminPassword(), resultVO.getCompanyCode(), resultVO.getAdminId());

       }
       return "redirect:pwUpdate";
    }

	//list
	@RequestMapping("list")
	   public String list(Model model, HttpSession session, HttpServletRequest request) {
	      Cookie cookie = WebUtils.getCookie(request, "adminId");
	      if (cookie != null) {
	         session.setAttribute("adminId", cookie.getValue());
	      }

	      String dest = (String) session.getAttribute("dest");
	      if (session.getAttribute("dest") != null) {
	         session.removeAttribute("dest");
	         return "redirect:" + dest;
	      }
	      model.addAttribute("list", mapper.list());
	      return "list";
	   }

	
	//사업자 번호 셀리늄
    @RequestMapping("company.json")
      @ResponseBody
      public HashMap<String, String> companyJson(String number) throws Exception {
         HashMap<String, String> array = new HashMap<>();
         System.setProperty("webdriver.chrome.driver", "d:/spring/chromedriver.exe"); 
         ChromeOptions options= new ChromeOptions();
         options.addArguments("headless");
         WebDriver driver = new ChromeDriver(options);
         driver.get("https://teht.hometax.go.kr/websquare/websquare.html?w2xPath=/ui/ab/a/a/UTEABAAA13.xml");
         

         
         WebElement insert= driver.findElement(By.xpath("//*[@id='bsno']"));
         insert.sendKeys(number);
         
         
         WebElement btnSearch = driver.findElement(By.xpath("//*[@id='trigger5']"));
         btnSearch.click();
         
         WebDriverWait wait = new WebDriverWait(driver, 6);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid2_cell_0_1']")));
         
         WebElement result = driver.findElement(By.xpath("//*[@id='grid2_cell_0_1']"));
         array.put("result", result.getText());
         System.out.println(result.getText());
         
         
         driver.quit();
         return array;
      }
    
    @ResponseBody
    @RequestMapping(value = "idCheck", method = RequestMethod.POST)
    public int idCheck(String adminId) {
       int count = mapper.idCheck(adminId);
       return count;
    }



    @ResponseBody
    @RequestMapping(value = "mainlogin", method = RequestMethod.POST)
    public int loginPost(AdminVO vo, boolean chkLogin, HttpSession session, HttpServletResponse response) {
       AdminVO resultVO = mapper.read(vo.getAdminId());

       if (resultVO != null) {
          if (!resultVO.getAdminPassword().equals(vo.getAdminPassword())) {
             return 2;
             // FAILED PW
          } else {
             session.setAttribute("adminId", resultVO.getAdminId());
             session.setAttribute("companyCode", resultVO.getCompanyCode());
             session.setAttribute("companyName", resultVO.getCompanyName());
             return 1; // SUCCESS
          }
       }
       return 0; // NO ID
    }

    @RequestMapping("logout")
    public String logOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
       session.invalidate();

       return "redirect:list";
    }

    @RequestMapping("idCheck")
    public void idCheck() {
    }
    
   
      
}
