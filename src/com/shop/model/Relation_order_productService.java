package com.shop.model;

import java.util.List;

public class Relation_order_productService {
	private Relation_order_productDAO_interface dao;

	public Relation_order_productService() {
		dao = new Relation_order_productDAO();
	}

	public Relation_order_productVO add(Integer product_id, Integer quantity, Double price) {
		Relation_order_productVO relation_order_productvo = new Relation_order_productVO();
		relation_order_productvo.setProduct_id(product_id);
		relation_order_productvo.setQuantity(quantity);
		relation_order_productvo.setPrice(price);
		dao.insert(relation_order_productvo);
		return relation_order_productvo;
	}

	public Relation_order_productVO update(Integer product_id, Integer quantity, Double price, Integer order_id) {
		Relation_order_productVO relation_order_productvo = new Relation_order_productVO();
		relation_order_productvo.setProduct_id(product_id);
		relation_order_productvo.setQuantity(quantity);
		relation_order_productvo.setPrice(price);
		relation_order_productvo.setOrder_id(order_id);
		dao.update(relation_order_productvo);
		return relation_order_productvo;
	}

	public Relation_order_productVO getone(Integer order_id) {
		return dao.getone(order_id);
	}

	public List<Relation_order_productVO> getall() {
		return dao.getall();
	}

	public void delete(Integer order_id) {
		dao.delete(order_id);
	}
}
