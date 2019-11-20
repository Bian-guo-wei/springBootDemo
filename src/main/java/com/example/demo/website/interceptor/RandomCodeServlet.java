package com.example.demo.website.interceptor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomCodeServlet extends HttpServlet {

	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	//验证码的高度
	private int width=60;
	//验证码的宽度
	private int height=20;
	protected void service(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,java.io.IOException{
		BufferedImage buffImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g=buffImg.createGraphics();
		//创建一个随机数生成器类
		Random random = new Random();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,width,height);
		//创建字体，字体大小应该根据图片高度来定。
		Font font = new Font("Times New Roman",Font.PLAIN,18);
		//设置字体
		g.setFont(font);
		//画边框
		g.setColor(Color.BLACK);
		g.drawRect(0,0,width-1,height-1);
		g.setColor(Color.GRAY);
		//随机产生160条干扰线
		for(int i =0;i<160;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			g.drawLine(x,y,x+x1,y+y1);
		}
		//randomcode用于保存随机产生的验证码，以便于用户登录后进行验证
		StringBuffer randomCode = new StringBuffer();
		int red=0,green=0,blue=0;
		//随机产生四位数的验证码
		for(int i=0;i<4;i++){
			//得到随机产生的验证码数字
			String strRand=String.valueOf(random.nextInt(10));
			//  生随机颜色的分量来构造色值，这样输出的数字的颜色值都将不同
			red=random.nextInt(110);
			green=random.nextInt(50);
			blue=random.nextInt(50);
			//用随机产生的颜色将验证码绘制到图像中
			g.setColor(new Color(red,green,blue));
			g.drawString(strRand,13*i+6,16);
			//产生四个随机数字组合在一起
			randomCode.append(strRand);
		}
		//将四位数字的验证码保存到Session里面
		HttpSession session =req.getSession();
		session.setAttribute("randomCode",randomCode.toString());
		//禁止图像缓存
		resp.setHeader("Prama","no-cache");
		resp.setHeader("Coche-Control","no-cache");
		resp.setDateHeader("Expires",0);
		resp.setContentType("image/jpeg");
		//将图像输出到Servelt输出流中
		ServletOutputStream sos=resp.getOutputStream();
		ImageIO.write(buffImg,"jpeg",sos);
		sos.close();
	}
	//Initialize global variables
	public void init() throws ServletException {
	}
	//Process the HTTP Get request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
	}
	//Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException {
		doGet(request, response);
	}
	//Clean up resources
	public void destroy() {
	}


//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Random random = new Random();
//		int width = 70, height = 22;
//		// 创建BufferedImage对象，设置图片的长度宽度和色彩。
//		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		OutputStream os = response.getOutputStream();
//		// 取得Graphics对象，用来绘制图片
//		Graphics g = image.getGraphics();
//		// 绘制图片背景和文字,释放Graphics对象所占用的资源。
//		g.setColor(getRandColor(200, 250));
//		// 设置内容生成的位置
//		g.fillRect(0, 0, width, height);
//		// 设置内容的字体和大小
//		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		// 设置内容的颜色：主要为生成图片背景的线条
//		g.setColor(getRandColor(160, 200));
//		// 画边框。
//		g.setColor(Color.BLACK);
//		g.drawRect(0, 0, width - 1, height - 1);
//		// 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
//		g.setColor(Color.BLACK);
//		// 图片背景上随机生成155条线条，避免通过图片识别破解验证码
//		for (int i = 0; i < 15; i++) {
//			int x = random.nextInt(width);
//			int y = random.nextInt(height);
//			int xl = random.nextInt(12);
//			int yl = random.nextInt(12);
//			g.drawLine(x, y, x + xl, y + yl);
//		}
//		// 生成四位的随机数,生成一个数，写一个
//		String[] s = { "A", "B", "C", "D", "E", "F", "G", "H", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "2", "3", "4", "5", "6", "7", "8", "9" };
//		String content = "";
//		for (int i = 0; i < 4; i++) {
//			String rand = "";
//			int index = random.nextInt(29);
//			rand = s[index];
//			content += rand;
//			g.setColor(new Color(20 + random.nextInt(10), 20 + random.nextInt(110), 20 + random.nextInt(110)));
//			g.drawString(rand, 13 * i + 6, 20);
//		}
//		// 释放此图形的上下文以及它使用的所有系统资源，类似于关闭流
//		g.dispose();
//		// 将生成的验证码值(即运算结果的值)放到session中，以便于后台做验证。
//		HttpSession session = request.getSession();
//		session.setAttribute("randomCode", content);
//		// 通过ImageIO对象的write静态方法将图片输出。
//		ImageIO.write(image, "JPEG", os);
//		os.close();
//	}
//
//	/**
//	 * 生成随机颜色
//	 *
//	 * @param fc
//	 * @param bc
//	 * @return
//	 */
//	public Color getRandColor(int fc, int bc) {
//		Random random = new Random();
//		if (fc > 255)
//			fc = 255;
//		if (bc > 255)
//			bc = 255;
//		int r = fc + random.nextInt(bc - fc);
//		int g = fc + random.nextInt(bc - fc);
//		int b = fc + random.nextInt(bc - fc);
//		return new Color(r, g, b);
//	}
}
