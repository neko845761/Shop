package com.shop.controller;

import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

import com.shop.model.*;


public class GetPic extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("in");
		
		ServletOutputStream out = res.getOutputStream();
		res.setContentType("image/jpg");
		
		Integer picId = Integer.valueOf(req.getParameter("picno"));
		
		NotificationService svc = new NotificationService();
		
		NotificationVO vo = svc.getone(picId);
		
		out.write(vo.getPicture());
	}
}
