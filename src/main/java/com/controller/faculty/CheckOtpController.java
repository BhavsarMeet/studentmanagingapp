package com.controller.faculty;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckOtpController
 */
public class CheckOtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp=request.getParameter("numOtp");
		
		HttpSession session=request.getSession();
		int otpcheck=(int)session.getAttribute("otp");
		String temp=Integer.toString(otpcheck);
		
		
		
		if(temp.equals(otp))
		{
			response.sendRedirect("./faculty/ResetPassword.jsp");
		}
		else
		{
			session.invalidate();
			request.setAttribute("error", "you entered wrong otp!!!");
			request.getRequestDispatcher("./faculty/forgotPassword.jsp").forward(request, response);
		}
	}

}
