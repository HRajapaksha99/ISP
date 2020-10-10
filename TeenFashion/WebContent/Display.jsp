<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.oop.service.UploadDPService"%>
<%@page import="com.oop.service.IUploadDP"%>
<%@page import="com.oop.model.Image"%>
<%@ page import="java.io.*"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%     
  
    if(request.getParameter("username") != null )
    {
    	
    	try{
    	 String username =request.getParameter("username");
         IUploadDP i = new UploadDPService();
         byte[] img = i.getPhotos(username);
         response.setContentType("image/gif");
         OutputStream o = response.getOutputStream();
         o.write(img);
         o.flush();
         o.close();
      
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
    }

%>
