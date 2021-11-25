package cn.edu.bistu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DbObject {
	// jdbc:mysql://localhost:3306/db_cjky?useUnicode=true&characterEncoding=utf8
	public static final String url = "jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf8";
	public static final String user = "root";
	public static final String password = "password";

	public static Connection getConnection() {
		Connection connection = null;
		Statement st = null;
		// 1. 注册驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到合适的数据库驱动！" + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("不能连接数据库！" + e.getMessage());
		}
	}

	public static ResultSet executeQuery(String sql, Object... param) {
		PreparedStatement st = null;
		ResultSet rs = null; // 在线结果集
		CachedRowSet crs = null;// 离线结果集

		Connection cn = getConnection();

		try {
			st = cn.prepareStatement(sql);

			for (int i = 0; i < param.length; i++) {
				st.setObject(i + 1, param[i]);
			}

			rs = st.executeQuery();

			crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(rs);

			return crs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("SQL执行错误" + e.getMessage());
		} finally {
			close(cn, st, rs);
		}
	}

	public static int executeUpdate(String sql, Object... param) {
		PreparedStatement st = null;
		Connection cn = getConnection();

		try {
			st = cn.prepareStatement(sql);

			for (int i = 0; i < param.length; i++) {
				st.setObject(i + 1, param[i]);
			}

			int ret = st.executeUpdate();
			return ret;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("SQL执行错误" + e.getMessage());
		} finally {
			close(cn, st, null);
		}
	}

	public static void close(Connection cn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
