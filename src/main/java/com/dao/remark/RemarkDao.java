package com.dao.remark;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.bean.remark.RemarkBean;
import com.util.DBConnectionPostgre;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RemarkDao 
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean addRemark(RemarkBean rb)
	{
		boolean flag=false;
		conn=DBConnectionPostgre.getdbconnection();
		if(conn!=null)
		{
			String insertSQL="insert into remark(rdescipline,rgrasp,rtask,rexam,rregular,rresearch,sid)values(?,?,?,?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setInt(1,rb.getrDescipline());
				pstmt.setInt(2,rb.getrGrasp() );
				pstmt.setInt(3,rb.getrTask());
				pstmt.setInt(4,rb.getrExam());
				pstmt.setInt(5,rb.getrRegular());
				pstmt.setInt(6,rb.getrResearch());
				pstmt.setInt(7,rb.getsId());
				
				int res=pstmt.executeUpdate();
				if(res>0)
					flag=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public ArrayList<RemarkBean> remarkList()
	{
		ArrayList<RemarkBean> al=new ArrayList<RemarkBean>();
		conn=DBConnectionPostgre.getdbconnection();
		RemarkBean rb=null;
		
		if(conn!=null)
		{	
			String selectSQL="select student.sid,sname,rdescipline,rregular,rresearch,rexam,rtask,rgrasp,rid from remark join student on student.sid=remark.sid";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					rb=new RemarkBean();
					
					rb.setsName(rs.getString("sname"));
					rb.setrDescipline(rs.getInt("rdescipline"));
					rb.setrRegular(rs.getInt("rregular"));
					rb.setrResearch(rs.getInt("rresearch"));
					rb.setrExam(rs.getInt("rexam"));
					rb.setrTask(rs.getInt("rtask"));
					rb.setrGrasp(rs.getInt("rgrasp"));
					rb.setsId(rs.getInt("sid"));
					rb.setrId(rs.getInt("rid"));
					
					al.add(rb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}
	
	public ArrayList<RemarkBean> listById(int rId)
	{
		ArrayList<RemarkBean> al=new ArrayList<RemarkBean>();
		conn=DBConnectionPostgre.getdbconnection();
		RemarkBean rb=null;
		if(conn!=null)
		{
			String selectSQL="select student.sid,sname,rdescipline,rregular,rresearch,rexam,rtask,rgrasp,rid from remark join student on student.sid=remark.sid where rid=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1,rId);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					rb=new RemarkBean();
					
					rb.setsName(rs.getString("sname"));
					rb.setrDescipline(rs.getInt("rdescipline"));
					rb.setrRegular(rs.getInt("rregular"));
					rb.setrResearch(rs.getInt("rresearch"));
					rb.setrExam(rs.getInt("rexam"));
					rb.setrTask(rs.getInt("rtask"));
					rb.setrGrasp(rs.getInt("rgrasp"));
					rb.setsId(rs.getInt("sid"));
					rb.setrId(rs.getInt("rid"));
					al.add(rb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}
	public String generateReport(int rId,String name)
	{
		String reportPath="D:\\Meet study\\Java\\eclipse-workspace\\Student_Management\\src\\main\\webapp\\report";
		
		//compile jrxml file
		try {
			JasperReport jasperReport=JasperCompileManager.compileReport("D:\\Meet study\\Java\\eclipse-workspace\\Student_Management\\reportjrxmls\\marks.jrxml");
			
		//get your data
		JRBeanCollectionDataSource jrbcds=new JRBeanCollectionDataSource(new RemarkDao().listById(rId));
		
		//add params
		
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("createdBy", "Meet");
		
		//file the report
		JasperPrint jp=JasperFillManager.fillReport(jasperReport, parameters,jrbcds);
		
		//export report to pdf
		JasperExportManager.exportReportToPdfFile(jp,reportPath+"\\"+name+".pdf");
		System.out.println("done");
		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "report generated";
		
	}
	public boolean deleteRemark(int rId)
	{
		boolean flag=false;
		conn=DBConnectionPostgre.getdbconnection();
		if(conn!=null)
		{
			String deleteSQL="delete from remark where rid=?";
			try {
				pstmt=conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, rId);
				
				int res=pstmt.executeUpdate();
				
				if(res>0)
					flag=true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	/*public boolean putImage(FileInputStream fis)
	{
		boolean b=false;
		conn=DBConnectionPostgre.getdbconnection();
		if(conn!=null)
		{
			String insertSQL="insert into author(apdf)values(?)";
			try {
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setBinaryStream(1, fis);
				
				int res=pstmt.executeUpdate();
				if(res>0)
					b=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}*/


/*	public ArrayList<RemarkBean> getPdf()
	{
		ArrayList<RemarkBean> al=new ArrayList<RemarkBean>();
	
		conn=DBConnectionPostgre.getdbconnection();
		if(conn!=null)
		{
			
			String insertSQL="select sid,rpdf from author where aid=16";
			try {
				pstmt=conn.prepareStatement(insertSQL);
				
				
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					RemarkBean rb=new RemarkBean();
				//	rb.setsId();
					al.add(rb);
				}
				System.out.println("done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return al; 
	}

	*/
}
