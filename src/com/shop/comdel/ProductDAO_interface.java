package com.shop.comdel;

import java.util.List;

public interface ProductDAO_interface {
	public void insert(ProductVO productvo);

	public void update(ProductVO productvo);

	public void delete(Integer product_id);

	public ProductVO getone(Integer product_id);

	public List<ProductVO> getall();
}
