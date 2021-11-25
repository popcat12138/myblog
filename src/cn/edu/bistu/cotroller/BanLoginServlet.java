package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class BanLog
 */
@WebServlet("/BanLogin")
public class BanLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BanLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String operator = (String) session.getAttribute("userName");

		UserService userService = new UserService();

		String userName = (String) request.getParameter("userName");

		String json;

		if (!userService.isAdmin(operator)) {

			request.setAttribute("errorMessage1", "登录后操作");
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
			return;
		}

		if (operator.equals(userName)) {
			json = "{\"success\":\"falseSelf\"}";
			// request.setAttribute("WarnMessage", "不能禁用自己");
			// request.getRequestDispatcher("/listUser").forward(request,
			// response);
			/*
			 * response.setContentType("application/json"); PrintWriter out =
			 * response.getWriter();
			 * 
			 * out.println(json);
			 * 
			 * out.flush(); out.close();
			 */
		}

		else {
			boolean state = userService.stateVerify(userName);

			if (state) {
				userService.alterState(operator, userName, state);
				json = "{\"success\":\"trueA\"}";

			} else {
				userService.alterState(operator, userName, state);
				json = "{\"success\":\"trueB\"}";

			}

		}

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		out.println(json);
		out.flush();
		out.close();

		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// request.getRequestDispatcher("/listUser").forward(request, response);

	}

}
