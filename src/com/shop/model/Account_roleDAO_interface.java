package com.shop.model;

import java.util.List;

public interface Account_roleDAO_interface {
	public void insert(Account_roleVO account_rolevo);

	public void delete(Integer role_id);

	public void update(Account_roleVO account_rolevo);

	public Account_roleVO getone(Integer role_id);

	public List<Account_roleVO> getall();
}
