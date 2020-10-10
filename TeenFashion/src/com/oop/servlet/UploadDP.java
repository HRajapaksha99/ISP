package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Image;

import com.oop.service.IUploadDP;

import com.oop.service.UploadDPService;


/**
 * Servlet implementation class UploadDP
 */

@WebServlet("/UploadDP")
@MultipartConfig(maxFileSize = 10177215) // upload file's size up to 16MB
public class UploadDP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		Image images = new Image();
		images.setuName(request.getParameter("username"));
		images.setP(request.getPart("image"));
		
		IUploadDP iuploadDP = new UploadDPService();
		try {
		iuploadDP.uploadImage(images);
		request.setAttribute("username", images);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/contact.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
