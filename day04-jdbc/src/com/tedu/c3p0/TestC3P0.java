package com.tedu.c3p0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import p.pwd;



/**
 * 实现Jdbc的快速入门 通过程序连接jt_db库,查询account表中的所有记录,并输出到控制台
 */
public class TestC3P0 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		// 创建一个连接池(对象)
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			// 设置连接数据库的基本信息
//			pool.setDriverClass("com.mysql.jdbc.Driver");
//			pool.setJdbcUrl("jdbc:mysql:///jt_db?characterEncoding=utf-8");
//			pool.setUser("root");
//			pool.setPassword(pwd.p());
			// 从连接池中获取一个连接对象
			conn = pool.getConnection();
			
			// 设置取消自动提交事物(改为手动提交)
//			conn.setAutoCommit(false);
			
			// 3.获取传输器
			stat = conn.createStatement();
			// 4.利用传输器发送sql到服务器执行,并返回执行结果
			String sql = "select * from account";
			rs = stat.executeQuery(sql);
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
