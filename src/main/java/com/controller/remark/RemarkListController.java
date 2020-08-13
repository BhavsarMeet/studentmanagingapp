package com.controller.remark;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.remark.RemarkBean;
import com.dao.remark.RemarkDao;

/**
 * Servlet implementation class RemarkListController
 */
public class RemarkListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<RemarkBean> al=new RemarkDao().remarkList();
		if(al!=null)
		{
			request.setAttribute("listofremark", al);
			System.out.println("listremark");
			request.getRequestDispatcher("./remark/RemarkList.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("error", "Enter Remarks Again");
			request.getRequestDispatcher("./AddRemark.jsp").forward(request, response);
		}
	}

}
