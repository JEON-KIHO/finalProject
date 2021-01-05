package com.example.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping("/login")
	public void login() {
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public int loginPost(UserVO vo, HttpSession session, boolean chkLogin, HttpServletResponse response) {
		UserVO resultVO = mapper.login(vo.getUser_id());
		int result;
		if (resultVO == null) {
			result = 0;
		} else if (!resultVO.getUser_password().equals(vo.getUser_password())) {
			result = 1;
		} else {
			session.setAttribute("user_id", vo.getUser_id());
			if (chkLogin) {
				Cookie cookie = new Cookie("user_id", vo.getUser_id());
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 7); // 초단위
				response.addCookie(cookie);
			}
			result = 2;

		}
		return result;
	}

	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		
		// 쿠키 삭제
		Cookie cookie = WebUtils.getCookie(request, "user_id");
		if(cookie != null) {
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return "redirect:list";
	}
}
