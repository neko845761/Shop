package com.shop.comdel;

import java.util.List;

public interface OrderDAO_interface {
public void insert(OrderVO ordervo);
public void update(OrderVO ordervo);
public void delete(Integer order_id);
public OrderVO getone(Integer order_id);
public List<OrderVO> getall();
}
