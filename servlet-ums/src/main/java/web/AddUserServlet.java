package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class AddUserServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = 
				response.getWriter();
		
		/*
		 * 读取用户信息
		 */
		String username = 
				request.getParameter("uname");
		String pwd = 
				request.getParameter("pwd");
		String phone = 
				request.getParameter("phone");
		
		System.out.println("username:" 
		+ username + " pwd:" 
			+ pwd + " phone:" + phone);
		
		/*
		 * 服务器端应该对用户提交的数据进行合法性检查，
		 * 比如，检查用户名是否为空等，此处暂时不考虑。
		 */
		
		/*
		 * 使用DAO将用户信息插入到数据库
		 */
		UserDAO dao = new UserDAO();
		
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwd);
		user.setPhone(phone);
		try{
			dao.save(user);
			out.println("添加成功");
		}catch(Exception e){
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
		
	}
	
}




