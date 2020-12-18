package com.example.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApiController {
	//WebDriver 설정
		private WebDriver driver;
		private WebElement element;
		private String url;
	    
		//Properties 설정
		public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
		public static String WEB_DRIVER_PATH = "d:/spring/chromedriver.exe";
		public static String TEST_URL = "https://www.hometax.go.kr/websquare/websquare.wq?w2xPath=/ui/pp/index_pp.xml&tmIdx=&tm2lIdx=&tm3lIdx=";
	    	// (여기선 naver 를 사용해봤습니다.)
	    
		public static void main(String[] args) {
	 
			ApiController test = new ApiController();
		}
	    
		public ApiController() {
			//System Property SetUp
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	        
			//Driver SetUp
			ChromeOptions options = new ChromeOptions();
			options.setCapability("ignoreProtectedModeSettings", true);
			driver = new ChromeDriver(options);        
		}
	    
	        public void login() {
	           try {
	                driver.get(TEST_URL);

	                //로그인 버튼 클릭
	                // class로 찾아도 되지만, xpath(상대 or 절대)로 찾는게 나은 거 같습니다. 
//	                element = driver.findElement(By.xpath("//*[@id="account"]/a"));
//	                element.click();

	                //아이디 입력
	                // id 값으로도 찾을 수 있습니다. 
	                element = driver.findElement(By.id("bsno"));
	                // 크롤링으로 text를 입력하면 굉장히 빠릅니다, 인식하지 못한 상태에서 이벤트를 발생시키면, 제대로 작동하지 않기 때문에 thread sleep으로 기다려줍니다.
	                Thread.sleep(500); 
	                element.sendKeys("111111111");
	                // 유저 정보를 담은 객체에서 아이디값을 가져와서 넣어주면 되겠죠-

	                //패스워드 입력 - 아이디와 마찬가지입니다.
//	                element = driver.findElement(By.id("pw"));
//	                element.sendKeys("비밀번호 입력");
	                

	                //전송
	                element = driver.findElement(By.className("w2trigger"));
	                element.click();
	                
	                element = driver.findElement(By.className("gridBodyDefault"));
	                element.getText();

	                Thread.sleep(10000);

	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                driver.close();
	            }

		}
}
