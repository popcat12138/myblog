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

@WebServlet("/ModifyRole")
public class ModifyRoleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ModifyRoleServlet() {
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
		String operator = (String) session.getAttribute("userName");

		UserService userService = new UserService();

		String userName = (String) request.getParameter("userName");

		String json;

		if (!userService.isAdmin(operator)) {

			request.setAttribute("errorMessage1", "登录后操作");
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
		}

		if (operator.equals(userName)) {

			json = "{\"success\":\"falseSelf\"}";
			// request.setAttribute("WarnMessage", "不能禁用自己");
			// request.getRequestDispatcher("/listUser").forward(request,
			// response);

		}

		else {
			boolean role = userService.isAdmin(userName);

			if (role) {
				userService.alterRole(operator, userName, role);
				json = "{\"success\":\"trueA\"}";

			} else {
				userService.alterRole(operator, userName, role);
				json = "{\"success\":\"trueB\"}";

			}

		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		out.println(json);
		out.flush();
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
