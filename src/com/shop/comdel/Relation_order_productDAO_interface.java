package com.shop.comdel;

import java.util.List;

public interface Relation_order_productDAO_interface {
public void insert(Relation_order_productVO relation_order_productvo);
public void update(Relation_order_productVO relation_order_productvo);
public void delete(Integer order_id);
public Relation_order_productVO getone(Integer order_id);
public List<Relation_order_productVO> getall();
}
