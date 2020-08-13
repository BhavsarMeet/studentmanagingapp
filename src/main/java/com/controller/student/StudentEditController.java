package com.controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.student.StudentBean;
import com.dao.student.StudentDao;

/**
 * Servlet implementation class StudentEditController
 */
public class StudentEditController extends HttpServlet {
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
		
		StudentBean sb=new StudentDao().getStudentListById(sId);
		if(sb!=null)
		{
			request.setAttribute("studentbean",sb);
			request.getRequestDispatcher("./student/StudentEdit.jsp").forward(request, response);
		}
	}

}
