package com.oop.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oop.model.LoginBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class LoginDea {
	
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;
		String url = "jdbc:mysql://localhost:3306/isp";
		String username = "root";
		String password = "root";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection(url, username, password);

				PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM user WHERE uName = ? AND uPass = ?" )) {
				preparedstatement.setString(1, loginBean.getuName());
				preparedstatement.setString(2, loginBean.getuPass());				
				ResultSet resultSet = preparedstatement.executeQuery();
				status = resultSet.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			printSQLException(e);
		}
		return status;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e: ex ) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code : " + ((SQLException) e).getErrorCode());
				System.err.println("Message : " + e.getMessage());
				Throwable t = ex.getCause();
				
				while (t != null) {
					System.out.println("Causse: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
