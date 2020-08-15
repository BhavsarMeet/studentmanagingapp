package com.controller.faculty;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.faculty.FacultyDao;
import com.bean.faculty.FacultyBean;

/**
 * Servlet implementation class FacultyLoginController
 */
public class FacultyLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fEmail=request.getParameter("txtFacultyEmail");
		String fPassword=request.getParameter("pwdFacultyPassword");
	
		FacultyBean fb=new FacultyDao().facultyLogin(fEmail, fPassword);
		
		  ArrayList<FacultyBean> al=new FacultyDao().facultyList();
		if(fb!=null ) {
			HttpSession session=request.getSession();
			session.setAttribute("fb", fb);
			
			if(al!=null)
			{	
				session.setAttribute("facultylist", al);
				response.sendRedirect("./shared/DashBoard.jsp");
			}
		}	
		else 
		{
				request.setAttribute("error", "*Enter valid username or password");
				request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	
	}
}	
