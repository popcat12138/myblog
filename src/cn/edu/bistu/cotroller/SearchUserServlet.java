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

@WebServlet("/SearchUser")
public class SearchUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SearchUserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) request.getParameter("userName");
		String operator = (String) session.getAttribute("userName");
		if (userName == null || userName.equals("")) {
			userName = (String) session.getAttribute("userName");
		}

		UserService userService = new UserService();

		List<User> list = userService.findLastUser();

		request.setAttribute("listUser", list);

		User user = userService.findByUsername(userName);
		request.setAttribute("result", "最新用户（打个招呼吧！）");
		request.setAttribute("user", user);
		if (operator == null || operator.equals("")) {
			request.setAttribute("name", "访客");
			request.getRequestDispatcher("/searchUser.jsp").forward(request, response);
			return;
		}
		request.setAttribute("name", operator);
		request.getRequestDispatcher("/searchUser.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) request.getParameter("userName");
		String key = (String) request.getParameter("key");
		String operator = (String) session.getAttribute("userName");
		if (userName == null || userName.equals("")) {
			userName = (String) session.getAttribute("userName");
		}

		UserService userService = new UserService();

		List<User> list = userService.fuzzySearchByUserNameWords(key);
		request.setAttribute("listUser", list);

		request.setAttribute("result", "按关键词" + key);

		User user = userService.findByUsername(userName);
		request.setAttribute("user", user);
		if (operator == null || operator.equals("")) {
			request.setAttribute("name", "访客");
			request.getRequestDispatcher("/searchUser.jsp").forward(request, response);
			return;
		}
		request.setAttribute("name", operator);
		request.getRequestDispatcher("/searchUser.jsp").forward(request, response);

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
