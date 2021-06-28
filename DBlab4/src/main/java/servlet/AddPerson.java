package servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operate.*;
import table.*;
import netlink.*;


@WebServlet("/AddPerson")
public class AddPerson extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddPerson() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ServletContext context = this.getServletContext();   
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"UTF-8");
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
		String age1 = request.getParameter("age");
		Integer age;
		if(age1.length()>0) age = Integer.valueOf(age1);
		else age = 0;
		String teleno = request.getParameter("teleno");
		ConnectMysql conn;
		try {
			conn = new ConnectMysql();
			OPperson po = new OPperson(conn);
			int flag = 0;
			try { 
				flag = po.addPersons(new Person(username,name,age,teleno));
				System.out.println(flag);
				context.setAttribute("username1",username);
				context.setAttribute("flag",flag);
				response.sendRedirect(request.getContextPath()+"/jsp/insert.jsp");
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
