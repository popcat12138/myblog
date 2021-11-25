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

/**
 * Servlet implementation class logSearchServlet
 */
@WebServlet("/logSearch")
public class logSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		// ÅÐ¶ÏÊÇ·ñÎªµÇÂ½

		UserService userService = new UserService();

		if (!userService.isAdmin(userName)) {
			request.setAttribute("errorMessage1", "µÇÂ¼ºó²Ù×÷");
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
		} else {
			LogService logService = new LogService();
			List<Log> loglist = logService.findAll();

			OperLogService operLogService = new OperLogService();
			List<OperLog> operlist = operLogService.findAll();

			User user = userService.findByUsername(userName);
			request.setAttribute("loglist", loglist);
			request.setAttribute("operlist", operlist);
			request.setAttribute("user", user);
			request.setAttribute("name", userName);

			request.getRequestDispatcher("/logSearch.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
