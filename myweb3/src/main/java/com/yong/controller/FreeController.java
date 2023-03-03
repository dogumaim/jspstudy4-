package com.yong.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yong.free.model.FreeDAO;
import com.yong.free.model.FreeDTO;

@Controller
public class FreeController {

	@Autowired
	FreeDAO freeDao;
	
	@RequestMapping("/freeList.do")
	public ModelAndView freeList() {
		
		ArrayList<FreeDTO> arr=freeDao.freeList();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("arr", arr);
		mav.setViewName("free/freeList");
		
		return mav; 
	}
	
	@RequestMapping("/freeInsertView.do")
	public String freeInsertView() {
		
		return "free/freeInsertView";
	}
	@RequestMapping(value = "/freeInsert.do", method = RequestMethod.POST)
	public ModelAndView freeInsert(FreeDTO dto) {
		
		ModelAndView mav=new ModelAndView();
		
		int result=freeDao.freeWrite(dto);
		
		if(result>0) {
			
			mav.addObject("msg", "글작성에성공했습니다");
			mav.addObject("result", result);
			mav.addObject("goUrl", "freeList.do");
			mav.setViewName("free/freeOk");
		}else {
			mav.addObject("msg", "글 작성에 실패했습니다");
			mav.addObject("goUrl", "myweb3/index.do");
			mav.setViewName("member/memberMsg");
		}
		
	
		return mav;
		
		
		
	}
}
