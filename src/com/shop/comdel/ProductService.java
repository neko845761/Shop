package com.shop.comdel;

import java.util.List;

public class ProductService {
private ProductDAO_interface dao;

public ProductService() {
	dao = new ProductDAO();
}

public ProductVO add(String name, String description, byte[] picture, Double price, Integer stock) {
	ProductVO productvo = new ProductVO();
	productvo.setName(name);
	productvo.setDescription(description);
	productvo.setPicture(picture);
	productvo.setPrice(price);
	productvo.setStock(stock);
	dao.insert(productvo);
	return productvo;
}

public ProductVO update(String name, String description, byte[] picture, Double price, Integer stock, Integer product_id) {
	ProductVO productvo = new ProductVO();
	productvo.setName(name);
	productvo.setDescription(description);
	productvo.setPicture(picture);
	productvo.setPrice(price);
	productvo.setStock(stock);
	productvo.setProduct_id(product_id);
	dao.update(productvo);
	return productvo;
}

public ProductVO getone(Integer product_id) {
	return dao.getone(product_id);
}

public List<ProductVO> getall() {
	return dao.getall();
}

public void delete(Integer product_id) {
	dao.delete(product_id);
}
}
