package com.yong.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yong.member.model.MemberDAO;
import com.yong.member.model.MemberDTO;

@Controller
public class MemberController {
	
	/**
	 * 1.db스키마 설계
	 * 2.디자인 설계
	 * 3.DTO & DAO 설계
	 * 4.컨트롤러작성
	 * 4-1.명령어선정
	 * 4-2.커맨드클래스(action)작성
	 * 4-3.등록
	 * */

	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private MemberDAO memberDao;
	
	
	@RequestMapping("/member.do")
	public ModelAndView member() {
		
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("member");
		
		return mav;
		
	
	}
	/*@RequestMapping("/idCheck.do")
	public ModelAndView memberIdCheck() {
		
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("idCheck");
		
		return mav;
	}
	
	@RequestMapping("/idCheck_ok.do")
	public ModelAndView memberIdCheck_ok(String id) {
		
		String msg="";
		String window="";
		
		ModelAndView mav=new ModelAndView();
		
		boolean result=memberDao.idCheck(id);
		
		if(result==true) {
			msg="중복된 아이디입니다";
			window="location.href='/idCheck.do'";
			id="";
		}else {
			msg="중복되지 않은 아이디입니다!";
			window="self.close();";
			
			 
		}
		
		
		mav.addObject("msg", msg);
		mav.addObject("window", window);
		mav.addObject("id", id);
	
		
		//mav.setViewName("idCheck_ok");
		
		return mav;
	}
	*/
	@RequestMapping(value = "/memberMsg.do", method =RequestMethod.POST)
	public ModelAndView memberMsg(MemberDTO dto) {
		
		int result=memberDao.memberInsert(dto);
		
		String msg="";
		String href="";
		
		System.out.println("수행한 횟수"+result);
		System.out.println(dto.toString());
		
		if(result>0) {
			msg="등록 성공!";
			href="/myweb3";
		}else {
			msg="등록 실패!";
			href="/member.do";
		}
		
		ModelAndView mav=new ModelAndView();
		
		
		mav.addObject("msg", msg);
		mav.addObject("href", href);
		mav.setViewName("memberMsg");
		
		return mav;
		
	}
	
	@RequestMapping("/memberList2.do")
	public ModelAndView memberList(
			@RequestParam(value="type", defaultValue = "no")String type,
			@RequestParam(value="fkey", required = false)String fkey,
			@RequestParam(value="fvalue", required = false)String fvalue) {
		
		String id="";
		String name="";
		String pwd="";
		String email="";
		String tel="";
		String addr="";
		int start=0;
		int end=0;
		ArrayList<MemberDTO> arr=memberDao.memberList(type,fkey,fvalue);
		
		for(int i=0;i<arr.size();i++) {
			 id=arr.get(i).getId();
			 name=arr.get(i).getName();
			 pwd=arr.get(i).getPwd();
			 email=arr.get(i).getEmail();
		     tel=arr.get(i).getTel();
			 addr=arr.get(i).getAddr();
			 end=arr.size();
		}
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("arr", arr);
		mav.addObject("id", id);
		mav.addObject("name", name);
		mav.addObject("pwd", pwd);
		mav.addObject("tel", tel);
		mav.addObject("addr", addr);
		mav.addObject("start",start);
		mav.addObject("end", end);
		mav.setViewName("memberList");
		
		return mav;
	}
	@RequestMapping(value="/memberJoin.do", method = RequestMethod.GET)
	public ModelAndView memberJoinFrom() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/join");
		return mav;
	}
	
	/**강시님 시작*/
	@RequestMapping(value="/memberJoin.do",method = RequestMethod.POST)
	public ModelAndView memberJoinsubmit(MemberDTO dto) {
		
		int result=memberDao.memberJoin(dto);
		
		String msg=result>0?"회원가입을 축하합니다(spring)":"회원가입에 실패했습니다(spring)";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "/myweb3/index.do");
		mav.setViewName("member/memberMsg");
		
		return mav;
		
	}
	@RequestMapping("/idCheckForm.do")
	public ModelAndView idCheckForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/idCheck");
		return mav;
	}
	@RequestMapping("/idCheck.do")
	public ModelAndView idCheckSubmit(MemberDTO dto) {
		
		boolean result=memberDao.idCheck2(dto.getId());
		
		ModelAndView mav=new ModelAndView();
		
		if(result) {
			mav.addObject("msg", dto.getId()+"는 이미 가입되어있는 ID입니다.");
			mav.addObject("goUrl", "idCheckForm.do");
			mav.setViewName("member/memberMsg");
		}else {
			mav.addObject("userid", dto.getId());
			mav.addObject("msg", dto.getId()+"는 사용가능한 아이디입니다");
			mav.setViewName("member/idCheck_ok");
		}
		return mav;
		
	}
	@RequestMapping("/memberList.do")
	public ModelAndView memberList2() {
		ArrayList<MemberDTO> arr=memberDao.memberList2();
		ModelAndView mav=new ModelAndView();
		mav.addObject("arr", arr);
		mav.setViewName("member/memberList");
		return mav;
	}
	@RequestMapping("/loginForm2.do")
	public ModelAndView loginForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/login");
		
		return mav;
	}
	@RequestMapping("/login2.do")
	public ModelAndView loginSubmit(
			@RequestParam("userid")String userid,
			@RequestParam("userpwd")String userpwd,
			@RequestParam(value="saveid" , required =  false)String saveid,
			HttpSession session,
			HttpServletResponse resp) {
		
		int result=memberDao.loginCheck(userid, userpwd);
		
		
		
		ModelAndView mav=new ModelAndView();
		
		if(result==memberDao.LOGIN_OK) {
			String username= memberDao.getUserInfo(userid);
			
			session.setAttribute("sid", userid);
			session.setAttribute("sname", username);
			/////////////////////////////////////////////////////////////
			if(saveid==null) {
				Cookie ck=new Cookie("saveid", userid);
				ck.setMaxAge(0);
				resp.addCookie(ck);
			}else {
				Cookie ck=new Cookie("saveid", userid);
				ck.setMaxAge(60*60*24*30);
				resp.addCookie(ck);
			}
			
			//////////////////////////////////////////////////////////////
			mav.addObject("msg", username+"님 환영합니다" );
			mav.setViewName("member/login_ok");
		}else if(result==memberDao.NOT_ID || result==memberDao.NOT_PWD) {
			mav.addObject("msg", "ID 또는 비밀번호가 잘못되었습니다");
			mav.addObject("goUrl", "loginForm.do");
			mav.setViewName("member/memberMsg");
			
			
			
		}
		return mav;
	}
	@RequestMapping("/logout2.do")
	public ModelAndView logoutSubmit(HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		session.invalidate();
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "로그아웃되었습니다.");
		mav.addObject("goUrl","index.do");
		mav.setViewName("member/memberMsg");
		return mav;
		
		
	}
	@RequestMapping("/search.do")
	public ModelAndView searchList(MemberDTO dto,
			@RequestParam(value = "search", required =  false)String  search,
			@RequestParam(value = "searchtext", required = false)String searchtext){
		
			ArrayList<MemberDTO> arr=memberDao.searchListId(search,searchtext);
			
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("arr", arr);
		mav.setViewName("member/memberList");
		return mav;
	}
}
