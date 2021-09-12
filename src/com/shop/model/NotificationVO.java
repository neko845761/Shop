package com.shop.model;

import java.sql.Date;

public class NotificationVO {
	private Integer notification_id;
	private String title;
	private String text;
	private byte[] picture;
	private Date start_time;
	private Date end_time;
	private Date create_time;

	public Integer getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(Integer notification_id) {
		this.notification_id = notification_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date creat_time) {
		this.create_time = creat_time;
	}

}
