package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class deleteUserServlet
 */
@WebServlet("/deleteUser")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteUserServlet() {
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
		String userName = (String) request.getParameter("userName");
		// �ж��Ƿ�Ϊ��½
		UserService userService = new UserService();

		if (!userService.isAdmin(operator)) {
			request.setAttribute("errorMessage1", "��¼�����");
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
		}
		if (operator.equals(userName)) {

			response.sendRedirect("listUser?state=" + URLEncoder.encode("����ɾ���Լ���", "utf-8"));
		}

		else {

			userService.deleteUser(operator, userName);
			response.sendRedirect("listUser?state=" + URLEncoder.encode("ɾ���ɹ���", "utf-8"));

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
