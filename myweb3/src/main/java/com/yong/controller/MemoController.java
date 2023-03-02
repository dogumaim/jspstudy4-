package com.yong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yong.memo.model.MemoDAO;
import com.yong.memo.model.MemoDTO;
import java.util.*;

@Controller
@RequestMapping("/memoWrite.do")
public class MemoController {
	
	@Autowired
	private MemoDAO memoDao;
	
	@RequestMapping(/*value="/memoWrite.do",*/ method = RequestMethod.GET)
	public ModelAndView momoWriteForm() {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("memo/memoWrite");
		return mav;
	}
	@RequestMapping(/*value="/memoWrite.do",*/ method = RequestMethod.POST)
	public ModelAndView memoWriteSubmit(@ModelAttribute("mdto") MemoDTO dto) {
	
		int result=memoDao.memoWrite(dto);
		
		System.out.println("수행한 횟수:"+result);
		System.out.println(dto.toString());
		ModelAndView mav=new ModelAndView();
		mav.setViewName("memo/memoOk");
		
		return mav;
	}

}
