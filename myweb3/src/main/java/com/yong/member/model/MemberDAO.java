package com.yong.member.model;

import java.util.ArrayList;

public interface MemberDAO {

	int NOT_ID=1;
	int NOT_PWD=2;
	int LOGIN_OK=3;
	int ERROR=-1;
	
	
	public int memberInsert(MemberDTO dto);
	
	public boolean idCheck(String id);
	
	public ArrayList<MemberDTO> memberList(String type,String fkey, String fvalue);
	
	public int memberJoin(MemberDTO dto);
	
	public boolean idCheck2(String userid);
	
	public ArrayList<MemberDTO> memberList2();
	
	public int loginCheck(String userid, String userpwd);
	public String getUserInfo(String id);
	
	public ArrayList<MemberDTO> searchListId(String number, String text);
	
	public  ArrayList<MemberDTO> searchListName(String name);
}


