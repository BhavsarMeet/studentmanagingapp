package com.controller.remark;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.remark.RemarkBean;
import com.dao.remark.RemarkDao;

/**
 * Servlet implementation class ReportController
 */
public class ReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String rid=request.getParameter("rid");
		int rId=0;
		if(rid.trim().length()>0)
			rId=Integer.parseInt(rid);
		ArrayList<RemarkBean> al=new RemarkDao().listById(rId);
		if(al!=null)
		{
			request.setAttribute("listbyid", al);
			request.getRequestDispatcher("./remark/ListReport.jsp").forward(request, response);
		}
	}

}
