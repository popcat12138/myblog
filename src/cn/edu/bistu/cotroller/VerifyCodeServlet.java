package cn.edu.bistu.cotroller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerifyCode")
public class VerifyCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public VerifyCodeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int width = 100;
		int height = 50;
		String data = "ADEFRT2349"; // ����ַ��ֵ䣬����0��o��1��I
									// ���ѱ����ַ���ò�Ҫ
		Random random = new Random();// �����
		// 1 ����ͼƬ���ݻ������򣨺����ࣩ
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// ����һ����ɫ��ͼƬ
		// 2 ��û���(ͼƬ��psͼ��)���滭����
		Graphics g = image.getGraphics();
		// 3 ѡ����ɫ��������3��4���ǻ�һ��������߿��Ч��
		g.setColor(Color.gray);
		g.fillRect(0, 0, width, height);
		// 4��ɫ����
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, width - 2, height - 2);

		/** 1 �ṩ��������Ϊ�˴��4������ַ����Ա����session */
		StringBuilder builder = new StringBuilder();

		// 5 �������4���ַ�
		// ����������ɫ
		g.setFont(new Font("����", Font.BOLD & Font.ITALIC, 30));
		for (int i = 0; i < 3; i++) {
			// �����ɫ
			g.setColor(new Color(10, 155, 100));
			// new Color(random.nextInt(255), random.nextInt(255),
			// random.nextInt(255))
			// ����ַ�
			int index = random.nextInt(data.length());
			String str = data.substring(index, index + 1);

			/** 2 ���� */
			builder.append(str);

			// д��
			g.drawString(str, (width / 4) * (i + 1), 30);
		}
		// ��ͼ�л��������㣬��ͼƬ����ô�ñ��

		for (int j = 0, n = random.nextInt(100); j < n; j++) {
			g.setColor(Color.RED);
			g.fillRect(random.nextInt(width), random.nextInt(height), 1, 1);// ���������
		}

		/** 3 ���������ݣ�������session */
		String tempStr = builder.toString();
		request.getSession().setAttribute("sessionCacheData", tempStr);

		// .. ����ͼƬ���͵������ --�൱������
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
