package cn.edu.bistu.service;

import java.util.List;

import cn.edu.bistu.dao.UserDao;
import cn.edu.bistu.entity.User;

public class UserService {

	public User findByUsername(String userName) {

		UserDao userDao = new UserDao();
		return (userDao.findByUsername(userName));

	}

	// �û���֤
	public boolean loginVerify(String userName, String password) {

		User user = findByUsername(userName);
		LogService logService = new LogService();

		if (user == null || !user.getPassword().equals(password)) {
			// ʧ����־
			logService.addLog("��¼ʧ��", userName);
			return false;
		}
		if (user.getUserState().equals("����")) {
			logService.addLog("�����û���¼", userName);
			return true;
		} else {
			// �ɹ���־
			logService.addLog("��¼�ɹ�", userName);
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
		if (user.getUserState().equals("����")) {
			return false;
		}
		return true;
	}

	public boolean exists(String userName) {
		return findByUsername(userName) != null;
	}

	public boolean isAdmin(String userName) {

		User user = findByUsername(userName);
		if (user.getIsAdmin().equals("����Ա")) {
			return true;
		}
		return false;
	}

	// �û�ע��
	public User addUser(User user) {
		if (exists(user.getUserName())) {
			return null;
		}

		UserDao userDao = new UserDao();
		User newUser = userDao.add(user);

		if (newUser != null) {
			LogService logService = new LogService();
			logService.addLog("ע��ɹ�", user.getUserName());
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
			operLogService.addOperLog(operator, "�޸���Ϣ", newUser.getNewName());
		}

		return newUser;
	}

	public User alterPassword(String operator, User user) {

		OperLogService operLogService = new OperLogService();
		operLogService.addOperLog(operator, "����Ա�޸�����", user.getUserName());

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
		 * "�û��޸�����", user.getUserName()); }
		 */

		return newUser;
	}

	public void alterState(String operator, String userName, boolean state) {

		UserDao userDao = new UserDao();
		OperLogService operLogService = new OperLogService();
		if (userDao.alterState(userName, state)) {
			operLogService.addOperLog(operator, "�޸��û�״̬Ϊ����", userName);
		} else {
			operLogService.addOperLog(operator, "�޸��û�״̬Ϊ����", userName);
		}

	}

	public void alterRole(String operator, String userName, boolean role) {

		UserDao userDao = new UserDao();
		OperLogService operLogService = new OperLogService();
		if (userDao.alterRole(userName, role)) {

			operLogService.addOperLog(operator, "�޸��û�Ϊ����Ա", userName);
		} else {
			operLogService.addOperLog(operator, "�޸��û�Ϊ��ͨ�û�", userName);
		}

	}

	public void deleteUser(String operator, String userName) {
		UserDao userDao = new UserDao();
		OperLogService operLogService = new OperLogService();
		if (userDao.deleteUser(userName)) {
			operLogService.addOperLog(operator, "ɾ���û�" + userName, null);
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
