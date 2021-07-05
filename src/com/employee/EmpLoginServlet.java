package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpLoginServlet")
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		String username = request.getParameter("euid");
		String password = request.getParameter("epass");
		boolean isTrue;
		
		isTrue=EmpDBUtil.validate(username, password);
		
		
	if(isTrue==true) {
		List<Employee> empdetails = EmpDBUtil.getemployee(username);
		request.setAttribute("empdetails",empdetails);
	
		
		RequestDispatcher dis = request.getRequestDispatcher("adminAccount.jsp");
		dis.forward(request, response);
	}else {
		out.println("<script type='text/javascript'>");
		out.println("alert('Your username or password is incorrect');");
		out.println("location='emp_login.jsp'");
		out.println("</script>");
	}

}

}