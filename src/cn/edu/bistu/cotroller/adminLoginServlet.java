package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class adminLoginServlet
 */
@WebServlet("/adminLogin")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminLoginServlet() {
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
		String msg = request.getParameter("mustLogin");
		if (msg != null) {
			request.setAttribute("errorMessage", "�����½����ܽ�����ҳ");
		}

		msg = request.getParameter("logout");

		if (msg != null) {
			request.setAttribute("errorMessage", "���Ѿ�ע����½��");

		}
		request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
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

		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");

		UserService userService = new UserService();

		// if (oUserName.equals(userName) && oPassword.equals(password)){

		if (userService.loginVerify(userName, password)) {

			if (userService.stateVerify(userName)) {
				// ��ȡsenssion,����userName
				HttpSession session = request.getSession();
				request.setAttribute("userName", userName);
				session.setAttribute("userName", userName);

				// 3.��ȷת��ҳ��Ŀ�����

				response.sendRedirect("adminManager?userName=" + URLEncoder.encode(userName, "utf-8"));

			} else {
				request.setAttribute("errorMessage1", "��ǰ�û���ֹ��¼������������ϵ����Ա");
				request.setAttribute("userName", userName);
				RequestDispatcher dispacher = request.getRequestDispatcher("adminLogin.jsp");
				dispacher.forward(request, response);

			}

		} else {

			request.setAttribute("errMessage1", "�û������벻ƥ��");
			request.setAttribute("userName", userName);
			RequestDispatcher dispacher = request.getRequestDispatcher("adminLogin.jsp");
			dispacher.forward(request, response);
		}

	}

}
