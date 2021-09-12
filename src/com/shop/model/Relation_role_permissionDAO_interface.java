package com.shop.model;

import java.util.List;

public interface Relation_role_permissionDAO_interface {
	public void insert(Relation_role_permissionVO relation_role_permissionvo);

	public void update(Relation_role_permissionVO relation_role_permissionvo);

	public void delete(Integer relation_id);

	public Relation_role_permissionVO getone(Integer relation_id);

	public List<Relation_role_permissionVO> getall();
}
