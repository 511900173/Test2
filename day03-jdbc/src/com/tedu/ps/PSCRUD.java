package com.tedu.ps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.tedu.util.JdbcUtil;

/**
 * PreparedStantement对象的增删改查
 */
public class PSCRUD {
	/** 1.查询user表中的所有信息 */
	@Test
	public void testFindAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id")+":"
						+rs.getString("username")+":"+rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}				
	}

	/** 2.修改id为2的用户的密码,将密码改为123456 */
	@Test
	public void testUpdate() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			String psd = "123456";
			String id2 = "2";
			String sql = "update user set password=? where id=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, psd);
			ps.setString(2, id2);
			int ros = ps.executeUpdate();
			if (ros==1) {
				System.out.println("修改成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
				
	}
	/** 3.新增:往user表中添加一个username为张三、password为123的记录 */
	@Test
	public void testInsert() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			String name = "张三";
			String pwd = "123";
			String sql = "insert into user values(null,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			int row = ps.executeUpdate();
			System.out.println("受影响的行数:"+row);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
	}
	/* 4.删除:删除user表中username为'张三'的记录 */
	@Test
	public void testDelete() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			String name = "'张三'";
			String sql = "delete from user where username=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			int row = ps.executeUpdate();
			if (row==1) {
				System.out.println("删除成功");
			} else {
				System.out.println("失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
	}
	
	
}




















