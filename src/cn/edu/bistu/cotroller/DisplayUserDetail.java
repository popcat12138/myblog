package cn.edu.bistu.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class displayUserDetail
 */
@WebServlet("/DisplayUserDetail")
public class DisplayUserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayUserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userName = (String) request.getParameter("userName");
		String operator = (String) session.getAttribute("userName");
		String state = (String) request.getParameter("state");
		if (userName == null || userName.equals("")) {
			userName = (String) session.getAttribute("userName");
		}
		// System.out.print("11" + state + (String)
		// request.getAttribute("state"));
		UserService userService = new UserService();
		User user = userService.findByUsername(userName);
		request.setAttribute("user", user);
		if (operator == null || operator.equals("")) {
			request.setAttribute("name", "·Ã¿Í");
			request.getRequestDispatcher("/displayUser.jsp").forward(request, response);
			return;
		}
		request.setAttribute("state", state);
		request.setAttribute("name", operator);
		request.getRequestDispatcher("/displayUser.jsp").forward(request, response);

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
