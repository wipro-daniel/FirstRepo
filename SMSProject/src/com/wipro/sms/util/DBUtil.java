package com.wipro.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
public static	Connection con=null;
public static Connection getConnection()
{
	String url = "jdbc:oracle:thin:@localhost:1522:orcl2";
	String uname="scott";
	String pwd="tiger";
	try {
		con=DriverManager.getConnection(url,uname,pwd);
		System.out.println("Connected");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
	
}
}
