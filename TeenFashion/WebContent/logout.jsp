<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
session.removeAttribute("username");
request.setAttribute("errMessage", "You logged out");
RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/landPageCusView.jsp");
dispatcher.forward(request, response);
%>