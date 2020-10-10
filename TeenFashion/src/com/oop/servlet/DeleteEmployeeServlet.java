package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.IEmployeeService;
import com.oop.model.Employee;
import com.oop.service.EmployeeServiceImpl;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteEmployeeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		String EID = request.getParameter("eId");
		
		IEmployeeService iEmployeeService = new EmployeeServiceImpl();
		Employee emp = iEmployeeService.getEmployeeByID(EID);
		String info = emp.toString();
		
		if(!iEmployeeService.removeEmployee(EID)) {
	    
		request.setAttribute("DeleteMsg",info + "  Successfully Deleted");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employeeview.jsp");
		dispatcher.forward(request, response);
		}
		else {
		
		request.setAttribute("ErrMsg","Error When Deleting "+ info +" - Please try again!!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employeeview.jsp");
		dispatcher.forward(request, response);
		}
	}

}
