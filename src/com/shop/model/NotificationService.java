package com.shop.model;

import java.sql.Date;
import java.util.List;

public class NotificationService {
private NotificationDAO_interface dao;

public NotificationService() {
	dao = new NotificationDAO();
}

public NotificationVO insert(String title, String text, byte[] picture, Date start_time, Date end_time, Date create_time) {
	NotificationVO notificationvo = new NotificationVO();
	notificationvo.setTitle(title);
	notificationvo.setText(text);
	notificationvo.setPicture(picture);
	notificationvo.setStart_time(start_time);
	notificationvo.setEnd_time(end_time);
	notificationvo.setCreate_time(create_time);
	dao.insert(notificationvo);
	return notificationvo;
}
public NotificationVO update(String title, String text, byte[] picture, Date start_time, Date end_time, Date create_time, Integer notification_id) {
	NotificationVO notificationvo = new NotificationVO();
	notificationvo.setTitle(title);
	notificationvo.setText(text);
	notificationvo.setPicture(picture);
	notificationvo.setStart_time(start_time);
	notificationvo.setEnd_time(end_time);
	notificationvo.setCreate_time(create_time);
	notificationvo.setNotification_id(notification_id);
	dao.update(notificationvo);
	return notificationvo;
}
public NotificationVO getone(Integer notification_id) {
	return dao.getone(notification_id);
}
public List<NotificationVO> getall() {
	return dao.getall();
}
public void delete(Integer notification_id) {
	dao.delete(notification_id);
}
}
