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
@WebServlet("/AddStockServlet")
public class AddStockServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStockServlet() {
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

		Item stock = new Employee();
		stock.setItemNo(request.getParameter("itemNo"));
		stock.setName(request.getParameter("name"));
		stock.setCategory(request.getParameter("category"));
		stock.setTname(request.getParameter("tname"));
		
		
		
	
		
		IStockService istockService = new StockServiceImpl();
		
		if(!istockService.addEmployee(stock)) {
		request.setAttribute("AddMsg", stock.toString()+ "  Succesfully Added!!!!");
		request.setAttribute("emp", stock);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/stockeview.jsp");
		dispatcher.forward(request, response);
		}
		else {
			
		request.setAttribute("ErrMsg", "Error When Adding "+stock.toString()+ "  Please try again!!");	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addstock.jsp");
		dispatcher.forward(request, response);
		}
		
	}
}
