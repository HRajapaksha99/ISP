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
import com.oop.service.RegisterServiceImpl;

@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminUserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		RegisterBean registerBean = new RegisterBean();
		String userID = request.getParameter("uId");
		registerBean.setuId(userID);
		registerBean.setuName(request.getParameter("name"));
		registerBean.setuMail(request.getParameter("email"));
		registerBean.setuPass(request.getParameter("pass"));
		registerBean.setuR_Pass(request.getParameter("re_pass"));
		registerBean.setU_type(request.getParameter("type"));
		IRegisterService iRegisterService = new RegisterServiceImpl();
		
		if(iRegisterService.updateUser(userID, registerBean) != null) {
			    request.setAttribute("errMessage", "User profile updated succesfully"); 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
				dispatcher.forward(request, response);	
				
		}
		else {
			
			    request.setAttribute("errMessage", "An error occured during process"); 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
				dispatcher.forward(request, response);	
			
		}
		
		
	   
	}

}
