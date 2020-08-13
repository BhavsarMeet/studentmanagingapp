package com.controller.remark;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.remark.RemarkDao;
import com.dao.student.StudentDao;

/**
 * Servlet implementation class RemarkDeleteController
 */
public class RemarkDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String rid=request.getParameter("rid");
		int rId=0;
		System.out.println(rid);
		boolean flag=false;
		if(rid.trim().length()>0)
		{
			rId=Integer.parseInt(rid);
			flag=new RemarkDao().deleteRemark(rId);
			System.out.println("Delete Data");
		}
		
		if(flag)
		{
			response.sendRedirect("RemarkListController");
		}
		else
			response.sendRedirect("./remark/RemarkList.jsp");
	
	}

}
