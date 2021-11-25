package cn.edu.bistu.service;

import java.util.List;

import cn.edu.bistu.dao.LogDao;
import cn.edu.bistu.entity.Log;

public class LogService {
	public boolean addLog(String content, String userName) {
		LogDao logDao = new LogDao();
		return logDao.addLog(content, userName);
	}

	public List<Log> findAll() {
		LogDao logDao = new LogDao();
		return logDao.findAll();
	}
}
