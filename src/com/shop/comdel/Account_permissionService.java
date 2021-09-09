package com.shop.comdel;

import java.sql.Date;
import java.util.List;

public class Account_permissionService {
	private Account_permissionDAO_interface dao;

	public Account_permissionService() {
		dao = new Account_permissionDAO();
	}

	public Account_permissionVO add(String name, Integer status, Date creat_time) {
		Account_permissionVO account_permissionvo = new Account_permissionVO();
		account_permissionvo.setName(name);
		account_permissionvo.setStatus(status);
		account_permissionvo.setCreat_time(creat_time);
		dao.insert(account_permissionvo);
		return account_permissionvo;
	}

	public Account_permissionVO update(String name, Integer status, Date creat_time, Integer permission_id) {
		Account_permissionVO account_permissionvo = new Account_permissionVO();
		account_permissionvo.setName(name);
		account_permissionvo.setStatus(status);
		account_permissionvo.setCreat_time(creat_time);
		account_permissionvo.setPermission_id(permission_id);
		dao.update(account_permissionvo);
		return account_permissionvo;
	}

	public void delete(Integer permission_id) {
		dao.delete(permission_id);
	}

	public Account_permissionVO getone(Integer permission_id) {
		return dao.getone(permission_id);
	}

	public List<Account_permissionVO> getall() {
		return dao.getall();
	}
}
