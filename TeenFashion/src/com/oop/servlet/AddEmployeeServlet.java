package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Employee;
import com.oop.service.EmployeeServiceImpl;
import com.oop.service.IEmployeeService;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployeeServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String ID = request.getParameter("sal");
		System.out.println(ID);
		Employee emp = new Employee();
		emp.setEID(request.getParameter("eid"));
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
		
		if(!iempService.addEmployee(emp)) {
		request.setAttribute("AddMsg", emp.toString()+ "  Succesfully Added!!!!");
		request.setAttribute("emp", emp);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employeeview.jsp");
		dispatcher.forward(request, response);
		}
		else {
			
		request.setAttribute("ErrMsg", "Error When Adding "+emp.toString()+ "  Please try again!!");	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addemployee.jsp");
		dispatcher.forward(request, response);
		}
		
	}
}
