package com.dao.faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.faculty.FacultyBean;
import com.util.DBConnectionPostgre;

public class FacultyDao
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public FacultyBean facultyLogin(String fEmail,String fPassword)
	{
		FacultyBean fb=null;		
		conn=DBConnectionPostgre.getdbconnection();
		if(conn!=null)
		{	
			String selectSQL="select * from faculty where femail=? and fpassword=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1,fEmail);
				pstmt.setString(2, fPassword);
				
				rs=pstmt.executeQuery();
				while(rs.next())
				{	
					fb=new FacultyBean();
					
					fb.setfName(rs.getString("fname"));
					fb.setfSub(rs.getString("fsub"));
					fb.setfEmail(rs.getString("femail"));
					fb.setfPassword(rs.getString("fpassword"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fb;		
	}
	
	public ArrayList<FacultyBean> facultyList()
	{
		ArrayList<FacultyBean> alf=new ArrayList<FacultyBean>();
		conn=DBConnectionPostgre.getdbconnection();
		
		if(conn!=null)
		{
			String selectSQL="select fid,fname from faculty";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					FacultyBean fb=new FacultyBean();
					fb.setfId(rs.getInt("fid"));
					fb.setfName(rs.getString("fname"));
					alf.add(fb);
				}
				System.out.println(alf.get(0));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alf;	
	}
	
	public boolean resetPassword(String email,String confirmPassword)
	{
		boolean flag=false;
		conn=DBConnectionPostgre.getdbconnection();
		
		if(conn!=null)
		{
			String updateSQL="update faculty set fpassword=? where femail=?";
			try {
				pstmt=conn.prepareStatement(updateSQL);
				pstmt.setString(1, confirmPassword);
				pstmt.setString(2, email);
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
}

