package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tedu.util.JdbcUtil;

import p.pwd;

/**
 * 
 * Jdbc的增删改查
 * C:create 增加
 * R: retrieve 读取
 * U: update 修改
 * D: delete 删除
 */
public class JdbcCRUD {
	/**1.往Accout表中添加一条记录:
	 * john 3000*/
	@Test
	public void testADD() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//注册驱动并获取连接
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///jt_db?characterEnconding=utf-8","root", pwd.p());
			//获取传输器
			stat = conn.createStatement();
			//执行sql语句,返回执行结果
			String sql = "insert into account values(null,'john',3000)";
			int rows = stat.executeUpdate(sql);
			//处理结果
			System.out.println("影响行数:"+rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stat, rs);
		}
	}
	
	/**2.查询account表中id为2的记录*/
	@Test
	public void testFind() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			stat = conn.createStatement();
			String sql = "select * from account where id=2";
			rs = stat.executeQuery(sql);
			if (rs.next()) { 
			System.out.println(rs.getInt("id")+":"
					+rs.getString("name")+":"+rs.getDouble("money"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stat, rs);
		}		
	}
	
	/**3.修改account表中name为John的记录
	 * 将金额修改为6600*/
	@Test
	public void testUpdate() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			stat = conn.createStatement();
			String sql = "update account set money=6600 where name='john";
			int row = stat.executeUpdate(sql);
			if (row==1) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stat, rs);
		}	
	}
	/**4.删除account表中name为John的记录*/
	@Test
	public void testDelect() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			stat = conn.createStatement();
			String sql = "delete from account where name='john'";
			int row = stat.executeUpdate(sql);
			System.out.println("影响的行数:"+row);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stat, rs);
		}
	
	}
	
	
	
}














