package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.UserService;

@WebServlet("/ModifyPassword")

public class ModifyPassword extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModifyPassword() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 没用
		HttpSession session = request.getSession();
		String operator = (String) session.getAttribute("userName");
		String userName = (String) request.getParameter("userName");
		UserService userService = new UserService();

		if (!userService.isAdmin(operator)) {
			request.setAttribute("errorMessage1", "登录后操作");
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
		} else {
			User user = userService.findByUsername(userName);
			request.setAttribute("user", user);
			request.setAttribute("name", operator);

			request.getRequestDispatcher("/alterPassword.jsp").forward(request, response);

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String operator = (String) session.getAttribute("userName");

		String userName = (String) request.getParameter("userName");
		String newPassword = (String) request.getParameter("password");

		request.setAttribute("name", operator);

		User user = new User();

		user.setUserName(userName);
		user.setNewPassword(newPassword);
		String jsonStr;
		UserService userService = new UserService();
		if (newPassword == null || newPassword.equals("")) {
			jsonStr = "{\"success\":false,\"userName\":\"" + userName + "\"}";
			out.write(jsonStr);
			out.close();
		}

		User newUser = userService.alterPassword(operator, user);

		request.setAttribute("user", userService.findByUsername(userName));

		if (newUser == null) {
			jsonStr = "{\"success\":false,\"userName\":\"" + userName + "\"}";
		} else {
			jsonStr = "{\"success\":true,\"userName\":\"" + userName + "\"}";
		}

		out.write(jsonStr);
		out.close();

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
