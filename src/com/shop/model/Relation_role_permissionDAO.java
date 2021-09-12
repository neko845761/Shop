package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Relation_role_permissionDAO implements Relation_role_permissionDAO_interface {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://139.162.12.62:3306/shop?serverTimezone=Asia/Taipei";
	private static final String user = "test";
	private static final String password = "123";
	private static final String insert = "insert into shop.relation_role_permission (order_id, permission_id) values (?,?)";
	private static final String delete = "delete from shop.relation_role_permission where relation_id = ?";
	private static final String update = "update shop.relation_role_permission set order_id = ?, permission_id = ? where relation_id = ?";
	private static final String getall = "select * from shop.relation_role_permission";
	private static final String getone = "select * from shop.relation_role_permission where relation_id = ?";

	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Relation_role_permissionVO relation_role_permissionvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, relation_role_permissionvo.getRole_id());
			pstmt.setInt(2, relation_role_permissionvo.getPermission_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Relation_role_permissionVO relation_role_permissionvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(update);
			pstmt.setInt(1, relation_role_permissionvo.getRole_id());
			pstmt.setInt(2, relation_role_permissionvo.getPermission_id());
			pstmt.setInt(3, relation_role_permissionvo.getRelation_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
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
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, relation_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Relation_role_permissionVO getone(Integer relation_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Relation_role_permissionVO relation_role_permissionvo = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(getone);
			pstmt.setInt(1, relation_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				relation_role_permissionvo = new Relation_role_permissionVO();
				relation_role_permissionvo.setRelation_id(rs.getInt("relation_id"));
				relation_role_permissionvo.setRole_id(rs.getInt("role_id"));
				relation_role_permissionvo.setPermission_id(rs.getInt("permission_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return relation_role_permissionvo;
	}

	@Override
	public List<Relation_role_permissionVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		Relation_role_permissionVO relation_role_permissionvo = null;
		ResultSet rs = null;
		List<Relation_role_permissionVO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(getall);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				relation_role_permissionvo = new Relation_role_permissionVO();
				relation_role_permissionvo.setRelation_id(rs.getInt("relation_id"));
				relation_role_permissionvo.setRole_id(rs.getInt("role_id"));
				relation_role_permissionvo.setPermission_id(rs.getInt("permission_id"));
				list.add(relation_role_permissionvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
