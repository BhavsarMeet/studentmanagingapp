package com.controller.faculty;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.Mailer;

/**
 * Servlet implementation class ForgotPasswordController
 */
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fEmail=request.getParameter("txtEmail");
		HttpSession session=request.getSession();
		session .setAttribute("fEmail", fEmail);
		int temp=(int)(Math.random()*1000000);
		String sub="Mail Verification!!!";
		String msg="your one time password(otp) is "+temp+".please don't share it with anyone!!!";
		System.out.println(fEmail);
		System.out.println(sub);
		System.out.println(msg);
		Mailer.send(fEmail, sub, msg);
		session.setAttribute("otp", temp);
		response.sendRedirect("./faculty/OtpPassword.jsp");
		
	}

}
