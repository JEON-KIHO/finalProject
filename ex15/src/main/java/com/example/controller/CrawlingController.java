package com.example.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.CGVVO;
import com.example.mapper.CGVMapper;

@Controller
public class CrawlingController {
	
	@Autowired
	CGVMapper mapper;
	
	@Resource(name="uploadPath")
	String path;
	
	@RequestMapping("cgv.json")
	@ResponseBody
	public ArrayList<HashMap<String, Object>> cgvJson() {
		ArrayList<HashMap<String, Object>> array = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			Elements es = doc.select(".sect-movie-chart ol");
			for(Element e:es.select("li")) {
				if (!e.select(".rank").text().equals("")) {
					HashMap<String, Object> map = new HashMap<>();
					map.put("rank", e.select(".rank").text());
					map.put("title", e.select(".title").text());
					map.put("image", e.select("img").attr("src"));
					array.add(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
	@RequestMapping("weather.json")
	@ResponseBody
	public ArrayList<HashMap<String, Object>> weatherJson() {
		ArrayList<HashMap<String, Object>> array = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.daum.net/").get();
			// 지역별 날씨 출력
			Elements es = doc.select(".list_weather");
			for(Element e:es.select("li")) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("part", e.select(".txt_part").text());
				map.put("weather", e.select(".screen_out").text());
				array.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
	@RequestMapping("cgv")
	public void cgv() {
	}
	
	@RequestMapping("insert")
	@ResponseBody
	public void isnert(CGVVO vo,String fullImage){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date day = new Date();
		vo.setDay(sdf.format(day));
		
		// 이미지 다운로드
		try {
			URL url = new URL(fullImage);
			InputStream in = url.openStream();
			OutputStream out = new FileOutputStream(path + "/" + vo.getImage());
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapper.insert(vo);
	}
}
