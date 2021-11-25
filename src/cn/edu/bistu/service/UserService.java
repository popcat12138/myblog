package cn.edu.bistu.service;

import java.util.List;

import cn.edu.bistu.dao.UserDao;
import cn.edu.bistu.entity.User;

public class UserService {

	public User findByUsername(String userName) {

		UserDao userDao = new UserDao();
		return (userDao.findByUsername(userName));

	}

	// 用户验证
	public boolean loginVerify(String userName, String password) {

		User user = findByUsername(userName);
		LogService logService = new LogService();

		if (user == null || !user.getPassword().equals(password)) {
			// 失败日志
			logService.addLog("登录失败", userName);
			return false;
		}
		if (user.getUserState().equals("禁用")) {
			logService.addLog("禁用用户登录", userName);
			return true;
		} else {
			// 成功日志
			logService.addLog("登录成功", userName);
			return true;
		}

	}

	public boolean passwordVerify(String userName, String password) {
		User user = findByUsername(userName);
		if (user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean stateVerify(String userName) {
		User user = findByUsername(userName);
		if (user.getUserState().equals("禁用")) {
			return false;
		}
		return true;
	}

	public boolean exists(String userName) {
		return findByUsername(userName) != null;
	}

	public boolean isAdmin(String userName) {

		User user = findByUsername(userName);
		if (user.getIsAdmin().equals("管理员")) {
			return true;
		}
		return false;
	}

	// 用户注册
	public User addUser(User user) {
		if (exists(user.getUserName())) {
			return null;
		}

		UserDao userDao = new UserDao();
		User newUser = userDao.add(user);

		if (newUser != null) {
			LogService logService = new LogService();
			logService.addLog("注册成功", user.getUserName());
		}

		return newUser;

	}

	public User modifyUser(String operator, User user) {

		UserDao userDao = new UserDao();
		User newUser = userDao.alter(user);

		return newUser;
	}

	public User alterUser(String operator, User user) {

		UserDao userDao = new UserDao();
		User newUser = userDao.alter(user);

		if (newUser != null) {
			OperLogService operLogService = new OperLogService();
			operLogService.addOperLog(operator, "修改信息", newUser.getNewName());
		}

		return newUser;
	}

	public User alterPassword(String operator, User user) {

		OperLogService operLogService = new OperLogService();
		operLogService.addOperLog(operator, "管理员修改密码", user.getUserName());

		UserDao userDao = new UserDao();
		User newUser = userDao.alterPassword(user);

		return newUser;
	}

	public User modifyPassword(User user) {

		UserDao userDao = new UserDao();
		User newUser = userDao.modifyPassword(user);

		/*
		 * if (newUser != null) { OperLogService operLogService = new
		 * OperLogService(); operLogService.addOperLog(user.getUserName(),
		 * "用户修改密码", user.getUserName()); }
		 */

		return newUser;
	}

	public void alterState(String operator, String userName, boolean state) {

		UserDao userDao = new UserDao();
		OperLogService operLogService = new OperLogService();
		if (userDao.alterState(userName, state)) {
			operLogService.addOperLog(operator, "修改用户状态为启用", userName);
		} else {
			operLogService.addOperLog(operator, "修改用户状态为禁用", userName);
		}

	}

	public void alterRole(String operator, String userName, boolean role) {

		UserDao userDao = new UserDao();
		OperLogService operLogService = new OperLogService();
		if (userDao.alterRole(userName, role)) {

			operLogService.addOperLog(operator, "修改用户为管理员", userName);
		} else {
			operLogService.addOperLog(operator, "修改用户为普通用户", userName);
		}

	}

	public void deleteUser(String operator, String userName) {
		UserDao userDao = new UserDao();
		OperLogService operLogService = new OperLogService();
		if (userDao.deleteUser(userName)) {
			operLogService.addOperLog(operator, "删除用户" + userName, null);
		}
	}

	public List<User> findAllUser() {
		UserDao userDao = new UserDao();
		return userDao.findAllUser();
	}

	public List<User> fuzzySearchByUserNameWords(String userName) {
		UserDao userDao = new UserDao();
		return (userDao.fuzzySearchByUserNameWords(userName));
	}

	public List<User> findLastUser() {
		UserDao userDao = new UserDao();
		return (userDao.findLastUser());
	}
}
