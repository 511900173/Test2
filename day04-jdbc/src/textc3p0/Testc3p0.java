package textc3p0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.util.JdbcUtil;

public class Testc3p0 {
	@Test
	public void text() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		ComboPooledDataSource comb = new ComboPooledDataSource();
		try {
			conn = comb.getConnection();
			stat = conn.createStatement();
//			String sql = find();
//			String sql = insert();
//			String sql = update();
			String sql = delete();
//			rs = stat.executeQuery(sql);
			int ros = stat.executeUpdate(sql);
			System.out.println("更新"+ros+"条记录");
//			while (rs.next()) {
//				System.out.println(rs.getString("id")+"-"+rs.getString("username")+"-"+rs.getString("password"));
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stat, rs);
		}
		
		
	}

	private String delete() {
		return "delete from user where username='张三丰'";
	}
	private String find() {
		return "select * from user";
	}
	private String insert() {
		return "insert into user values(null,'张三丰','456')";
	}
	private String update() {
		return "update user set password='1236789' where username='张三丰' ";
	}
}
