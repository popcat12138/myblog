package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class listUserServlet
 */
@WebServlet("/listUser")
public class listUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listUserServlet() {
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

		String state = (String) request.getParameter("state");

		UserService userService = new UserService();

		if (!userService.isAdmin(userName) || userName == null || userName.equals("")) {
			request.setAttribute("errorMessage1", "登录后操作");
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
		} else {

			User user = userService.findByUsername(userName);
			request.setAttribute("user", user);
			request.setAttribute("state", state);
			request.setAttribute("name", userName);

			List<User> list = userService.findAllUser();
			// 显示用户列表
			request.setAttribute("list", list);
			request.getRequestDispatcher("/listUser.jsp").forward(request, response);

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
