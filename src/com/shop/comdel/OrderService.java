package com.shop.comdel;

import java.sql.Date;
import java.util.List;

public class OrderService {
	private OrderDAO_interface dao;

	public OrderService() {
		dao = new OrderDAO();
	}
	
	public OrderVO insert(String user_id, Double total_price, Date creat_time, String address) {
		OrderVO ordervo = new OrderVO();
		ordervo.setUser_id(user_id);
		ordervo.setTotal_price(total_price);
		ordervo.setCreat_time(creat_time);
		ordervo.setAddress(address);
		dao.insert(ordervo);
		return ordervo;
	}
	
	public OrderVO update(String user_id, Double total_price, Date creat_time, String address, Integer order_id) {
		OrderVO ordervo = new OrderVO();
		ordervo.setUser_id(user_id);
		ordervo.setTotal_price(total_price);
		ordervo.setCreat_time(creat_time);
		ordervo.setAddress(address);
		ordervo.setOrder_id(order_id);
		dao.update(ordervo);
		return ordervo;
	}
	
	public OrderVO getone(Integer order_id) {
		return dao.getone(order_id);
	}
	
	public void delete(Integer order_id) {
		dao.delete(order_id);
	}
	
	public List<OrderVO> getall(){
		return dao.getall();
	}
}
