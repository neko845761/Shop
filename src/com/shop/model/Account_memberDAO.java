package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Account_memberDAO implements Account_memberDAO_interface{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert inte shop.account_member (user_account, user_password, gender, birth_day, address, status, email, note, , creat_time, login_time) values (?,?,?,?,?,?,?,?,?,?)";
	private static final String delete = "delete from shop.account_member where user_id= ?";
	private static final String update = "update shop.account_member set user_account = ?, user_password = ?, gender = ?, birth_day = ?, address = ?, status = ?, email = ?, note = ?, creat_time = ?, login_time = ? where user_id = ?";
	private static final String getall = "select * from shop.account_member";
	private static final String getone = "select * from shop.account_member where user_id = ?";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Account_memberVO account_membervo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, account_membervo.getUser_account());
			pstmt.setString(2, account_membervo.getUser_password());
			pstmt.setInt(3, account_membervo.getGender());
			pstmt.setDate(4, account_membervo.getBirth_day());
			pstmt.setString(5, account_membervo.getAddress());
			pstmt.setInt(6, account_membervo.getStatus());
			pstmt.setString(7, account_membervo.getEmail());
			pstmt.setString(8, account_membervo.getNote());
			pstmt.setDate(9, account_membervo.getCreat_time());
			pstmt.setDate(10, account_membervo.getLogin_time());
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
	public void update(Account_memberVO account_membervo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, account_membervo.getUser_account());
			pstmt.setString(2, account_membervo.getUser_password());
			pstmt.setInt(3, account_membervo.getGender());
			pstmt.setDate(4, account_membervo.getBirth_day());
			pstmt.setString(5, account_membervo.getAddress());
			pstmt.setInt(6, account_membervo.getStatus());
			pstmt.setString(7, account_membervo.getEmail());
			pstmt.setString(8, account_membervo.getNote());
			pstmt.setDate(9, account_membervo.getCreat_time());
			pstmt.setDate(10, account_membervo.getLogin_time());
			pstmt.setString(11, account_membervo.getUser_id());
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
	public Account_memberVO getone(String user_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Account_memberVO account_membervo = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			account_membervo = new Account_memberVO();	
			account_membervo.setUser_id(rs.getString("user_id"));
			account_membervo.setUser_account(rs.getString("user_account"));
			account_membervo.setUser_password(rs.getString("user_password"));
			account_membervo.setGender(rs.getInt("gender"));
			account_membervo.setBirth_day(rs.getDate("birth_day"));
			account_membervo.setAddress(rs.getString("address"));
			account_membervo.setStatus(rs.getInt("status"));
			account_membervo.setEmail(rs.getString("email"));
			account_membervo.setNote(rs.getString("note"));
			account_membervo.setCreat_time(rs.getDate("creat_time"));
			account_membervo.setLogin_time(rs.getDate("login_time"));
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
		return account_membervo;
	}

	@Override
	public List<Account_memberVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		Account_memberVO account_membervo = null;
		ResultSet rs = null;
		List<Account_memberVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(update);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			account_membervo = new Account_memberVO();	
			account_membervo.setUser_id(rs.getString("user_id"));
			account_membervo.setUser_account(rs.getString("user_account"));
			account_membervo.setUser_password(rs.getString("user_password"));
			account_membervo.setGender(rs.getInt("gender"));
			account_membervo.setBirth_day(rs.getDate("birth_day"));
			account_membervo.setAddress(rs.getString("address"));
			account_membervo.setStatus(rs.getInt("status"));
			account_membervo.setEmail(rs.getString("email"));
			account_membervo.setNote(rs.getString("note"));
			account_membervo.setCreat_time(rs.getDate("creat_time"));
			account_membervo.setLogin_time(rs.getDate("login_time"));
			list.add(account_membervo);
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
