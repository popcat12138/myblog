package cn.edu.bistu.cotroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
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
		RequestDispatcher dispacher = request.getRequestDispatcher("/register.jsp");
		dispacher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (ServletFileUpload.isMultipartContent(request)) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> list = upload.parseRequest(request);
				User user = new User();
				// String sessionCacheData = (String)
				// request.getSession().getAttribute("sessionCacheData");
				for (FileItem fileItem : list) {

					if (fileItem.isFormField()) {
						// ��ͨ
						String name = fileItem.getFieldName();
						if ("userName".equals(name)) {
							user.setUserName(fileItem.getString("utf-8"));
						}
						if ("fullName".equals(name)) {
							user.setFullName(fileItem.getString("utf-8"));
						}
						if ("sex".equals(name)) {
							user.setSex(fileItem.getString("utf-8"));
						}
						if ("birthday".equals(name)) {
							user.setBirthday(fileItem.getString("utf-8"));
						}
						if ("tel".equals(name)) {
							user.setTel(fileItem.getString("utf-8"));
						}
						if ("email".equals(name)) {
							user.setEmail(fileItem.getString("utf-8"));
						}
						if ("myWords".equals(name)) {
							user.setMyWords(fileItem.getString("utf-8"));
						}
						if ("password".equals(name)) {
							user.setPassword(fileItem.getString("utf-8"));
						}
						if ("password".equals(name)) {
							user.setNewPassword(fileItem.getString("utf-8"));
						}
						if ("weiXin".equals(name)) {
							user.setWeiXin(fileItem.getString("utf-8"));
						}

					} else {
						if (fileItem.getName().equals("") || fileItem == null) {
							user.setImgPath("img/default.jpeg");
							// ���û���µ�ͷ�񣬲�ִ�������
						} else {
							// �ļ�
							String name = UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileItem.getName();
							// ��ȡ·��
							String root = this.getServletContext().getRealPath("/img/");
							FileOutputStream os = new FileOutputStream(root + "/" + name);
							IOUtils.copy(fileItem.getInputStream(), os);
							os.close();
							String vPath = "img/" + name;
							user.setImgPath(vPath);
						}
					}
				}
				if (user.getUserName().length() <= 12 && user.getUserName().length() >= 2) {
					if (user.getNewPassword().equals(user.getPassword())) {
						// ����
						UserService userService = new UserService();
						user = userService.addUser(user);
						if (user != null) {
							request.setAttribute("user", user);
							request.setAttribute("success", "ע��ɹ�!");
							request.getRequestDispatcher("/login.jsp").forward(request, response);
							return;
						} else {
							request.setAttribute("user", user);
							request.setAttribute("error", "ע��ʧ��!");
							request.getRequestDispatcher("/register.jsp").forward(request, response);
							return;
						}
						// ת��

					}
					request.setAttribute("user", user);
					request.setAttribute("error", "�������벻��ͬ��");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					return;
				}
				request.setAttribute("user", user);
				request.setAttribute("error", "�û�������2-12");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
