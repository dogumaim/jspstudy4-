package com.yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public ModelAndView hello() { // ModelAndView가 전에 만들었던 Action과 같다
		String msg="Spring Mvc Framework~!";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("hello"); //wed-inf 폴더는 사용자가 들어갈 수 없는 폴더이다.
		
		return mav;
	}
}
