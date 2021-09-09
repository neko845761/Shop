package com.shop.comdel;

import java.sql.Date;
import java.util.List;

public class Account_adminService {
	private Account_adminDAO_interface dao;
	
	public Account_adminService() {
		dao = new Account_adminDAO();
	}
	
	public Account_adminVO add(String user_account, String user_password, String email, String note, Integer status, Date creat_time, Date login_time) {
		Account_adminVO account_adminvo = new Account_adminVO();
		account_adminvo.setUser_account(user_account);
		account_adminvo.setUser_password(user_password);
		account_adminvo.setEmail(email);
		account_adminvo.setNote(note);
		account_adminvo.setStatus(status);
		account_adminvo.setCreat_time(creat_time);
		account_adminvo.setLogin_time(login_time);
		dao.insert(account_adminvo);
		return account_adminvo;
	}
	
	public Account_adminVO update(String user_account, String user_password, String email, String note, Integer status, Date creat_time, Date login_time, String user_id) {
		Account_adminVO account_adminvo = new Account_adminVO();
		account_adminvo.setUser_account(user_account);
		account_adminvo.setUser_password(user_password);
		account_adminvo.setEmail(email);
		account_adminvo.setNote(note);
		account_adminvo.setStatus(status);
		account_adminvo.setCreat_time(creat_time);
		account_adminvo.setLogin_time(login_time);
		account_adminvo.setUser_id(user_id);
		dao.update(account_adminvo);
		return account_adminvo;
	}
	
	public void delete(String user_id) {
		dao.delete(user_id);
	}
	
	public List<Account_adminVO> getall(){
		return dao.getall();
	}
	
	public Account_adminVO getone(String user_id) {
		return dao.getone(user_id); 
	}
}
