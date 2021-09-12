package com.shop.model;

import java.sql.Date;
import java.util.List;

public class Account_memberService {
	private Account_memberDAO_interface dao;
	
	public Account_memberService() {
		dao = new Account_memberDAO();
	}
	
	public Account_memberVO add(String user_account, String user_password, Integer gender, Date birth_day, String address, Integer status, String email, String note, Date creat_time, Date login_time) {
		Account_memberVO account_membervo = new Account_memberVO();
		account_membervo.setUser_account(user_account);
		account_membervo.setUser_password(user_password);
		account_membervo.setGender(gender);
		account_membervo.setBirth_day(birth_day);
		account_membervo.setAddress(address);
		account_membervo.setStatus(status);
		account_membervo.setEmail(email);
		account_membervo.setNote(note);
		account_membervo.setCreat_time(creat_time);
		account_membervo.setLogin_time(login_time);
		dao.insert(account_membervo);
		return account_membervo;
	}
	public Account_memberVO update(String user_account, String user_password, Integer gender, Date birth_day, String address, Integer status, String email, String note, Date creat_time, Date login_time,String user_id) {
		Account_memberVO account_membervo = new Account_memberVO();
		account_membervo.setUser_account(user_account);
		account_membervo.setUser_password(user_password);
		account_membervo.setGender(gender);
		account_membervo.setBirth_day(birth_day);
		account_membervo.setAddress(address);
		account_membervo.setStatus(status);
		account_membervo.setEmail(email);
		account_membervo.setNote(note);
		account_membervo.setCreat_time(creat_time);
		account_membervo.setLogin_time(login_time);
		account_membervo.setUser_id(user_id);
		dao.update(account_membervo);
		return account_membervo;
	}
	
	public void delete(String user_id) {
		dao.delete(user_id);
	}
	
	public List<Account_memberVO> getall(){
		return dao.getall();
	}
	
	public Account_memberVO getone(String user_id) {
		return dao.getone(user_id); 
	}
}
