package com.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.faculty.FacultyBean;
import com.bean.student.StudentBean;
import com.util.DBConnectionPostgre;

public class StudentDao 
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean addStudent(StudentBean sb)
	{
		boolean b=false;
		conn=DBConnectionPostgre.getdbconnection();
		if(conn!=null)
		{
			String insertSQL="insert into student(sname,sage,semail,smob,fid)values(?,?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setString(1, sb.getsName());
				pstmt.setInt(2, sb.getsAge());
				pstmt.setString(3, sb.getsEmail());
				pstmt.setString(4, sb.getsMob());
				pstmt.setInt(5, sb.getfId());
				
				int res=pstmt.executeUpdate();
				if(res>0)
					b=true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
	
	
	public ArrayList<StudentBean> listOfStudents()
	{
		ArrayList<StudentBean> al=new ArrayList<StudentBean>();
		conn=DBConnectionPostgre.getdbconnection();
		
		if(conn!=null)
		{
			String selectSQL="select sid,sname,sage,semail,smob,fname,fsub from student join faculty on student.fid=faculty.fid";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					StudentBean sb=new StudentBean();
					
					sb.setsId(rs.getInt("sid"));
					sb.setsName(rs.getString("sname"));
					sb.setsAge(rs.getInt("sage"));
					sb.setsEmail(rs.getString("semail"));
					sb.setsMob(rs.getString("smob"));
					sb.setfName(rs.getString("fname"));
					sb.setfSub(rs.getString("fsub"));
				
					al.add(sb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return al;
	}
	
	public boolean deleteStudent(int sId)
	{
		boolean flag=false;
		
		conn=DBConnectionPostgre.getdbconnection();
		if(conn!=null)
		{
			String deleteSQL="delete from student where sid=?";
			try {
				pstmt=conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, sId);
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
	
	public StudentBean getStudentListById(int sId)
	{
		conn=DBConnectionPostgre.getdbconnection();
		StudentBean sb=null;
		if(conn!=null)
		{
			String selectSQL="select sid,sname,sage,semail,smob from student where sid=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1,sId);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					sb=new StudentBean();
					
					sb.setsId(rs.getInt("sid"));
					sb.setsName(rs.getString("sname"));
					sb.setsAge(rs.getInt("sage"));
					sb.setsEmail(rs.getString("semail"));
					sb.setsMob(rs.getString("smob").substring(3));
					sb.setfId(rs.getInt("fid"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		return sb;
	}
	
	public boolean updateStudent(StudentBean sb)
	{
		boolean flag=false;
		conn=DBConnectionPostgre.getdbconnection();
		
		if(conn!=null)
		{
			String insertSQL="update student set sname=?,sage=?,semail=?,smob=?,fid=? where sid=?";	
			try {
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setString(1, sb.getsName());
				pstmt.setInt(2, sb.getsAge());
				pstmt.setString(3, sb.getsEmail());
				pstmt.setString(4, sb.getsMob());
				pstmt.setInt(5, sb.getfId());
				pstmt.setInt(6, sb.getsId());
				
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
