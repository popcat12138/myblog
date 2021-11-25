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

@WebServlet("/VerifyPassword")
public class VerifyPasswordServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public VerifyPasswordServlet() {
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

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String password = request.getParameter("Oldpassword");

		UserService userService = new UserService();
		String jsonStr;
		if (userService.passwordVerify(userName, password)) {
			jsonStr = "{\"success\":true,\"userName\":\"" + userName + "\"}";

		} else {

			jsonStr = "{\"success\":false,\"userName\":\"" + userName + "\"}";
		}
		;

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
