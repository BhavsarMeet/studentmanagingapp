package com.controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.student.StudentBean;
import com.dao.student.StudentDao;
import com.util.Validation;

/**
 * Servlet implementation class StudentUpdateController
 */
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
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
				String sid=request.getParameter("txtStudentId");
				int sId=0;
				if(sid.trim().length()>0 && sid!=null)
					sId=Integer.parseInt(sid);
			
				//info from jsp-->end
				System.out.println(sId);
				
				boolean flag=true; 
							
				StudentBean sb=new StudentBean();
				//validation to set student bean--->start
				sb.setsId(sId);
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
					sb.setfId(fId);
				//validation to set student bean--->end
			
				//insertion in database
				if(flag==true)
				{	
					sb.setsMob("+91"+sb.getsMob());
					boolean updateStudent=new StudentDao().updateStudent(sb);
					
					if(updateStudent)
					{
						response.sendRedirect("StudentListController");
					}
				}
				else
				{
					System.out.println("false");
					request.setAttribute("error", "enter data again!!!");
					request.setAttribute("studentbean", sb);
					request.getRequestDispatcher("./student/StudentEdit.jsp").forward(request, response);
					
				}	

	}

}
