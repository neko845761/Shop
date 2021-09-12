package com.shop.model;

import java.util.List;

public interface Account_memberDAO_interface {
	public void insert(Account_memberVO account_membervo);

	public void delete(String user_id);

	public void update(Account_memberVO account_membervo);

	public Account_memberVO getone(String user_id);

	public List<Account_memberVO> getall();
}
