package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.model.LoginBean;
import com.oop.service.LoginDea;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDea loginDea;
	
	public void init() {
		loginDea = new LoginDea();
	} 

    public LoginServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uName = request.getParameter("user_name");
		String uPass = request.getParameter("user_pass");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setuName(uName);
		loginBean.setuPass(uPass);
		
		
		
		try {
			if (loginDea.validate(loginBean)) {
				HttpSession session = request.getSession();
				if (session !=null) {	
					session.setAttribute("username",loginBean.getuName());
					out.print("Hello " + loginBean.getuName());
				}
				
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/landPageCusView.jsp");
				requestDispatcher.forward(request, response);
			}
			
			else {

				request.setAttribute("errMessage", "You are not registered");
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				out.print("Invalid");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}
