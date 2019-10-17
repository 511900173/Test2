package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import p.pwd;

/**
 * 实现Jdbc的快速入门 通过程序连接jt_db库,查询account表中的所有记录,并输出到控制台
 */
public class jdbcDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			// 1.注册数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取数据库连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db", "root", pwd.p());
//			Connection con =  DriverManager.getConnection("jdbc:mysql:///jt_db?characterEncoding=utf-8","root","root")
			// 3.获取传输器
			stat = conn.createStatement();
			// 4.利用传输器发送sql到服务器执行,并返回执行结果
			String sql = "select * from account";
			rs = stat.executeQuery(sql);
//			stat.executeUpdate(sql);
			// 5.处理结果
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double money = rs.getDouble("money");
				System.out.println(id + ":" + name + ":" + money);
			}
			System.out.println("jdbcDemo1.main()");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					rs = null;
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					stat = null;
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;
				}
			}
		}
	}
}
