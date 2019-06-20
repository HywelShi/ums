package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class ListUserServlet extends HttpServlet{
	
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
		 * 使用DAO查询数据库，将所有用户信息查询出来
		 */
		UserDAO dao = new UserDAO();
		try{
			List<User> users = 
					dao.findAll();
			/*
			 * 依据查询到的用户信息，输出表格
			 */
			out.println("<table width='60%' border='1' "
					+ "cellpadding='0' cellspacing='0'>");
			out.println(
					"<tr><td>ID</td><td>用户名</td>"
					+ "<td>密码</td><td>电话</td></tr>");
			for(int i = 0; i < users.size(); i ++){
				User u = users.get(i);
				out.println("<tr><td>" + u.getId() 
				+ "</td><td>" + u.getUsername() 
				+ "</td><td>" + u.getPwd() 
				+ "</td><td>" + u.getPhone() 
				+ "</td></tr>");
			}
			out.println("</table>");
		}catch(Exception e){
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
		
		
	}
}





