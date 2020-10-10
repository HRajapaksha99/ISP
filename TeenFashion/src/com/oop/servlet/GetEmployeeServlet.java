package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Employee;
import com.oop.service.IEmployeeService;
import com.oop.service.EmployeeServiceImpl;

@WebServlet("/GetEmployeeServlet")
public class GetEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetEmployeeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		String EmployeeID = request.getParameter("EId");
		IEmployeeService iEmployeeService = new EmployeeServiceImpl();
		Employee employee = iEmployeeService.getEmployeeByID(EmployeeID);
		
		request.setAttribute("employee", employee);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/updateEmployee.jsp");
		requestDispatcher.forward(request, response);
	}

}
