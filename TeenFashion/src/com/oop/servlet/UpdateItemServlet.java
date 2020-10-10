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

@WebServlet("/UpdateItemServlet")
public class UpdateItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateItemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Item item = new Item();
		String itemID = request.getParameter("itemNo");	
		item.setItemNo(itemID);
		item.setName(request.getParameter("name"));
		item.setCategory(request.getParameter("category"));
		item.setSize(request.getParameter("size"));
		item.setPrize(request.getParameter("prize"));
		item.setDesc(request.getParameter("desc_"));
		item.setPhoto_(request.getParameter("photo_"));
		
	
		IItemService iItemService = new ItemServiceImpl();
		iItemService.updateItem(itemID, item);
        
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/landPage.jsp");
		dispatcher.forward(request, response);
	}
}
