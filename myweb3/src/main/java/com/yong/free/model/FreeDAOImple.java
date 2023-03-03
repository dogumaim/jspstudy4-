package com.yong.free.model;

import java.sql.*;
import java.util.ArrayList;

public class FreeDAOImple implements FreeDAO {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public ArrayList<FreeDTO> freeList() {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "select * from jsp_bbs order by idx desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<FreeDTO> arr = new ArrayList<FreeDTO>();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String writer = rs.getString("writer");
				String pwd = rs.getString("pwd");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				java.sql.Date writedate = rs.getDate("writedate");
				int readnum = rs.getInt("readnum");
				int ref = rs.getInt("ref");
				int lev = rs.getInt("lev");
				int sunbun = rs.getInt("sunbun");

				FreeDTO dto = new FreeDTO(idx, writer, pwd, subject, content, writedate, readnum, ref, lev, sunbun);

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
	public int freeWrite(FreeDTO dto) {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "insert into jsp_bbs values(jsp_bbs_idx.nextval,?,?,?,?,sysdate,0,0,0,0)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getContent());
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

}
