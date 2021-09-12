package com.shop.model;

import java.util.List;

public interface Account_adminDAO_interface {
	
	public void insert(Account_adminVO account_adminvo);

	public void delete(String user_id);

	public void update(Account_adminVO account_adminvo);

	public Account_adminVO getone(String user_id);

	public List<Account_adminVO> getall();
}
