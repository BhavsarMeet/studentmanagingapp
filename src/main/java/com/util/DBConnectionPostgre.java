package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionPostgre 
{
	static String DriverClassName="org.postgresql.Driver";
	static String username="postgres";
	static String password="meet";
	static String ConnectionUrl="jdbc:postgresql://localhost:5432/advance_java";	

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
