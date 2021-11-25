package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.Log;
import cn.edu.bistu.entity.OperLog;
import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.LogService;
import cn.edu.bistu.service.OperLogService;
import cn.edu.bistu.service.UserService;

@WebServlet("/LogSearchByOper")
public class LogSearchByOper extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LogSearchByOper() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String name = (String) request.getParameter("userName");
		UserService userService = new UserService();

		LogService logService = new LogService();
		List<Log> loglist = logService.findAll();

		OperLogService operLogService = new OperLogService();
		List<OperLog> operlist = operLogService.findByOperator(name);

		User user = userService.findByUsername(userName);
		request.setAttribute("loglist", loglist);
		request.setAttribute("operlist", operlist);
		request.setAttribute("user", user);
		request.setAttribute("name", userName);

		request.getRequestDispatcher("/logSearch.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
