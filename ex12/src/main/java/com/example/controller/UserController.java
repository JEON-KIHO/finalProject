package com.example.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.domain.UserVO;
import com.example.mapper.UserMapper;

@Controller
public class UserController {
	@Autowired
	UserMapper mapper;
	
	@RequestMapping("list")
	public String list(Model model, HttpSession session, HttpServletRequest request) {
		Cookie cookie = WebUtils.getCookie(request, "user_id");
		if(cookie != null) {
			session.setAttribute("user_id", cookie.getValue());
		}
		
		String dest = (String) session.getAttribute("dest");
		if(session.getAttribute("dest") != null) {
			session.removeAttribute("dest");
			return "redirect:" + dest;
		}
		model.addAttribute("list", mapper.list());
		return "list";
	}
	
	@RequestMapping("read")
	public void read(Model model, String user_id) {
		model.addAttribute("vo", mapper.read(user_id));
	}
	
	@RequestMapping("login")
	public void login() {
	}
	
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	public int loginPost(UserVO vo, boolean chkLogin, HttpSession session, HttpServletResponse response) {
		UserVO resultVO = mapper.read(vo.getUser_id());
		
		if(resultVO != null) {
			if(!resultVO.getUser_password().equals(vo.getUser_password())) {
				return 1; // FAILED PW
			}
			else {
				session.setAttribute("user_id", vo.getUser_id());
				if(chkLogin) {
					Cookie cookie = new Cookie("user_id", vo.getUser_id());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
				return 2; // SUCCESS
			}
		}
		return 0; // NO ID
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		
		Cookie cookie = WebUtils.getCookie(request, "user_id");
		if(cookie != null) {
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return "redirect:list";
	}
	
	@RequestMapping("insert")
	public void insert() {
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public void insertPost() {
		
	}
}
