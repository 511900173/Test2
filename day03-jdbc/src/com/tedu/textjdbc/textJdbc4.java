package com.tedu.textjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class textJdbc4 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db30","root","rootroot");
		Statement stat = conn.createStatement();
		String sql = "select * from emp";
		ResultSet re = stat.executeQuery(sql);
		while (re.next()) {
			int id  = re.getInt("id");
			String name = re.getString("name");
			int dept_id = re.getInt("dept_id");
			System.out.println(id+":"+name+":"+dept_id);
		}
		re.close();
		stat.close();
		conn.close();
		
	}
}
