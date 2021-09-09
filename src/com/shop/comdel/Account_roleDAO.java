package com.shop.comdel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Account_roleDAO implements Account_roleDAO_interface{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "inset into shop.account_role (name, description, creat_time, status) values(?,?,?,?)";
	private static final String delete = "delete from shop.account_role where role_id= ?";
	private static final String update = "update shop.account_role set name = ?, description = ?, creat_time = ?, status = ? where role_id = ?";
	private static final String getall = "select * from shop.account_role";
	private static final String getone = "select * from shop.account_role where role_id = ?";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Account_roleVO account_rolevo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, account_rolevo.getName());
			pstmt.setString(2, account_rolevo.getDescription());
			pstmt.setDate(3, account_rolevo.getCreat_time());
			pstmt.setInt(4, account_rolevo.getStatus());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(Integer role_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, role_id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Account_roleVO account_rolevo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, account_rolevo.getName());
			pstmt.setString(2, account_rolevo.getDescription());
			pstmt.setDate(3, account_rolevo.getCreat_time());
			pstmt.setInt(4, account_rolevo.getStatus());
			pstmt.setInt(5, account_rolevo.getRole_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Account_roleVO getone(Integer role_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account_roleVO account_rolevo = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getone);
			pstmt.setInt(1, role_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				account_rolevo = new Account_roleVO();
				account_rolevo.setRole_id(rs.getInt("role_id"));
				account_rolevo.setName(rs.getString("name"));
				account_rolevo.setDescription(rs.getString("description"));
				account_rolevo.setCreat_time(rs.getDate("creat_time"));
				account_rolevo.setStatus(rs.getInt("status"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return account_rolevo;
	}

	@Override
	public List<Account_roleVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account_roleVO account_rolevo = null;
		List<Account_roleVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getall);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				account_rolevo = new Account_roleVO();
				account_rolevo.setRole_id(rs.getInt("role_id"));
				account_rolevo.setName(rs.getString("name"));
				account_rolevo.setDescription(rs.getString("description"));
				account_rolevo.setCreat_time(rs.getDate("creat_time"));
				account_rolevo.setStatus(rs.getInt("status"));
				list.add(account_rolevo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
}
