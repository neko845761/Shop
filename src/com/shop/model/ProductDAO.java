package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ProductDAO_interface{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert into shop.product (name, description, picture, price, stock) values (?,?,?,?,?)";
	private static final String delete = "delete from shop.product where product_id = ?";
	private static final String update = "update shop.product set name = ?, description = ?, picture = ?, price = ?, stock = ? where product_id = ?";
	private static final String getall = "select * from shop.product";
	private static final String getone = "select * from shop.product where product_id = ?";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(ProductVO productvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, productvo.getName());
			pstmt.setString(2, productvo.getDescription());
			pstmt.setBytes(3, productvo.getPicture());
			pstmt.setDouble(4, productvo.getPrice());
			pstmt.setInt(5, productvo.getStock());
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
	public void update(ProductVO productvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, productvo.getName());
			pstmt.setString(2, productvo.getDescription());
			pstmt.setBytes(3, productvo.getPicture());
			pstmt.setDouble(4, productvo.getPrice());
			pstmt.setInt(5, productvo.getStock());
			pstmt.setInt(6, productvo.getProduct_id());
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
	public void delete(Integer product_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, product_id);
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
	public ProductVO getone(Integer product_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ProductVO productvo = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getone);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productvo = new ProductVO();
				productvo.setProduct_id(rs.getInt("product_id"));
				productvo.setName(rs.getString("name"));
				productvo.setDescription(rs.getString("description"));
				productvo.setPicture(rs.getBytes("picture"));
				productvo.setPrice(rs.getDouble("price"));
				productvo.setStock(rs.getInt("stock"));
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
		return productvo;
	}

	@Override
	public List<ProductVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ProductVO productvo = null;
		ResultSet rs = null;
		List<ProductVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getall);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productvo = new ProductVO();
				productvo.setProduct_id(rs.getInt("product_id"));
				productvo.setName(rs.getString("name"));
				productvo.setDescription(rs.getString("description"));
				productvo.setPicture(rs.getBytes("picture"));
				productvo.setPrice(rs.getDouble("price"));
				productvo.setStock(rs.getInt("stock"));
				list.add(productvo);
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
