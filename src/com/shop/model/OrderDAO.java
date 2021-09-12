package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements OrderDAO_interface{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert into shop.order (user_id, total_price, creat_time, address) values (?,?,?,?)";
	private static final String delete = "delete from shop.order where order_id = ?";
	private static final String update = "update shop.order set user_id= ?, total_price= ?, creat_time = ?, address = ? where order_id = ?";
	private static final String getall = "select * from shop.order";
	private static final String getone = "select * from shop.order where order_id = ?";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(OrderVO ordervo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, ordervo.getUser_id());
			pstmt.setDouble(2, ordervo.getTotal_price());
			pstmt.setDate(3, ordervo.getCreat_time());
			pstmt.setString(4, ordervo.getAddress());
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
	public void update(OrderVO ordervo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, ordervo.getUser_id());
			pstmt.setDouble(2, ordervo.getTotal_price());
			pstmt.setDate(3, ordervo.getCreat_time());
			pstmt.setString(4, ordervo.getAddress());
			pstmt.setInt(5, ordervo.getOrder_id());
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
	public OrderVO getone(Integer order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVO ordervo = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ordervo = new OrderVO();
				ordervo.setOrder_id(rs.getInt("order_id"));
				ordervo.setUser_id(rs.getString("user_id"));
				ordervo.setTotal_price(rs.getDouble("total_price"));
				ordervo.setCreat_time(rs.getDate("creat_time"));
				ordervo.setAddress(rs.getString("address"));
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
		return ordervo;
	}

	@Override
	public List<OrderVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVO ordervo = null;
		List<OrderVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(delete);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ordervo = new OrderVO();
				ordervo.setOrder_id(rs.getInt("order_id"));
				ordervo.setUser_id(rs.getString("user_id"));
				ordervo.setTotal_price(rs.getDouble("total_price"));
				ordervo.setCreat_time(rs.getDate("creat_time"));
				ordervo.setAddress(rs.getString("address"));
				list.add(ordervo);
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
