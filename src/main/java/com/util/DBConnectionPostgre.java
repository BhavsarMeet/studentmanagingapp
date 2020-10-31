package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionPostgre 
{
	static String DriverClassName="org.postgresql.Driver";
	static String username="wjoyiffcwkvpwr";
	static String password="492e76e248e0473c148e6f3f676856efef4f3cb9e7e253a7d0d56b93f2ac7efb";
	static String ConnectionUrl="jdbc:postgresql://ec2-54-166-107-5.compute-1.amazonaws.com:5432/d5skevnvcee748?sslmode=require";	

	public static Connection getdbconnection()
	{
		
		Connection conn=null;
		
				try {
					Class.forName(DriverClassName);
					conn=DriverManager.getConnection(ConnectionUrl, username, password);
					if (conn!=null)
					{
						System.out.println("connected postgres");
					}	
					else
						System.out.println("not connected");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conn;	
	}

}
