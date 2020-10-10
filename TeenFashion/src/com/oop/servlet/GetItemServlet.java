package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Item;
import com.oop.service.ItemServiceImpl;
import com.oop.service.IItemService;

@WebServlet("/GetItemServlet")
public class GetItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GetItemServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

 		String itemID = request.getParameter("itemNo");	
 		
		IItemService iItemService = new ItemServiceImpl();
		Item item = iItemService.getItemByID(itemID);

		request.setAttribute("item", item);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateItem.jsp");
		dispatcher.forward(request, response);
	}

}
