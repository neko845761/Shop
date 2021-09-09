package com.shop.comdel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Account_permissionDAO implements Account_permissionDAO_interface{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert into shop.account_permission (name, status, creat_time) values (?,?,?)";
	private static final String delete = "delete from shop.account_permission where permission_id = ?";
	private static final String update = "update shop.account_permission set name= ?, status= ?, creat_time = ? where permission_id = ?";
	private static final String getall = "select * from shop.account_permission";
	private static final String getone = "select * from shop.account_permission where permission_id = ?";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Account_permissionVO account_permissionvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, account_permissionvo.getName());
			pstmt.setInt(2, account_permissionvo.getStatus());
			pstmt.setDate(3, account_permissionvo.getCreat_time());
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
	public void delete(Integer permission_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, permission_id);
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
	public void update(Account_permissionVO account_permissionvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, account_permissionvo.getName());
			pstmt.setInt(2, account_permissionvo.getStatus());
			pstmt.setDate(3, account_permissionvo.getCreat_time());
			pstmt.setInt(4, account_permissionvo.getPermission_id());
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
	public Account_permissionVO getone(Integer permission_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Account_permissionVO account_permissionvo = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(getone);
			pstmt.setInt(1, permission_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				account_permissionvo = new Account_permissionVO();
				account_permissionvo.setPermission_id(rs.getInt("permission_id"));
				account_permissionvo.setName(rs.getString("name"));
				account_permissionvo.setStatus(rs.getInt("status"));
				account_permissionvo.setCreat_time(rs.getDate("creat_time"));
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
		return account_permissionvo;
	}

	@Override
	public List<Account_permissionVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		Account_permissionVO account_permissionvo = null;
		ResultSet rs = null;
		List<Account_permissionVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(getall);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				account_permissionvo = new Account_permissionVO();
				account_permissionvo.setPermission_id(rs.getInt("permission_id"));
				account_permissionvo.setName(rs.getString("name"));
				account_permissionvo.setStatus(rs.getInt("status"));
				account_permissionvo.setCreat_time(rs.getDate("creat_time"));
				list.add(account_permissionvo);
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
