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
					errorMsgs.add("�п�J���iID");
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
					errorMsgs.add("���iID�榡�����T");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/notification/select_page.jsp");
					failureView.forward(req, res);
					return;
				}

				NotificationService notificationSvc = new NotificationService();
				NotificationVO notificationVO = notificationSvc.getone(notification_id);
				if (notificationVO == null) {
					errorMsgs.add("�d�L���");
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
				errorMsgs.add("�L�k���o���:" + e.getMessage());
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
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
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
					errorMsgs.add("���i���D�ФŪť�");
				}

				String text = req.getParameter("text").trim();
				if (text == null || text.trim().length() == 0) {
					errorMsgs.add("���i����ФŪť�");
				}

				byte[] picture = null;
				Part part = req.getPart("picture");
				InputStream in = part.getInputStream();
				// ���P�_Part�̭����S����ơAPart�̨S����ƥN��S���W�έק�s�Ӥ�
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
				errorMsgs.add("�ק��ƥ���:" + e.getMessage());
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
					errorMsgs.add("���i���D�ФŪť�");
				}
				String text = req.getParameter("text").trim();
				if (text == null || text.trim().length() == 0) {
					errorMsgs.add("���i����ФŪť�");
				}
				byte[] picture = null;
				Part part = req.getPart("picture");
				InputStream in = part.getInputStream();
				if (in.available() == 0) {
					errorMsgs.add("���i�Ϥ��~�ť�");
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
					errorMsgs.add("�п�J�}�l�ɶ�!");
				}
				java.sql.Date end_time = null;
				try {
					end_time = java.sql.Date.valueOf(req.getParameter("end_time").trim());
				} catch (IllegalArgumentException e) {
					end_time = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J�����ɶ�!");
				}
				java.sql.Date create_time = null;
				try {
					create_time = java.sql.Date.valueOf(req.getParameter("create_time").trim());
				} catch (IllegalArgumentException e) {
					create_time = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J�Ыخɶ�!");
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
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
			}catch(Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/notification/listAllNotification.jsp");
				failureView.forward(req, res);
			}
		}
		
	}
}
