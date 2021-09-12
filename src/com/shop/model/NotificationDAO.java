package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO implements NotificationDAO_interface{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert into shop.notification (title, text, picture, start_time, end_time, create_time) values (?,?,?,?,?,?)";
	private static final String delete = "delete from shop.notification where notification_id = ?";
	private static final String update = "update shop.notification set title = ?, text = ?, picture = ?, start_time = ?, end_time = ?, creat_time = ? where notification_id = ?";
	private static final String getall = "select * from shop.notification";
	private static final String getone = "select * from shop.notification where notification_id = ?";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(NotificationVO notificationvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, notificationvo.getTitle());
			pstmt.setString(2, notificationvo.getText());
			pstmt.setBytes(3, notificationvo.getPicture());
			pstmt.setDate(4, notificationvo.getStart_time());
			pstmt.setDate(5, notificationvo.getEnd_time());
			pstmt.setDate(6, notificationvo.getCreate_time());
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
	public void update(NotificationVO notificationvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, notificationvo.getTitle());
			pstmt.setString(2, notificationvo.getText());
			pstmt.setBytes(3, notificationvo.getPicture());
			pstmt.setDate(4, notificationvo.getStart_time());
			pstmt.setDate(5, notificationvo.getEnd_time());
			pstmt.setDate(6, notificationvo.getCreate_time());
			pstmt.setInt(7, notificationvo.getNotification_id());
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
	public void delete(Integer notification_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, notification_id);
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
	public NotificationVO getone(Integer notification_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		NotificationVO notificationvo = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getone);
			pstmt.setInt(1, notification_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				notificationvo = new NotificationVO();
				notificationvo.setNotification_id(rs.getInt("notification_id"));
				notificationvo.setTitle(rs.getString("title"));
				notificationvo.setText(rs.getString("test"));
				notificationvo.setPicture(rs.getBytes("picture"));
				notificationvo.setStart_time(rs.getDate("start_time"));
				notificationvo.setEnd_time(rs.getDate("end_time"));
				notificationvo.setCreate_time(rs.getDate("create_time"));
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
		return notificationvo;
	}

	@Override
	public List<NotificationVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		NotificationVO notificationvo = null;
		ResultSet rs = null;
		List<NotificationVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(getall);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				notificationvo = new NotificationVO();
				notificationvo.setNotification_id(rs.getInt("notification_id"));
				notificationvo.setTitle(rs.getString("title"));
				notificationvo.setText(rs.getString("text"));
				notificationvo.setPicture(rs.getBytes("picture"));
				notificationvo.setStart_time(rs.getDate("start_time"));
				notificationvo.setEnd_time(rs.getDate("end_time"));
				notificationvo.setCreate_time(rs.getDate("create_time"));
				list.add(notificationvo);
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
