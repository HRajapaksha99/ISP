package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oop.model.Item;
import com.oop.service.ItemServiceImpl;
import com.oop.service.IItemService;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AddItemServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   
public class AddItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItemServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Item item = new Item();
		item.setItemNo(Integer.parseInt(request.getParameter("itemNo")));
		item.setName(request.getParameter("name"));
		item.setCategory(request.getParameter("category"));
System.out.println(request.getParameter("itemNo"));
System.out.println(request.getParameter("name"));

		String chooseSize = ""; // variable which stores the  selected values of check-boxes in a String
	    String[] size= request.getParameterValues("size"); // size[] array stores the  selected values of check-boxes
		for(int i=0; i < size.length; i++) {
			chooseSize += size[i]+ "\n";
		}
		item.setSize(chooseSize);
	
		item.setPrize(Float.parseFloat(request.getParameter("prize")));
		item.setDesc(request.getParameter("desc_"));
		item.setPhoto1(request.getPart("photo1"));
		item.setPhoto2(request.getPart("photo2"));
		item.setPhoto3(request.getPart("photo3"));
		
		IItemService iItemService = new ItemServiceImpl();
		iItemService.addItem(item);

		request.setAttribute("item", item);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/landPage.jsp");
		dispatcher.forward(request, response);
	}
}
