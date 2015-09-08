package net.eprojex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
		rs.setContentType("text/html");
		PrintWriter out=rs.getWriter();
		
		String name=rq.getParameter("name");
		String password=rq.getParameter("password");
		
		LoginBean bean=new LoginBean();
		bean.setName(name);
		bean.setPassword(password);
		rq.setAttribute("bean",bean);
	
		boolean status=bean.validate();
		
		if(status){
			RequestDispatcher rd = rq.getRequestDispatcher("login-success.jsp");
			rd.forward(rq, rs);
		}
		
		else{
			RequestDispatcher rd=rq.getRequestDispatcher("login-error.jsp");
			rd.forward(rq, rs);
		}
	}
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
		doPost(rq,rs);
	}
}
