package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.domain.AdminVO;
import com.example.mapper_oracle.AdminMapper;
import com.example.mapper_oracle.CalendarMapper;
import com.example.mapper_oracle.ProductMapper;
import com.example.service.AdminService;

@Controller
public class LoginController {
	@Autowired
	CalendarMapper cMapper;
	
	@Autowired
    AdminService service;
 @Autowired
 AdminMapper aMapper;
  @Autowired
 ProductMapper mapper;
	
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
//  @RequestMapping(value = "insert", method = RequestMethod.POST)
//  public void insertPost(AdminVO vo) throws Exception {
////     // 대표이미지 하나 업로드
////     MultipartFile file = multi.getFile("file");
////     if (!file.isEmpty()) {
////        UUID uid = UUID.randomUUID();
////        String savedName = uid.toString() + "_" + file.getOriginalFilename();
////        File target = new File(path, savedName);
////        FileCopyUtils.copy(file.getBytes(), target);
////        vo.setLogoImage(savedName);
////
////     }
//     mapper.insert(vo);
//  }
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
//  // 이미지출력
//  @RequestMapping("display") // display?fileName=6de77153-9004-4322-88dd-4403a01fe987_img24
//  @ResponseBody
//  public ResponseEntity<byte[]> display(String fileName) throws Exception {
//     ResponseEntity<byte[]> result = null;
//     // display fileName이 있는 경우
//     if (!fileName.equals("")) {
//        File file = new File(path + File.separator + fileName);
//        HttpHeaders header = new HttpHeaders();
//        header.add("Content-Type", Files.probeContentType(file.toPath()));
//        result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//     }
//     return result;
//  }
  
  //사업자 번호 셀리늄
//   @RequestMapping("company.json")
//     @ResponseBody
//     public HashMap<String, String> companyJson(String number) throws Exception {
//        HashMap<String, String> array = new HashMap<>();
//        System.setProperty("webdriver.chrome.driver", "d:/spring/chromedriver.exe"); 
//        ChromeOptions options= new ChromeOptions();
//        options.addArguments("headless");
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://teht.hometax.go.kr/websquare/websquare.html?w2xPath=/ui/ab/a/a/UTEABAAA13.xml");
//        
//
//        
//        WebElement insert= driver.findElement(By.xpath("//*[@id='bsno']"));
//        insert.sendKeys(number);
//        
//        
//        WebElement btnSearch = driver.findElement(By.xpath("//*[@id='trigger5']"));
//        btnSearch.click();
//        
//        WebDriverWait wait = new WebDriverWait(driver, 6);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid2_cell_0_1']")));
//        
//        WebElement result = driver.findElement(By.xpath("//*[@id='grid2_cell_0_1']"));
//        array.put("result", result.getText());
//        System.out.println(result.getText());
//        
//        
//        driver.quit();
//        return array;
//     }
   
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
   
  

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("lcategorylist.json")
	   @ResponseBody
	   public List<HashMap<String, Object>> lcategorylist( ) {
		String companyCode = "347-88-00867";
	      List<HashMap<String, Object>> array = cMapper.lcategorylist(companyCode);
	      return array;
	   }
	
	@RequestMapping("mainThisMonthlyTotal.json")
	@ResponseBody
	public List<ArrayList<Object>> mainThisMonthlyTotalJson(String date) {
		String companyCode = "347-88-00867";
		date = date.substring(2);
		
		HashMap<String, Object> sMap = cMapper.salesThisMonthlyTotal(date, companyCode);
		HashMap<String, Object> rMap = cMapper.refundThisMonthlyTotal(date, companyCode);
		HashMap<String, Object> cMap = cMapper.costThisMonthlyTotal(date, companyCode);
		
		List<ArrayList<Object>> listArr = new ArrayList<>();
		ArrayList<Object> arr = new ArrayList<>();
		arr.add(" ");
		arr.add("매출");
		arr.add("환불");
		arr.add("비용");
		listArr.add(arr);
		
		arr = new ArrayList<>();
		arr.add(" ");
		arr.add(sMap.get("SALESAMOUNT"));
		arr.add(rMap.get("REFUNDAMOUNT"));
		arr.add(cMap.get("COSTAMOUNT"));
		listArr.add(arr);
		
		return listArr;
	}
}
