package com.shop.comdel;

import java.util.List;

public interface NotificationDAO_interface {
public void insert(NotificationVO notificationvo);
public void update(NotificationVO notificationvo);
public void delete(Integer notification_id);
public NotificationVO getone(Integer notification_id);
public List<NotificationVO> getall();
}
