package com.yong.member.model;

import java.sql.*;
import java.util.*;

public class MemberDAOImple implements MemberDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public MemberDAOImple() {

	}

	@Override
	public int memberInsert(MemberDTO dto) {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "insert into jsp_member values(jsp_member_idx.nextval,?,?,?,?,?,?,sysdate)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPwd());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getAddr());
			int count = ps.executeUpdate();

			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public boolean idCheck(String id) {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "select id from jsp_member where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public ArrayList<MemberDTO> memberList(String type, String fkey, String fvalue) {
		try {
			conn = com.yong.db.YongDB.getConn();
			if(type.equals("yes")) {
				String c=fkey.equals("1")?"id":"name";
				String sql="select * from jsp_member where "+c+"=? order by idx desc";
				ps=conn.prepareStatement(sql);
				ps.setString(1, fvalue);
			}else {
				String sql = "select * from jsp_member order by idx asc";
				ps=conn.prepareStatement(sql);
			}
		
			rs = ps.executeQuery();
			MemberDTO dto = null;
			ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				java.sql.Date joindate = rs.getDate("joindate");

				dto = new MemberDTO(idx, id, name, pwd, email, tel, addr, joindate);

				arr.add(dto);
			}
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public int memberJoin(MemberDTO dto) {
		

		try {
			conn=com.yong.db.YongDB.getConn();
			String sql="insert into jsp_member values(jsp_member_idx.nextval,?,?,?,?,?,?,sysdate)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPwd());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getAddr());
			int count=ps.executeUpdate();
			return count;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {}
		}
	}
	@Override
	public boolean idCheck2(String userid) {
		try {
			conn=com.yong.db.YongDB.getConn();
			String sql="select id from jsp_member where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs=ps.executeQuery();
			
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {}
		}
	}
	@Override
	public ArrayList<MemberDTO> memberList2() {
		try {
			conn=com.yong.db.YongDB.getConn();
			String sql="select * from jsp_member order by idx desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			ArrayList<MemberDTO> arr=new ArrayList<MemberDTO>();
			while(rs.next()) {
				int idx=rs.getInt("idx");
				String id=rs.getString("id");
				String name=rs.getString("name");
				String pwd=rs.getString("pwd");
				String email=rs.getString("email");
				String tel=rs.getString("tel");
				String addr=rs.getString("addr");
				java.sql.Date joindate=rs.getDate("joindate");
				
				MemberDTO dto=new MemberDTO(idx, id, name, pwd, email, tel, addr, joindate);
				
				arr.add(dto);

			}
			return arr;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {}
		}
	}
	
	@Override
	public String getUserInfo(String id) {
		try {
			conn=com.yong.db.YongDB.getConn();
			String sql="select name from jsp_member where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			rs.next();
			String name=rs.getString(1);
			return name;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {}
		}
	}
	
	@Override
	public int loginCheck(String userid, String userpwd) {
		try {
			conn=com.yong.db.YongDB.getConn();
			String sql="select pwd from jsp_member where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String dbpwd=rs.getString("pwd");
				if(dbpwd.equals(userpwd)) {
					return LOGIN_OK;
				}else {
					return NOT_PWD;
				}
			}else {
				return NOT_ID;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {}
		}
	}
		@Override
		public ArrayList<MemberDTO> searchListId(String number, String text) {
			try {
				conn=com.yong.db.YongDB.getConn();
				String sql="";	
				switch(number) {
				case "1":sql="select * from jsp_member where id=? order by idx desc";
					break;
				case "2":sql="select * from jsp_member where name=? order by idx desc";
				}
				ps=conn.prepareStatement(sql);
				ps.setString(1, text);
				rs=ps.executeQuery();
				ArrayList<MemberDTO> arr=new ArrayList<MemberDTO>();
				while(rs.next()) {
				int idx=rs.getInt("idx");
				String id=rs.getString("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				java.sql.Date joindate=rs.getDate("joindate");
				
				MemberDTO dto=new MemberDTO(idx, id, name, sql, email, name, email, joindate);
				
				arr.add(dto);
				
			}
			
				return arr;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {}
		}
	}
	@Override
	public ArrayList<MemberDTO> searchListName(String name) {
		try {
			conn=com.yong.db.YongDB.getConn();
			String sql="select * from jsp_member where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			ArrayList<MemberDTO> arr=new ArrayList<MemberDTO>();
			while(rs.next()) {
				int idx=rs.getInt("idx");
				String id=rs.getString("id");
				String email=rs.getString("email");
				java.sql.Date joindate=rs.getDate("joindate");
				
				MemberDTO dto=new MemberDTO(idx, id, name, sql, email, name, email, joindate);
				
				arr.add(dto);
				
			}
			
				return arr;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {}
		}
		
	}
	
}
