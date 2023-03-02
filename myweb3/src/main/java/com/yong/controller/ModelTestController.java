package com.yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@Controller
public class ModelTestController {

	@RequestMapping("/modelTest1.do")
	public String modelTest1(Map model) {
		
		model.put("result", "Map을 매개변수로 선언한 모델 전달방식~");
		
		return "model/modelOk";
	}
	
	@RequestMapping("/modelTest2.do")
	public String modelTest2(Model model ) {
		
		model.addAttribute("result", "Model을 매개변수로 선언한 모델 전달방식~");
		
		return "model/modelOk";
	}
	
	@RequestMapping("/modelTest3.do")
	public String modelTest3(ModelMap model) {
		
		model.addAttribute("result", "ModelMap을 매개변수로 선언한 모델 전달방식");
		
		return "model/modelOk";
	}
	
//	@RequestMapping("/model/modelOk.do")
//	public Map modelTest4() {
//		
//		Map model=new HashMap();
//		
//		model.put("result", "Map객체를 반환하여 데이터 전달");
//		
//		return model;
//		
//	}
	
	@RequestMapping("/model/modelOk.do")
	public Model modelTest5() { //
		
		Model model=new ExtendedModelMap();
		
		model.addAttribute("result", "Model객체를 반환하여 데이터 전달~");
		
		return model;
	}
	
}
