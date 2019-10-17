package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.tedu.util.JdbcUtil;

public class testzscg {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	public static void main(String[] args) {
		try {
			run();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
	}	
	
	private static void run() throws Exception {
		while (true) {
			Scanner in = new Scanner(System.in);
			tishi();
			String cos = in.nextLine();
			if (cos.equals("a")) {
				find();
			} else
			if (cos.equals("b")) {
				add();
			} else
			if (cos.equals("c")) {
				update();
			} else
			if (cos.equals("d")) {
				delete();
			} else
			if (cos.equals("exit")) {
				System.out.println("退出");
				return;
			} else {
				System.out.println("输入不正确,重新输入");
			}
		}
	}
	
	private static void delete() throws Exception {
			conn = JdbcUtil.getConn();
			Scanner in = new Scanner(System.in);
			System.out.println("请输入学生id:");
			String id = in.nextLine();
			if (!panduan(id)) {
				System.out.println("id不存在");
				return;
			}
			String sql = "delete from student where id=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int ros = ps.executeUpdate();
			if (ros==1) {
				System.out.println("删除成功");
			}
	}
	
	private static void update() throws Exception {
			conn = JdbcUtil.getConn();
			Scanner in = new Scanner(System.in);
			System.out.println("请输入学生id:");
			String id = in.nextLine();
			if (!panduan(id)) {
				System.out.println("id不存在");
				return;
			}
//			System.out.println("请输入名字:");
//			String name = in.nextLine();
//			System.out.println("请输入性别:");
//			String gender = in.nextLine();
			System.out.println("请输入成绩:");
			String score = in.nextLine();	
//			String sql = "update student set name=?,gender=?,score=? where id=? ";
			String sql = "update student set score=? where id=? ";
			ps = conn.prepareStatement(sql);
//			ps.setString(1, name);
//			ps.setString(2, gender);
			ps.setString(1, score);
			ps.setString(2, id);
			int ros = ps.executeUpdate();
			System.out.println("成功修改"+ros+"学生信息");
	}
	
	private static void add() throws Exception {
			conn = JdbcUtil.getConn();
			Scanner in = new Scanner(System.in);
			System.out.println("请输入学生id:");
			String id = in.nextLine();
			if (panduan(id)) {
				System.out.println("id已存在");
				return;
			}
			System.out.println("请输入名字:");
			String name = in.nextLine();
			System.out.println("请输入性别:");
			String gender = in.nextLine();
			System.out.println("请输入成绩:");
			String score = in.nextLine();
			String sql = "insert into student values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, score);
			int ros = ps.executeUpdate();
			System.out.println("增加成功,更新"+ros+"条学生信息");
	}
	
	private static boolean panduan(String id) throws Exception {
		conn = JdbcUtil.getConn();
		String sql = "select * from student";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			if (id.equals(rs.getString("id"))) {
				return true;
			}
		}
		return false;
	}

	private static void find() throws Exception {	
			conn = JdbcUtil.getConn();
			String sql = "select * from student";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id")+":"+rs.getString("name")+":"+rs.getString("gender")+":"+rs.getInt("score"));
			}	
	}

	private static void tishi() {
		System.out.println("a.查询学生信息"+"-b.添加学生信息"+"-c.修改学生成绩"+"-d.删除学生信息"+"-exit-退出");
	}
}
