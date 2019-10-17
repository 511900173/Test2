package com.tedu.textjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class textJdbc {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db40","root","root");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db", "root", "root");
		Statement se = conn.createStatement();
		String s = "select * from emp";
		ResultSet re = se.executeQuery(s);
		while (re.next()) {
			int id = re.getInt("id");
			String name = re.getString("name");
			String job = re.getString("job");
			int topid = re.getInt("topid");
			String hdate = re.getString("hdate");
			double sal = re.getDouble("sal");
			double bonus = re.getDouble("bonus");
			int dept_id = re.getInt("dept_id");
			System.out.println(id+":"+name+":"+job+":"+topid+":"+hdate+":"+sal+":"+bonus+":"+dept_id);
			
		}
		re.close();
		se.close();
		conn.close();
		
		
	}
}
