package com.shop.model;

import java.util.List;

public class Relation_role_permissionService {
private Relation_role_permissionDAO_interface dao;

public Relation_role_permissionService() {
	dao = new Relation_role_permissionDAO();
}
public Relation_role_permissionVO add(Integer role_id, Integer permission_id) {
	Relation_role_permissionVO relation_role_permissionvo = new Relation_role_permissionVO();
	relation_role_permissionvo.setRole_id(role_id);
	relation_role_permissionvo.setPermission_id(permission_id);
	dao.insert(relation_role_permissionvo);
	return relation_role_permissionvo;
}
public Relation_role_permissionVO update(Integer role_id, Integer permission_id, Integer relation_id) {
	Relation_role_permissionVO relation_role_permissionvo = new Relation_role_permissionVO();
	relation_role_permissionvo.setRole_id(role_id);
	relation_role_permissionvo.setPermission_id(permission_id);
	relation_role_permissionvo.setRelation_id(relation_id);
	dao.update(relation_role_permissionvo);
	return relation_role_permissionvo;
}
public Relation_role_permissionVO getone(Integer relation_id) {
	return dao.getone(relation_id);
}
public List<Relation_role_permissionVO> getall() {
	return dao.getall();
}
public void delete(Integer relation_id) {
	dao.delete(relation_id);
}
}
