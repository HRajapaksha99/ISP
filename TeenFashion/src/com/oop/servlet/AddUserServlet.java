package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.RegisterBean;
import com.oop.service.IRegisterService;
//import oop.webApp.service.RegisterDeo;
import com.oop.service.RegisterServiceImpl;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddUserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		RegisterBean registerBean = new RegisterBean();
		
		registerBean.setuName(request.getParameter("name"));
		registerBean.setuMail(request.getParameter("email"));
		registerBean.setuPass(request.getParameter("pass"));
		registerBean.setuR_Pass(request.getParameter("rpass"));
		registerBean.setU_type(request.getParameter("user_type"));
		
		IRegisterService iRegisterService = new RegisterServiceImpl();
		String msg = iRegisterService.validateUser(registerBean);
		
		if(msg=="Taken") {
			request.setAttribute("errMessage","This username is already taken");
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
		  
			try {
		iRegisterService.addUser(registerBean);
		request.setAttribute("user", registerBean);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("errMessage","Account created successfully!");
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);

	}	
}
}
