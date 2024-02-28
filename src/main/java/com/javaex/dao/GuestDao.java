package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {

	public void insert(GuestVo gv) {
		// 0. import java.sql.*;

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/guestbook_db";
			conn = DriverManager.getConnection(url, "guest", "guest");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " insert into guest ";
			query += " value(null, ?, ?, ?, date(now())) ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gv.getName());
			pstmt.setString(2, gv.getPassword());
			pstmt.setString(3, gv.getContent());

			pstmt.executeUpdate();

			// 4.결과처리

		} catch (ClassNotFoundException e) {

			System.out.println("error: 드라이버 로딩 실패 - " + e);

		} catch (SQLException e) {

			System.out.println("error:" + e);

		} finally {

			// 5. 자원정리

			try {

				if (rs != null) {

					rs.close();

				}

				if (pstmt != null) {

					pstmt.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (SQLException e) {

				System.out.println("error:" + e);

			}

		}
	}

	public List<GuestVo> List() {
		List<GuestVo> gList = new ArrayList<GuestVo>();
		
		// 0. import java.sql.*;

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/guestbook_db";
			conn = DriverManager.getConnection(url, "guest", "guest");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select	no, ";
			query += " 			name, ";
			query += "          password, ";
			query += "          content, ";
			query += "          reg_date";
			query += " from guest	 ";

			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String content = rs.getString("content");
				String date = rs.getString("reg_date");
				
				GuestVo gv = new GuestVo(no, name, password, content, date);
				
				gList.add(gv);
			}

			// 4.결과처리

		} catch (ClassNotFoundException e) {

			System.out.println("error: 드라이버 로딩 실패 - " + e);

		} catch (SQLException e) {

			System.out.println("error:" + e);

		} finally {

			// 5. 자원정리

			try {

				if (rs != null) {

					rs.close();

				}

				if (pstmt != null) {

					pstmt.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (SQLException e) {

				System.out.println("error:" + e);

			}

		}
		return gList;
	}
	
	public void delete(GuestVo gv) {
		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/guestbook_db";
			conn = DriverManager.getConnection(url, "guest", "guest");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " delete from guest ";
			query += " where 	no = ? ";
			query += " and		password = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gv.getNo());
			pstmt.setString(2, gv.getPassword());

			pstmt.executeUpdate();

			// 4.결과처리

		} catch (ClassNotFoundException e) {

			System.out.println("error: 드라이버 로딩 실패 - " + e);

		} catch (SQLException e) {

			System.out.println("error:" + e);

		} finally {

			// 5. 자원정리

			try {

				if (rs != null) {

					rs.close();

				}

				if (pstmt != null) {

					pstmt.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (SQLException e) {

				System.out.println("error:" + e);

			}

		}
	}
}
