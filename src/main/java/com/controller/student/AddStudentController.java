package com.controller.student;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.bean.student.StudentBean;
import com.dao.student.StudentDao;
import com.util.Validation;

/**
 * Servlet implementation class AddStudentController
 */
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//info from jsp-->start
		String sName=request.getParameter("txtStudentName");
		String age=request.getParameter("txtStudentAge");
		int sAge=0;
		if(age.trim().length()>0 && age!=null)
			sAge=Integer.parseInt(age);		
		String sMob=request.getParameter("txtStudentMob");
		String sEmail=request.getParameter("txtStudentEmail");
		String fid=request.getParameter("txtFacultyId");
		int fId=0;
		
		if(fid.trim().length()>0 && fid!=null)
			fId=Integer.parseInt(fid);
		//info from jsp-->end
		
		boolean flag=true;
					
		StudentBean sb=new StudentBean();
		
		//validation to set student bean--->start	
		if(!new Validation().checkEmail(sEmail))
		{
			flag=false;
			request.setAttribute("email","*Valid email Required");
		}
		else 
		{
			sb.setsEmail(sEmail);
		}
		if(!(sAge>18))
		{
			flag=false;
			request.setAttribute("age","*age must be greater than 18");
		}
		else 
		{
			sb.setsAge(sAge);
		}
		if(!new Validation().checkMobile(sMob))
		{	
			flag=false;
			request.setAttribute("mobile","*Valid mobile number Required");
		}
		else 
		{
			sb.setsMob(sMob);
		}
		if(!new Validation().checkName(sName))
		{
			flag=false;
			request.setAttribute("name","*valid	 Name Required");
		}
		else
		{
			sb.setsName(sName);	
		}
		if(!(fId>0))
		{
			flag=false;
			request.setAttribute("faculty","*please select faculty name");
		}
		else 
		{	
			sb.setfId(fId);
		}
		//validation to set student bean--->end
		
		//insertion in database
		if(flag==true)
		{	
			sb.setsMob("+91"+sMob);
			boolean setStudent=new StudentDao().addStudent(sb);
			if(setStudent)
			{
				response.sendRedirect("StudentListController");
			}
		}
		else
		{
			request.setAttribute("sb", sb);
			request.getRequestDispatcher("./student/StudentAdd.jsp").forward(request, response);
		}	
	}
}
