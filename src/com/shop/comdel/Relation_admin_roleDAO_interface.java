package com.shop.comdel;

import java.util.List;

public interface Relation_admin_roleDAO_interface {
public void insert(Relation_admin_roleVO relation_admin_rolevo);
public void update(Relation_admin_roleVO relation_admin_rolevo);
public void delete(Integer relation_id);
public Relation_admin_roleVO getone(Integer relation_id);
public List<Relation_admin_roleVO> getall();
}
