package com.shop.comdel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Account_adminDAO implements Account_adminDAO_interface{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert inte shop.account_admin (user_account, user_password, email, note, status, creat_time, login_time) values (?,?,?,?,?,?,?)";
	private static final String delete = "delete from shop.account_admin where user_id= ?";
	private static final String update = "update shop.account_admin set user_account = ?, user_password = ?, email = ?, note = ?, status = ?, creat_time = ?, login_time = ? where user_id = ?";
	private static final String getall = "select * from shop.account_admin";
	private static final String getone = "select * from shop.account_admin where user_id = ?";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Account_adminVO account_adminvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, account_adminvo.getUser_account());
			pstmt.setString(2, account_adminvo.getUser_password());
			pstmt.setString(3, account_adminvo.getEmail());
			pstmt.setString(4, account_adminvo.getNote());
			pstmt.setInt(5, account_adminvo.getStatus());
			pstmt.setDate(6, account_adminvo.getCreat_time());
			pstmt.setDate(7, account_adminvo.getLogin_time());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(String user_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Account_adminVO account_adminvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, account_adminvo.getUser_account());
			pstmt.setString(2, account_adminvo.getUser_password());
			pstmt.setString(3, account_adminvo.getEmail());
			pstmt.setString(4, account_adminvo.getNote());
			pstmt.setInt(5, account_adminvo.getStatus());
			pstmt.setDate(6, account_adminvo.getCreat_time());
			pstmt.setDate(7, account_adminvo.getLogin_time());
			pstmt.setString(8, account_adminvo.getUser_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Account_adminVO getone(String user_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Account_adminVO account_adminvo = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(getone);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				account_adminvo = new Account_adminVO();
				account_adminvo.setUser_id(rs.getString("user_id"));
				account_adminvo.setUser_account(rs.getString("user_account"));
				account_adminvo.setUser_password(rs.getString("user_password"));
				account_adminvo.setEmail(rs.getString("email"));
				account_adminvo.setNote(rs.getString("note"));
				account_adminvo.setStatus(rs.getInt("status"));
				account_adminvo.setCreat_time(rs.getDate("creat_time"));
				account_adminvo.setLogin_time(rs.getDate("login_time"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return account_adminvo;
	}

	@Override
	public List<Account_adminVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		Account_adminVO account_adminvo = null;
		ResultSet rs = null;
		List<Account_adminVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(getall);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				account_adminvo = new Account_adminVO();
				account_adminvo.setUser_id(rs.getString("user_id"));
				account_adminvo.setUser_account(rs.getString("user_account"));
				account_adminvo.setUser_password(rs.getString("user_password"));
				account_adminvo.setEmail(rs.getString("email"));
				account_adminvo.setNote(rs.getString("note"));
				account_adminvo.setStatus(rs.getInt("status"));
				account_adminvo.setCreat_time(rs.getDate("creat_time"));
				account_adminvo.setLogin_time(rs.getDate("login_time"));
				list.add(account_adminvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
}
