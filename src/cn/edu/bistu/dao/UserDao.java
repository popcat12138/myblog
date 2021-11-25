package cn.edu.bistu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.common.DbObject;
import cn.edu.bistu.entity.User;

public class UserDao {
	public User findByUsername(String userName) {

		String sql = "select * from Users where UserName=?";
		ResultSet rs = null;
		User user = null;
		try {

			// 4. 执行SQL语句
			// insert into Users (UserName,Password,FullName)
			// values('001','p001','f001')
			rs = DbObject.executeQuery(sql, userName);
			if (rs.next()) {
				user = new User();
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("fullName"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("userEmail"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("phoneNum"));
				user.setMyWords(rs.getString("myWords"));
				user.setWeiXin(rs.getString("weiXin"));
				user.setUserState(rs.getString("state"));
				user.setIsAdmin(rs.getString("role"));
				user.setCreateTime(rs.getString("registerTime"));
				user.setAlterTime(rs.getString("alterTime"));
				user.setImgPath(rs.getString("imgPath"));
				// return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return user;

	}

	public User add(User user) {
		// 0. 获取一个user对象的唯一标识（即检索是否有这个用户）
		// 1. 调用数据访问对象，把user保存至数据库
		// 2. 调用日志服务对象，添加一条用户注册的日志

		String sql = "insert into Users (UserName,password,fullName,sex,birthday,phoneNum,userEmail,weiXin,myWords,imgPath) values(?,?,?,?,?,?,?,?,?,?)";

		DbObject.executeUpdate(sql, user.getUserName(), user.getPassword(), user.getFullName(), user.getSex(),
				user.getBirthday(), user.getTel(), user.getEmail(), user.getWeiXin(), user.getMyWords(),
				user.getImgPath());

		return user;
	}

	public User alter(User user) {
		String sql = "update Users set alterTime=NOW(),Username=? ,sex= ?, fullname=?,mywords=?,birthday=?,userEmail=?,weixin=?,phoneNum=?,imgPath=? where UserName=?";

		DbObject.executeUpdate(sql, user.getNewName(), user.getSex(), user.getFullName(), user.getMyWords(),
				user.getBirthday(), user.getEmail(), user.getWeiXin(), user.getTel(), user.getImgPath(),
				user.getUserName());

		return user;
	}

	public User modifyPassword(User user) {
		String sql = "update Users set password=? where UserName=? and password=?";
		int iret = DbObject.executeUpdate(sql, user.getNewPassword(), user.getUserName(), user.getPassword());

		if (iret > 0) {
			return user;
		}

		return null;
	}

	public User alterPassword(User user) {
		String sql = "update Users set password=? where UserName=?";

		DbObject.executeUpdate(sql, user.getNewPassword(), user.getUserName());

		return user;
	}

	public boolean alterState(String userName, boolean state) {
		if (!state) {
			String sql = "update Users set state=" + "'启用'" + " where UserName=?";
			DbObject.executeUpdate(sql, userName);
			return true;
		} else {
			String sql = "update Users set state=" + "'禁用'" + " where UserName=?";

			DbObject.executeUpdate(sql, userName);
			return false;
		}

	}

	public boolean alterRole(String userName, boolean role) {
		if (role) {
			String sql = "update Users set role=" + "'普通用户'" + " where UserName=?";
			DbObject.executeUpdate(sql, userName);
			return false;
		} else {
			String sql = "update Users set role=" + "'管理员'" + " where UserName=?";
			DbObject.executeUpdate(sql, userName);
			return true;
		}
	}

	public boolean deleteUser(String userName) {

		String sql = "delete from Users where UserName=?";
		int iret = DbObject.executeUpdate(sql, userName);
		if (iret > 0) {

			return true;
		}
		return false;
	}

	public List<User> fuzzySearchByUserNameWords(String userName) {
		String sql = "select * from Users where UserName like ? or myWords like ?";
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			rs = DbObject.executeQuery(sql, "%" + userName + "%", "%" + userName + "%");

			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("fullName"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("userEmail"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("phoneNum"));
				user.setMyWords(rs.getString("myWords"));
				user.setWeiXin(rs.getString("weiXin"));
				user.setUserState(rs.getString("state"));
				user.setIsAdmin(rs.getString("role"));
				user.setCreateTime(rs.getString("registerTime"));
				user.setImgPath(rs.getString("imgPath"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;
	}

	public List<User> fuzzySearchByMyWords(String myWords) {
		String sql = "select * from Users where myWords like '%?%'";
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			rs = DbObject.executeQuery(sql, myWords);

			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("fullName"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("userEmail"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("phoneNum"));
				user.setMyWords(rs.getString("myWords"));
				user.setWeiXin(rs.getString("weiXin"));
				user.setUserState(rs.getString("state"));
				user.setIsAdmin(rs.getString("role"));
				user.setCreateTime(rs.getString("registerTime"));
				user.setImgPath(rs.getString("imgPath"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;
	}

	public List<User> findAllUser() {
		// where isAdmin='no'
		String sql = "select * from Users ";
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			rs = DbObject.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("fullName"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("userEmail"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("phoneNum"));
				user.setMyWords(rs.getString("myWords"));
				user.setWeiXin(rs.getString("weiXin"));
				user.setUserState(rs.getString("state"));
				user.setIsAdmin(rs.getString("role"));
				user.setCreateTime(rs.getString("registerTime"));
				user.setImgPath(rs.getString("imgPath"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}

	public List<User> findLastUser() {
		String sql = "select * from Users ORDER BY registerTime DESC LIMIT 0,15";
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			rs = DbObject.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("fullName"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("userEmail"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("phoneNum"));
				user.setMyWords(rs.getString("myWords"));
				user.setWeiXin(rs.getString("weiXin"));
				user.setUserState(rs.getString("state"));
				user.setIsAdmin(rs.getString("role"));
				user.setCreateTime(rs.getString("registerTime"));
				user.setImgPath(rs.getString("imgPath"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}

	// 没用
	public List<User> findAllAdmin() {
		String sql = "select * from Users where isAdmin='yes'";
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			rs = DbObject.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("userName"));
				user.setFullName(rs.getString("fullName"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("userEmail"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("phoneNum"));
				user.setMyWords(rs.getString("myWords"));
				user.setWeiXin(rs.getString("weiXin"));
				user.setUserState(rs.getString("state"));
				user.setIsAdmin(rs.getString("role"));
				user.setCreateTime(rs.getString("registerTime"));
				user.setImgPath(rs.getString("imgPath"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}

}
