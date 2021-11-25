package cn.edu.bistu.service;

import java.util.List;

import cn.edu.bistu.dao.OperLogDao;
import cn.edu.bistu.entity.OperLog;

public class OperLogService {
	public boolean addOperLog(String operator, String content, String userName) {
		OperLogDao operLogDao = new OperLogDao();
		return operLogDao.addOperLog(operator, content, userName);
	}

	public List<OperLog> findAll() {
		OperLogDao operLogDao = new OperLogDao();
		return operLogDao.findAll();
	}

	public List<OperLog> findByUserName(String userName) {
		OperLogDao operLogDao = new OperLogDao();
		return operLogDao.findByUsername(userName);
	}

	public List<OperLog> findByOperator(String userName) {
		OperLogDao operLogDao = new OperLogDao();
		return operLogDao.findByOperator(userName);
	}
}
