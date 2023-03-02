package com.yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnimeController {

	@ModelAttribute("keywords")
	public String[] getKeywords() {
		String keywords[]= {"아기공룡 둘리","검정 고무신","명탐정 코난","슬램 덩크","심슨","원피스"};
		return keywords;
	}
	@ModelAttribute("cate")
	public String[] getCategory() {
		String category[]= {"한국","미국","일본"};
		return category;
	}
	
	
	@RequestMapping("/aniFindA.do")
	public ModelAndView aniFindA() {
	
		
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("anime/animeA");
		return mav;
	}
	@RequestMapping("/aniFindB.do")
	public String aniFindB(Model model) {
		
		return "anime/animeB";
	}
}
