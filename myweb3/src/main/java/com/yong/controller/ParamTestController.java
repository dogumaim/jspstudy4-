package com.yong.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ParamTestController {
	
	@RequestMapping("/paramTest.do")
	public ModelAndView paramTest(@RequestParam(value="str", required = false)String str,
			@RequestParam(value="idx", required = false, defaultValue = "0")int idx) {
		
		System.out.println("str="+str);
		System.out.println("idx="+idx);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("param/paramOk");
		
		return mav;
	}
	
	@RequestMapping("/cookieView.do")
	public ModelAndView cookieView(@CookieValue(value= "saveid", required = false,defaultValue = "noId")String saveid) {
		
		System.out.println("saveid="+saveid);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("param/paramOk");
		return mav;
		
	}
	@RequestMapping("/cookieMake.do")
	public ModelAndView cookieMake(HttpServletResponse res) {
		
		Cookie ck=new Cookie("saveid", "hong");
		ck.setMaxAge(60*3);
		res.addCookie(ck);	
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("param/paramOk");
		return mav;
	}
	
	@RequestMapping("/sessionView.do")
	public ModelAndView sessionView(HttpSession session) {
		
		String name=(String)session.getAttribute("name");
		System.out.println("name="+name);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("param/paramOk");
		return mav;
	}
	
	@RequestMapping("/sessionMake.do")
	public ModelAndView sessionMake(HttpServletRequest req) {

		HttpSession session=req.getSession();
		session.setAttribute("name", "홍길동");

		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("param/paramOk");
		return mav;
	}
}
