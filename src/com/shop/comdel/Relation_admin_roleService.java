package com.shop.comdel;

import java.util.List;

public class Relation_admin_roleService {
private Relation_admin_roleDAO_interface dao;

public Relation_admin_roleService() {
	dao = new Relation_admin_roleDAO();
}

public Relation_admin_roleVO insert(Integer user_id, Integer role_id) {
	Relation_admin_roleVO relation_admin_rolevo = new Relation_admin_roleVO();
	relation_admin_rolevo.setUser_id(user_id);
	relation_admin_rolevo.setRole_id(role_id);
	dao.insert(relation_admin_rolevo);
	return relation_admin_rolevo;
}
public Relation_admin_roleVO update(Integer user_id, Integer role_id, Integer relation_id) {
	Relation_admin_roleVO relation_admin_rolevo = new Relation_admin_roleVO();
	relation_admin_rolevo.setUser_id(user_id);
	relation_admin_rolevo.setRole_id(role_id);
	relation_admin_rolevo.setRelation_id(relation_id);
	dao.update(relation_admin_rolevo);
	return relation_admin_rolevo;
}
public Relation_admin_roleVO getone(Integer relation_id) {
	return dao.getone(relation_id);
}
public List<Relation_admin_roleVO> getall() {
	return dao.getall();
}
public void delete(Integer relation_id) {
	dao.delete(relation_id);
}
}
