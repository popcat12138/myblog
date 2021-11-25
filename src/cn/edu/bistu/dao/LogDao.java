package cn.edu.bistu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.common.DbObject;
import cn.edu.bistu.entity.Log;

public class LogDao {
	public boolean addLog(String content, String userName) {

		String sql = "insert into Log (logcontent,UserName) values(?,?)";

		int iret = DbObject.executeUpdate(sql, content, userName);
		if (iret > 0) {

			return true;
		}
		return false;
	}

	public List<Log> findAll() {
		// 最新动态30条
		String sql = "select * from Log ORDER BY LogTime DESC LIMIT 0,30";
		ResultSet rs = null;
		ArrayList<Log> list = new ArrayList<Log>();
		try {

			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				Log log = new Log();
				log.setLogId(rs.getInt("logId"));
				log.setUserName(rs.getString("userName"));
				log.setLogContent(rs.getString("logContent"));
				log.setCreateTime(rs.getString("logTime"));
				list.add(log);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}

	// 没用
	public List<Log> findByUsername(String userName) {

		String sql = "select * from Log where UserName=?";
		ResultSet rs = null;
		ArrayList<Log> list = new ArrayList<Log>();
		try {

			rs = DbObject.executeQuery(sql, userName);
			while (rs.next()) {
				Log log = new Log();
				log.setLogId(rs.getInt("logId"));
				log.setUserName(rs.getString("userName"));
				log.setLogContent(rs.getString("logContent"));
				log.setCreateTime(rs.getString("logTime"));
				list.add(log);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}
}
