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

@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateEmpServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		Employee emp = new Employee();
		String EmployeeID =(request.getParameter("EId"));
		emp.setEID(EmployeeID);
		emp.setName(request.getParameter("name"));
		emp.setSurName(request.getParameter("sname"));
		emp.setAddress(request.getParameter("add"));
		emp.setCity(request.getParameter("city"));
		emp.setGender(request.getParameter("gender"));
		emp.setPNo(request.getParameter("phone"));
		emp.setEmail(request.getParameter("mail"));
		emp.setSalary(request.getParameter("sal"));
		
		String choosedays = ""; // variable which stores the  selected values of check-boxes in a String
	    String[] days= request.getParameterValues("day"); // days[] array stores the  selected values of check-boxes
		for(int i=0; i < days.length; i++) {
			choosedays += days[i]+ "\n";
		}
		
		emp.setWorks(choosedays);
		
		IEmployeeService iempService = new EmployeeServiceImpl();
		Employee employee = iempService.updateEmp(EmployeeID,emp);
		String retEmp =employee.getEID();
		
		if(retEmp != null || retEmp == EmployeeID) {
			
			request.setAttribute("UpdateMsg", emp.toString()+ "  Succesfully Updated!!!!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employeeview.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
		request.setAttribute("ErrMsg", "Error When Updating "+emp.toString()+ "  Please try again!!");
		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateEmployee.jsp");
		dispatcher.forward(request, response);
	}
				
		
	   
	}

}
