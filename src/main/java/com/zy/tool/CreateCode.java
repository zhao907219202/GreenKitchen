package com.zy.tool;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("serial")
public class CreateCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		//7.��ֹ������������ͼƬ
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		//6.֪ͨ�ͻ�����ͼƬ��ʽ�򿪷��͹�ȥ������
		response.setHeader("Context-Type","imge/jpeg");
		//1.���ڴ��д���һ��ͼƬ
		BufferedImage image=new BufferedImage(60,30,BufferedImage.TYPE_INT_RGB);
		//2.��ͼƬ��д����
		Graphics g=image.getGraphics();
		//���ñ���
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 60, 30);
		//3.����д�����ݵ���ɫ������
		g.setColor(Color.RED);
		g.setFont(new Font(null,Font.BOLD,20));
		//4.��ͼƬ��д����
		String num=makeNum();
		request.getSession().setAttribute("checkcode", num);
		g.drawString(num, 0, 20);
		//5.��д�����ݵ�ͼƬ����������
		ImageIO.write(image,"jpg", response.getOutputStream());
	}

	private String makeNum() {
		Random r=new Random();
		String num=r.nextInt(9999)+"";
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<4-num.length();i++){
			sb.append("0");
		}
		num=sb.toString()+num;
		return num;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
