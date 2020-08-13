package com.controller.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.student.StudentBean;
import com.dao.student.StudentDao;

/**
 * Servlet implementation class StudentListController
 */
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<StudentBean> al=new StudentDao().listOfStudents(); 
		if(al!=null)
		{
			System.out.println("in in list controller");
			request.setAttribute("listofstudents", al);
			request.getRequestDispatcher("./student/StudentList.jsp").forward(request, response);
		
		}
		else 
		{
			response.sendRedirect("./shared/Error.jsp");
		}
	}

	
}
