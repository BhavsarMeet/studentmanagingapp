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
		String sid=request.getParameter("sid");
		int sId=0;
		if(sid.trim().length()>0 && sid!=null)
			sId=Integer.parseInt(sid);
		ArrayList<RemarkBean> al=new RemarkDao().listById(sId);
		if(al!=null)
		{
			request.setAttribute("listbyid", al);
			request.getRequestDispatcher("./remark/ListReport.jsp").forward(request, response);
		}
	}

}
