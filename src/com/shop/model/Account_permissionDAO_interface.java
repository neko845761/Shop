package com.shop.model;

import java.util.List;

public interface Account_permissionDAO_interface {
	public void insert(Account_permissionVO account_permissionvo);

	public void delete(Integer permission_id);

	public void update(Account_permissionVO account_permissionvo);

	public Account_permissionVO getone(Integer permission_id);

	public List<Account_permissionVO> getall();
}
