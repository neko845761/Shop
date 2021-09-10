package com.shop.comdel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Relation_order_productDAO implements Relation_order_productDAO_interface {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert into shop.relation_order_product (product_id, quantity, price) values (?,?,?)";
	private static final String delete = "delete from shop.relation_order_product where order_id = ?";
	private static final String update = "update shop.relation_order_product set product_id = ?, quantity = ?, price = ? where order_id = ?";
	private static final String getall = "select * from shop.relation_order_product";
	private static final String getone = "select * from shop.relation_order_product where order_id = ?";

	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Relation_order_productVO relation_order_productvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, relation_order_productvo.getProduct_id());
			pstmt.setInt(2, relation_order_productvo.getQuantity());
			pstmt.setDouble(3, relation_order_productvo.getPrice());
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
	public void update(Relation_order_productVO relation_order_productvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(update);
			pstmt.setInt(1, relation_order_productvo.getProduct_id());
			pstmt.setInt(2, relation_order_productvo.getQuantity());
			pstmt.setDouble(3, relation_order_productvo.getPrice());
			pstmt.setInt(4, relation_order_productvo.getOrder_id());
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
	public void delete(Integer order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, order_id);
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
	public Relation_order_productVO getone(Integer order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Relation_order_productVO relation_order_productvo = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getone);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				relation_order_productvo = new Relation_order_productVO();
				relation_order_productvo.setOrder_id(rs.getInt("order_id"));
				relation_order_productvo.setProduct_id(rs.getInt("product_id"));
				relation_order_productvo.setQuantity(rs.getInt("quantity"));
				relation_order_productvo.setPrice(rs.getDouble("price"));
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
		return relation_order_productvo;
	}

	@Override
	public List<Relation_order_productVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		Relation_order_productVO relation_order_productvo = null;
		ResultSet rs = null;
		List<Relation_order_productVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getall);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				relation_order_productvo = new Relation_order_productVO();
				relation_order_productvo.setOrder_id(rs.getInt("order_id"));
				relation_order_productvo.setProduct_id(rs.getInt("product_id"));
				relation_order_productvo.setQuantity(rs.getInt("quantity"));
				relation_order_productvo.setPrice(rs.getDouble("price"));
				list.add(relation_order_productvo);
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
