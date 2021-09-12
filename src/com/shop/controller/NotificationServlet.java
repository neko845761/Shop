package com.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shop.model.*;

@MultipartConfig
public class NotificationServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println(action);

		if ("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String str = req.getParameter("notification_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入公告ID");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/notification/select_page.jsp");
					failureView.forward(req, res);
					return;
				}

				Integer notification_id = null;
				try {
					notification_id = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("公告ID格式不正確");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/notification/select_page.jsp");
					failureView.forward(req, res);
					return;
				}

				NotificationService notificationSvc = new NotificationService();
				NotificationVO notificationVO = notificationSvc.getone(notification_id);
				if (notificationVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/notification/select_page.jsp");
					failureView.forward(req, res);
					return;
				}

				req.setAttribute("notificationVO", notificationVO);
				String url = "/back-end/notification/listOneNotification.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/notification/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				Integer notification_id = new Integer(req.getParameter("notification_id"));

				NotificationService notificationSvc = new NotificationService();
				NotificationVO notificationVO = notificationSvc.getone(notification_id);

				req.setAttribute("notificationVO", notificationVO);
				String url = "/back-end/notification/update_notification_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/notification/listAllNotification.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				Integer notification_id = new Integer(req.getParameter("notification_id").trim());

				String title = req.getParameter("title").trim();
				if (title == null || title.trim().length() == 0) {
					errorMsgs.add("公告標題請勿空白");
				}

				String text = req.getParameter("text").trim();
				if (text == null || text.trim().length() == 0) {
					errorMsgs.add("公告內文請勿空白");
				}

				byte[] picture = null;
				Part part = req.getPart("picture");
				InputStream in = part.getInputStream();
				// 先判斷Part裡面有沒有資料，Part裡沒有資料代表沒有上或修改新照片
				if (in.available() <= 0) {
					NotificationService notificationSVC = new NotificationService();
					NotificationVO vo = notificationSVC.getone(notification_id);
					picture = vo.getPicture();
				} else {
					picture = new byte[in.available()];
					in.read(picture);
					in.close();
				}

				java.sql.Date start_time = null;
				try {
					start_time = java.sql.Date.valueOf(req.getParameter("start_time").trim());
				} catch (IllegalArgumentException e) {
					NotificationService notificationSVC = new NotificationService();
					NotificationVO vo = notificationSVC.getone(notification_id);
					start_time = vo.getStart_time();
				}

				java.sql.Date end_time = null;
				try {
					end_time = java.sql.Date.valueOf(req.getParameter("end_time").trim());
				} catch (IllegalArgumentException e) {
					NotificationService notificationSVC = new NotificationService();
					NotificationVO vo = notificationSVC.getone(notification_id);
					end_time = vo.getEnd_time();
				}

				java.sql.Date create_time = null;
				try {
					create_time = java.sql.Date.valueOf(req.getParameter("create_time").trim());
				} catch (IllegalArgumentException e) {
					NotificationService notificationSVC = new NotificationService();
					NotificationVO vo = notificationSVC.getone(notification_id);
					create_time = vo.getCreate_time();
				}

				NotificationVO notificationVO = new NotificationVO();
				notificationVO.setNotification_id(notification_id);
				notificationVO.setTitle(title);
				notificationVO.setText(text);
				notificationVO.setPicture(picture);
				notificationVO.setStart_time(start_time);
				notificationVO.setEnd_time(end_time);
				notificationVO.setCreate_time(create_time);
				

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("notificationVO", notificationVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/notification/update_notification_input.jsp");
					failureView.forward(req, res);
					return;
				}

				NotificationService notificationSvc = new NotificationService();
				notificationVO = notificationSvc.update(title, text, picture, start_time, end_time,
						create_time,notification_id);

				req.setAttribute("notificationVO", notificationVO);
				String url = "/back-end/notification/listOneNotification.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/notification/update_notification_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) {
			System.out.println(action);
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String title = req.getParameter("title").trim();
				if (title == null || title.trim().length() == 0) {
					errorMsgs.add("公告標題請勿空白");
				}
				String text = req.getParameter("text").trim();
				if (text == null || text.trim().length() == 0) {
					errorMsgs.add("公告內文請勿空白");
				}
				byte[] picture = null;
				Part part = req.getPart("picture");
				InputStream in = part.getInputStream();
				if (in.available() == 0) {
					errorMsgs.add("公告圖片誤空白");
				} else {
					picture = new byte[in.available()];
					in.read(picture);
					in.close();
				}

				java.sql.Date start_time = null;
				try {
					start_time = java.sql.Date.valueOf(req.getParameter("start_time").trim());
				} catch (IllegalArgumentException e) {
					start_time = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入開始時間!");
				}
				java.sql.Date end_time = null;
				try {
					end_time = java.sql.Date.valueOf(req.getParameter("end_time").trim());
				} catch (IllegalArgumentException e) {
					end_time = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入結束時間!");
				}
				java.sql.Date create_time = null;
				try {
					create_time = java.sql.Date.valueOf(req.getParameter("create_time").trim());
				} catch (IllegalArgumentException e) {
					create_time = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入創建時間!");
				}

				NotificationVO notificationVO = new NotificationVO();
				notificationVO.setTitle(title);
				notificationVO.setText(text);
				notificationVO.setPicture(picture);
				notificationVO.setStart_time(start_time);
				notificationVO.setEnd_time(end_time);
				notificationVO.setCreate_time(create_time);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("notificationVO", notificationVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/notification/addNotification.jsp");
					failureView.forward(req, res);
					return;
				}

				NotificationService notificationSvc = new NotificationService();
				notificationVO = notificationSvc.insert(title, text, picture, start_time, end_time, create_time);

				String url = "/back-end/notification/listAllNotification.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/notification/listAllNotification.jsp");
				failureView.forward(req, res);
				e.printStackTrace();
			}
		}
		
		if ("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				Integer notification_id = new Integer(req.getParameter("notification_id"));
				
				NotificationService notificationSvc = new NotificationService();
				notificationSvc.delete(notification_id);
				
				String url = "/back-end/notification/listAllNotification.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
			}catch(Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/notification/listAllNotification.jsp");
				failureView.forward(req, res);
			}
		}
		
	}
}
