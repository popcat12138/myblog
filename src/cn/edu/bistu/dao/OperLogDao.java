package cn.edu.bistu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.common.DbObject;
import cn.edu.bistu.entity.OperLog;

public class OperLogDao {

	public boolean addOperLog(String operator, String content, String userName) {
		System.out.printf(operator, "11", userName);
		String sql = "insert into OperLog (operator,logcontent,userName) values(?,?,?)";

		int iret = DbObject.executeUpdate(sql, operator, content, userName);
		if (iret > 0) {

			return true;
		}
		return false;
	}

	public List<OperLog> findAll() {
		// 时间正序反序
		String sql = "select * from OperLog ORDER BY createTime DESC";
		ResultSet rs = null;
		ArrayList<OperLog> list = new ArrayList<OperLog>();
		try {

			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				OperLog operLog = new OperLog();
				operLog.setLogId(rs.getInt("Logid"));
				operLog.setOperator(rs.getString("operator"));
				operLog.setUserName(rs.getString("userName"));
				operLog.setLogContent(rs.getString("logContent"));
				operLog.setCreateTime(rs.getString("createTime"));
				list.add(operLog);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}

	public List<OperLog> findByUsername(String userName) {
		String sql = "select * from OperLog where userName=?";
		ResultSet rs = null;
		ArrayList<OperLog> list = new ArrayList<OperLog>();
		try {

			rs = DbObject.executeQuery(sql, userName);
			while (rs.next()) {
				OperLog operLog = new OperLog();
				operLog.setLogId(rs.getInt("Logid"));
				operLog.setOperator(rs.getString("operator"));
				operLog.setUserName(rs.getString("userName"));
				operLog.setLogContent(rs.getString("logContent"));
				operLog.setCreateTime(rs.getString("createTime"));
				list.add(operLog);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}

	public List<OperLog> findByOperator(String userName) {
		String sql = "select * from OperLog where operator=?";
		ResultSet rs = null;
		ArrayList<OperLog> list = new ArrayList<OperLog>();
		try {

			rs = DbObject.executeQuery(sql, userName);
			while (rs.next()) {
				OperLog operLog = new OperLog();
				operLog.setLogId(rs.getInt("Logid"));
				operLog.setOperator(rs.getString("operator"));
				operLog.setUserName(rs.getString("userName"));
				operLog.setLogContent(rs.getString("logContent"));
				operLog.setCreateTime(rs.getString("createTime"));
				list.add(operLog);
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
