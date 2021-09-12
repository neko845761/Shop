package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Relation_admin_roleDAO implements Relation_admin_roleDAO_interface{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert into shop.relation_admin_role (user_id, role_id) values (?,?)";
	private static final String delete = "delete from shop.relation_admin_role where relation_id = ?";
	private static final String update = "update shop.relation_admin_role set user_id = ?, role_id = ? where relation_id = ?";
	private static final String getall = "select * from shop.relation_admin_role";
	private static final String getone = "select * from shop.relation_admin_role where relation_id = ?";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Relation_admin_roleVO relation_admin_rolevo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, relation_admin_rolevo.getUser_id());
			pstmt.setInt(2, relation_admin_rolevo.getRole_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
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
	public void update(Relation_admin_roleVO relation_admin_rolevo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(update);
			pstmt.setInt(1, relation_admin_rolevo.getUser_id());
			pstmt.setInt(2, relation_admin_rolevo.getRole_id());
			pstmt.setInt(3, relation_admin_rolevo.getRelation_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
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
	public void delete(Integer relation_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, relation_id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
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
	public Relation_admin_roleVO getone(Integer relation_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Relation_admin_roleVO relation_admin_rolevo = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getone);
			pstmt.setInt(1, relation_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				relation_admin_rolevo = new Relation_admin_roleVO();
				relation_admin_rolevo.setRelation_id(rs.getInt("relation_id"));
				relation_admin_rolevo.setUser_id(rs.getInt("user_id"));
				relation_admin_rolevo.setRole_id(rs.getInt("role_id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
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
		return relation_admin_rolevo;
	}

	@Override
	public List<Relation_admin_roleVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		Relation_admin_roleVO relation_admin_rolevo = null;
		ResultSet rs = null;
		List<Relation_admin_roleVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getone);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				relation_admin_rolevo = new Relation_admin_roleVO();
				relation_admin_rolevo.setRelation_id(rs.getInt("relation_id"));
				relation_admin_rolevo.setUser_id(rs.getInt("user_id"));
				relation_admin_rolevo.setRole_id(rs.getInt("role_id"));
				list.add(relation_admin_rolevo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
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
