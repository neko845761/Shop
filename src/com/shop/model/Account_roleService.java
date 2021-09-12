package com.shop.model;

import java.sql.Date;
import java.util.List;

public class Account_roleService {
private Account_roleDAO_interface dao;

public Account_roleService() {
	dao = new Account_roleDAO();
}
public Account_roleVO add(String name, String description, Date creat_time, Integer status) {
	Account_roleVO account_rolevo = new Account_roleVO();
	account_rolevo.setName(name);
	account_rolevo.setDescription(description);
	account_rolevo.setCreat_time(creat_time);
	account_rolevo.setStatus(status);
	dao.insert(account_rolevo);
	return account_rolevo;
}
public Account_roleVO update(String name, String description, Date creat_time, Integer status, Integer role_id) {
	Account_roleVO account_rolevo = new Account_roleVO();
	account_rolevo.setName(name);
	account_rolevo.setDescription(description);
	account_rolevo.setCreat_time(creat_time);
	account_rolevo.setStatus(status);
	account_rolevo.setRole_id(role_id);
	dao.update(account_rolevo);
	return account_rolevo;
}
public Account_roleVO getone(Integer role_id) {
	return dao.getone(role_id);
}
public List<Account_roleVO> getall() {
	return dao.getall();
}
public void delete(Integer role_id) {
	dao.delete(role_id);
}
}
