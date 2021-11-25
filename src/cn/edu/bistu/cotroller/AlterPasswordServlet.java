package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class modifyPasswordServlet
 */
@WebServlet("/AlterPassword")
public class AlterPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterPasswordServlet() {
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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		UserService userService = new UserService();

		User user = userService.findByUsername(userName);
		request.setAttribute("user", user);
		request.setAttribute("name", userName);
		request.getRequestDispatcher("/modifyUserpassword.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String password = (String) request.getParameter("oldPassword");
		String newPassword = (String) request.getParameter("password");

		request.setAttribute("name", userName);

		User user = new User();

		user.setUserName(userName);
		user.setPassword(password);
		user.setNewPassword(newPassword);

		UserService userService = new UserService();
		User newUser = userService.modifyPassword(user);

		if (newUser == null) {
			response.sendRedirect("DisplayUserDetail?state=" + URLEncoder.encode("修改失败！", "utf-8"));
			return;
		}
		response.sendRedirect("DisplayUserDetail?state=" + URLEncoder.encode("修改成功！", "utf-8"));

	}

}
