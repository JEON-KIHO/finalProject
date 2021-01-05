package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.mapper.AddressMapper;

@Controller
public class AddressController {

	@Autowired
	AddressMapper mapper;
	
	@RequestMapping(value="/list")
	public void list(Criteria cri, Model model) {
		cri.setPerPageNum(cri.getPerPageNum());
		model.addAttribute("list", mapper.list(cri));
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(cri));
		model.addAttribute("pm", pm);
	}
}
