package com.controller.remark;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.remark.RemarkBean;
import com.dao.remark.RemarkDao;

/**
 * Servlet implementation class AddRemarkController
 */
public class AddRemarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descipline=request.getParameter("numDescipline");
		String regular=request.getParameter("numRegular");
		String research=request.getParameter("numResearch");
		String exam=request.getParameter("numExam");
		String grasp=request.getParameter("numGrasp");
		String task=request.getParameter("numTask");
		String sid=request.getParameter("hiddensid");
		System.out.println("sid"+sid);
		int rDescipline=0;
		int rRegular=0;
		int rResearch=0;
		int rExam=0;
		int rTask=0;
		int rGrasp=0;
		int sId=0;
		
		if(descipline.trim().length()>0 && descipline!=null )
		{
			rDescipline=Integer.parseInt(descipline);
		}
		if(regular.trim().length()>0 && regular!=null)
		{
			rRegular=Integer.parseInt(regular);
		}
		if(research.trim().length()>0 && research!=null)
		{
			rResearch=Integer.parseInt(research);
		}
		if(exam.trim().length()>0 && exam!=null)
		{
			rExam=Integer.parseInt(exam);
		}
		if(task.trim().length()>0 && task!=null)
		{
			rTask=Integer.parseInt(task);
		}
		if(grasp.trim().length()>0 && grasp!=null)
		{
			rGrasp=Integer.parseInt(grasp);
		}
		if(sid.trim().length()>0)
		{
			sId=Integer.parseInt(sid);
		}
		System.out.println("sid"+sId);
		RemarkBean rb=new RemarkBean();
		rb.setrDescipline(rDescipline);
		rb.setrExam(rExam);
		rb.setrGrasp(rGrasp);
		rb.setrRegular(rRegular);
		rb.setrResearch(rResearch);
		rb.setrTask(rTask);
		rb.setsId(sId);
		System.out.println("grasp"+rb.getrGrasp());
		boolean flag=new RemarkDao().addRemark(rb);
		
		if(flag)
		{
			System.out.println("done");
			response.sendRedirect("RemarkListController");
		}
		else
		{
			request.setAttribute("error", "add remarks again");
			request.getRequestDispatcher("./remark/RemarkAdd.jsp").include(request, response);
		}
	}

}
