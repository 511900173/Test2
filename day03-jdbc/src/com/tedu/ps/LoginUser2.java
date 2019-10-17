package com.tedu.ps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.tedu.util.JdbcUtil;

/**
 * 模拟用户登录
 */

public class LoginUser2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 1.提示用户登录
		System.out.println("请登录");
		// 2.提示用户输入用户名
		System.out.println("请输入用户名");
		String user = in.nextLine();
		// 3.提示用户输入密码
		System.out.println("请输入密码");
		String pwd = in.nextLine();
		System.out.println(user+":"+pwd);
		// 4.调动方法根据用户名和密码进行登录
		login(user,pwd);
	}
	
	/** 根据用户名和密码查询用户信息 */
	private static void login(String user, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			// 获取传输器
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			// 设置参数
			ps.setString(1, user);
			ps.setString(2, pwd);
			//执行sql语句返回执行结果
			rs = ps.executeQuery();
			if (rs.next()) { // 用户密码正确
				System.out.println("登录成功");
			} else {
				System.out.println("登录失败,用户名或密码错误");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		
		
	}
	
	
}
























