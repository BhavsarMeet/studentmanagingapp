package com.controller.remark;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.remark.RemarkDao;

/**
 * Servlet implementation class ReportController
 */
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("hiddenSid");
		String sName=request.getParameter("hiddenName");
		
		int sId=0;
		if(sid.trim().length()>0)
			sId=Integer.parseInt(sid);
		System.out.println(new RemarkDao().generateReport(sId,sName));
		response.sendRedirect("./report/"+sName+".pdf");
	}

}
