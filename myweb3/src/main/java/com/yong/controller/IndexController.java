package com.yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String index() {
//		
//		ModelAndView mav=new ModelAndView();
//		
//		mav.setViewName("index");
//		
//		return mav; 
		
		return "index"; //명시적 뷰 지정
	}
}
