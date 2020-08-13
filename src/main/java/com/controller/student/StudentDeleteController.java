package com.controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.student.StudentDao;

/**
 * Servlet implementation class StudentDeleteController
 */
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sid=request.getParameter("sid");
		int sId=0;
		System.out.println(sid);
		boolean flag=false;
		if(sid.trim().length()>0)
		{
			sId=Integer.parseInt(sid);
			flag=new StudentDao().deleteStudent(sId);
		}
		
		if(flag)
		{
			response.sendRedirect("StudentListController");
		}
		else
			response.sendRedirect("./student/StudentList.jsp");
		
	}

}
