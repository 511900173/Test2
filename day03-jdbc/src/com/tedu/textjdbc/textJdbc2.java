package com.tedu.textjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class textJdbc2 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(""
				+ "jdbc:mysql://localhost:3306/db80","root","root");
		Statement sta = c.createStatement();
		String sql = "select * from dept";
		ResultSet re = sta.executeQuery(sql);
		while (re.next()) {
			int id = re.getInt("id");
			String name = re.getString("name");
			String loc = re.getString("loc");
			System.out.println(id+":"+name+":"+loc);
			
		}
		re.close();
		sta.close();
		c.close();
		
		
		
		
		
	}
}
