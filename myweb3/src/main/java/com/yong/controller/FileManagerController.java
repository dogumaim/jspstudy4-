package com.yong.controller;

import java.io.*;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.yong.file.model.FileDTO;

@Controller
public class FileManagerController {

	
	@RequestMapping("/fileUploadForm.do")
	public String fileUploadForm() {
		return "file/fileUpload";
	}
	
	@RequestMapping("/fileUpload1.do")
	public String fileUpload1(
			@RequestParam("writer")String writer,
			@RequestParam("upload")MultipartFile upload) {
		
		System.out.println("작성자:"+writer);
		System.out.println("파일명:"+upload.getOriginalFilename());
		
		
		copyInto(writer, upload);
		
		return "file/fileOk";
	}
	@RequestMapping("/fileUpload2.do")
	public String fileUpload2(MultipartHttpServletRequest req) {
		
		String writer=req.getParameter("writer");
		MultipartFile upload=req.getFile("upload");
		
		copyInto(writer, upload);
		
		return "file/fileOk";
	}
	
	@RequestMapping("/fileUpload3.do")
	public String fileUpload3(FileDTO dto) {
		
		copyInto(dto.getWriter(), dto.getUpload());
		
		return "file/fileOk";
	}
	
	@RequestMapping("/fileUpload4.do")
	public String fileUpload4(
			@RequestParam("writer")String writer,
			@RequestParam("upload")List<MultipartFile> upload) {
		

		
		for(int i=0;i<upload.size();i++) { 
		
			copyInto(writer, upload.get(i));
		}
		
		return "file/fileOk";
	}
	
	/**파일복사관련메서드*/
	public void copyInto(String writer, MultipartFile upload) {
		
		System.out.println("작성자:"+writer);
		System.out.println("파일명:"+upload.getOriginalFilename());
		
		try {
			byte bytes[]=upload.getBytes(); //원본가져오기
			//용지
			File outfile=new File("c:/student_java/upload/"+upload.getOriginalFilename());
			
			FileOutputStream fos=new FileOutputStream(outfile);
			fos.write(bytes);//복사
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/fileDownList.do")
	public ModelAndView fileList(FileDTO dto) {
		
		File f=new File("c:/student_java/upload");
		File files[]=f.listFiles();
		
		ModelAndView mav=new ModelAndView();	
		mav.addObject("files", files);
		
		mav.setViewName("file/fileList");
		
		return mav;
	}
	
	@RequestMapping("/fileDown.do")
	public ModelAndView filedown(@RequestParam("filename")String filename) {
		
		
		File f=new File("c:/student_java/upload/"+filename);
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("downloadFile", f);
		mav.setViewName("yongDown");
		
		return mav; 
	}
}
