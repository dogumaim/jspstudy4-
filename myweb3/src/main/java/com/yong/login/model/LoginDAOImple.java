package com.yong.login.model;

import java.sql.*;


public class LoginDAOImple implements LoginDAO {
	
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	public static final int NOT_ID=1;
	public static final int NOT_PWD=2;
	public static final int LOGIN_OK=3;
	public static final int ERROR=-1;
	
	
	public LoginDAOImple() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int useridSubmit(String id, String pwd) {
		try {
			conn=com.yong.db.YongDB.getConn();
			String sql="select pwd from jsp_member where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String db_pwd=rs.getString("pwd");
				if(db_pwd.equals(pwd)) {
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
	

}
