package com.yong.controller;

import java.sql.*;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yong.login.model.*;

@Controller
public class LoginController {

	
	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private LoginDAO loginDao;

	
	@RequestMapping("/login.do")
	public ModelAndView loginOpen(@CookieValue(value= "saveid", required =  false, defaultValue = "")String saveid,
			HttpServletRequest req) {
		
		System.out.println("saveid="+saveid);
	
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("saveid", saveid);
		mav.setViewName("/login/login");
		
		return mav;
	}	
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public ModelAndView loginForm(LoginDTO dto,
			HttpServletResponse res, 
			HttpServletRequest req , 
			@RequestParam(value = "checkbox", required = false, defaultValue = "no" )String  checkbox) {		
	
		HttpSession session=req.getSession();
			
		String msg="";
		ModelAndView mav=new ModelAndView();
		
		if(checkbox.equals("on")) {
			Cookie ck=new Cookie("saveid",dto.getId());
			ck.setMaxAge(60*30);
			res.addCookie(ck);
		}
		
		int result=loginDao.useridSubmit(dto.getId(), dto.getPwd());
		
		if(result==-1 || result== 1 || result == 2) {
			msg="아이디 도는 비밀번호를 잘못 입력하였습니다";
			mav.addObject("msg", msg);
			mav.addObject("goUrl", "login.do");
			
		}else {
			msg=dto.getId()+"님 환영합니다!";
			mav.addObject("msg", msg);
			session.setAttribute("userid", dto.getId());
			session.setAttribute("checkbox", checkbox);
			mav.setViewName("/login/login_ok");
		}
		
		
		
		
		return mav;
	}
	
//	@RequestMapping("/logout.do")
//	public ModelAndView logout(HttpServletRequest req) {
//		
//		
//		HttpSession session=req.getSession();
//
//		ModelAndView mav=new ModelAndView();
//		
//		
//		session.invalidate();
//		mav.addObject("goUrl", "index.do");
//		mav.setViewName("/login/logout");
//		
//		return mav;
//		
//	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		
		session.invalidate();
		
		return "redirect:/index.do";
	}
}
