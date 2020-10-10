package com.oop.service;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.oop.model.Image;
import com.oop.model.LoginBean;
import com.oop.model.RegisterBean;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;
public class UploadDPService implements IUploadDP  {
	
	public static final Logger log = Logger.getLogger(UploadDPService.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private static PreparedStatement preparedStatement;
	
	static{
		//create table or drop if exist
		createImageTable();
	}
	
	public static void createImageTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();					
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_IMAGE ));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	@Override
	public void uploadImage(Image image) {
		
		
		
		try {		
			
			InputStream  i = null;
	
			Part filePart =image.getP();
			

		    
           if (filePart != null) {
		        // prints out some information for debugging
		        System.out.println(filePart.getName());
		        System.out.println(filePart.getSize());
		        System.out.println(filePart.getContentType());             
		        // obtains input stream of the upload file
		        i = filePart.getInputStream();
		    }        
		    
		     
		     
		 
					connection = DBConnectionUtil.getDBConnection();
					
					preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_IMAGE));
					
					connection.setAutoCommit(false);
			        preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, image.getuName());
			
			        if (i != null) {
	                    // fetches input stream of the upload file for the blob column
	                preparedStatement.setBlob(CommonConstants.COLUMN_INDEX_TWO, i);
	        
			  } 
		
		    preparedStatement.execute();
			connection.commit();
			
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		
		
	}

	
	public byte[] getPhotos(String username) {
		
		Blob img ;
	    byte[] imgData = null ;
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_IMAGE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
					
				img = resultSet.getBlob(1);
			    imgData = img.getBytes(1,(int)img.length());
											
				
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return imgData;
	}


	
	

}
