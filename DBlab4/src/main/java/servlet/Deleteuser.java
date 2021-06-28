package servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netlink.*;
import operate.*;

@WebServlet("/Deleteuser")
public class Deleteuser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ServletContext context = this.getServletContext();   
		String username = request.getParameter("username");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ConnectMysql conn;
		try {
			System.out.println("进入delete");
			conn = new ConnectMysql();
			OPuser uo = new OPuser(conn);
			int flag = -1;
			try { 
				flag = uo.delete(username, 2);
				System.out.println(flag);
				context.setAttribute("username2", username);//保存上下文
				context.setAttribute("flag1", flag);//保存上下文
			    response.sendRedirect(request.getContextPath()+"/jsp/drop.jsp");//重定向
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn.closeConnect();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


