package com.controller.faculty;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.faculty.FacultyDao;

/**
 * Servlet implementation class ResetPasswordController
 */
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("fEmail");
		String password=request.getParameter("pwdPassword");
		String confirmPassword=request.getParameter("pwdNewPassword");
		System.out.println("cp"+confirmPassword);
		
		if(confirmPassword.equals(password))
		{	
			if(new FacultyDao().resetPassword(email, confirmPassword))
			{
				session.invalidate();
				System.out.println("updated");
				request.setAttribute("done", "Your Password has been updated successfully!!!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("problem", "Enter registered Email!!!");
				request.getRequestDispatcher("./faculty/forgotPassword.jsp").forward(request, response);		
			}	
			
		}	
		else
		{
			request.setAttribute("again", "password doesnot match!!!");
			request.getRequestDispatcher("./faculty/ResetPassword.jsp").forward(request, response);
		}
	}

}
