package cn.edu.bistu.cotroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class InfoManagerServlet
 */
@WebServlet("/AlterUserDetail")
public class AlterUserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterUserDetail() {
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
		request.getRequestDispatcher("/InfoManager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> list = upload.parseRequest(request);
				User user = new User();
				for (FileItem fileItem : list) {

					if (fileItem.isFormField()) {
						// 普通
						String name = fileItem.getFieldName();
						if ("newName".equals(name)) {
							user.setNewName(fileItem.getString("utf-8"));
						}
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
						if ("weiXin".equals(name)) {
							user.setWeiXin(fileItem.getString("utf-8"));
						}
						if ("imgPath".equals(name)) {
							user.setImgPath(fileItem.getString("utf-8"));
						}

					} else {
						if (fileItem.getName().equals("") || fileItem == null) {
							// 如果没有新的头像，不执行下面的
						} else {
							// 文件
							String name = UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileItem.getName();
							// 获取路径
							String root = this.getServletContext().getRealPath("/img/");
							FileOutputStream os = new FileOutputStream(root + "/" + name);
							IOUtils.copy(fileItem.getInputStream(), os);
							os.close();
							String vPath = "img/" + name;
							user.setImgPath(vPath);
						}

					}
				}
				// 保存
				HttpSession session = request.getSession();
				String operator = (String) session.getAttribute("userName");
				UserService userService = new UserService();
				User newUser = userService.modifyUser(operator, user);

				if (newUser == null) {
					response.sendRedirect("DisplayUserDetail?state=" + URLEncoder.encode("修改失败！", "utf-8"));
					return;
				}
				if (user.getNewName().equals(user.getUserName())) {

					response.sendRedirect("DisplayUserDetail?state=" + URLEncoder.encode("修改成功！", "utf-8"));
					return;
				} else {
					// 如果更换名字，要更换session
					session.setAttribute("userName", user.getNewName());
					response.sendRedirect("DisplayUserDetail?state=" + URLEncoder.encode("修改成功！", "utf-8"));
				}

				// 转发

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

}
