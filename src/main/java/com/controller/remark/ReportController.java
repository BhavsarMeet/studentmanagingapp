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
		String rid=request.getParameter("hiddenRid");
		String sName=request.getParameter("hiddenName");
	
		int rId=0;
		if(rid.trim().length()>0)
			rId=Integer.parseInt(rid);
		System.out.println(new RemarkDao().generateReport(rId,sName));
		response.sendRedirect("./report/"+sName+".pdf");
	}

}
