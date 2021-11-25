package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class managerServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" }, initParams = { @WebInitParam(name = "username", value = "����"),
		@WebInitParam(name = "password", value = "123") }

)
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg = request.getParameter("mustLogin");
		if (msg != null) {
			request.setAttribute("errorMessage", "�����½����ܽ����ҳ�棡");
		}

		msg = request.getParameter("logout");

		if (msg != null) {
			request.setAttribute("errorMessage", "���Ѿ�ע����½��");

		}
		RequestDispatcher dispacher = request.getRequestDispatcher("/login.jsp");
		dispacher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sessionCacheData = (String) request.getSession().getAttribute("sessionCacheData");
		String verifyCode = (String) request.getParameter("verifyCode");

		if (!sessionCacheData.equalsIgnoreCase(verifyCode)) {
			request.setAttribute("errMessage", "��֤���������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");

		UserService userService = new UserService();

		// if (oUserName.equals(userName) && oPassword.equals(password)){

		if (!userService.exists(userName)) {
			request.setAttribute("errMessage", "û�е�ǰ�û�");
			request.setAttribute("userName", userName);
			RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
			dispacher.forward(request, response);
			return;
		}

		if (userService.loginVerify(userName, password)) {
			if (userService.stateVerify(userName)) {
				// ��ȡsenssion,����userName
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);

				// 3.��ȷת��ҳ��Ŀ�����

				response.sendRedirect("main?userName=" + URLEncoder.encode(userName, "utf-8"));
				return;

			} else {
				request.setAttribute("errMessage", "��ֹ��¼������������ϵ����Ա");
				request.setAttribute("userName", userName);
				RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
				dispacher.forward(request, response);
				return;
			}

		} else {

			request.setAttribute("errMessage", "�û������벻ƥ��");
			request.setAttribute("userName", userName);
			RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
			dispacher.forward(request, response);
			return;
		}

	}

}
