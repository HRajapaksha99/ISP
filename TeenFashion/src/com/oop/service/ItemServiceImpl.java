
package com.oop.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStream;
import java.sql.Blob;
import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Item;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class ItemServiceImpl implements IItemService {

	/** Initialise logger */
	public static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		//createItemTable();
	}

	private PreparedStatement preparedStatement;


	public static void createItemTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			
			//statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new items table as per SQL query available in
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addItem(Item item) {

		//String itemID = CommonUtil.generateuIDs(getItemIDs());
		
try {		
			
			
		
		
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in ItemQuery.xml file and use
			 * insert_item key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEMS));
			connection.setAutoCommit(false);
			
			
		    InputStream  i[] = new InputStream[3];
			Part  filePart[]= new Part[3];
			
				
			filePart[0] = (Part)item.getPhoto1();
			filePart[1] = (Part)item.getPhoto2();
			filePart[2] = (Part)item.getPhoto3();
				
				
		//this array obtains input streams of the 
		for(int a = 0; a<=2; a++) {
			   i[a] = null;
			    
           if (filePart[a] != null) {
		        // prints out some information for debugging.
        	   
		        System.out.println(filePart[a].getName());
		        System.out.println(filePart[a].getSize());
		        System.out.println(filePart[a].getContentType()); 
		        
		        // obtains input streams of the upload file
		       
		        i[a] = filePart[a].getInputStream();
           
           
		        if(i[a] != null) {
		        	if (a == 0) {
		            preparedStatement.setBlob(CommonConstants.COLUMN_INDEX_SEVEN, i[a]);
		            }
		        	
		        	if (a == 1) {
		        	preparedStatement.setBlob(CommonConstants.COLUMN_INDEX_EIGHT, i[a]);
			            }
		        	if (a == 2) {
			         
		        	preparedStatement.setBlob(CommonConstants.COLUMN_INDEX_NINE,i[a]);
			            }
		        
		    }   
		
           }
		}
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, item.getItemNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getCategory());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getSize());
			preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_FIVE, item.getPrize());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, item.getDesc());
			
			
			// Add item
			preparedStatement.execute();
			connection.commit();

		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e ) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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

	@Override
	public Item getItemByID(String itemID) {

		return actionOnItem(itemID).get(0);
	}

	@Override
	public ArrayList<Item> getItems() {
		
		return actionOnItem(null);
	}

	@Override
	public void removeItem(String itemID) {

		// Before deleting check whether item ID is available
		if (itemID != null && !itemID.isEmpty()) {
			/*
			 * Remove item query will be retrieved from ItemQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
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
	}

	private ArrayList<Item> actionOnItem(String itemID) {
		Blob img ;
	    byte[] imgData = null ;
		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching item it checks whether item ID is
			 * available
			 */
			if (itemID != null && !itemID.isEmpty()) {
				/*
				 * Get item by ID query will be retrieved from
				 * ItemQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemID);
			}
			/*
			 * If item ID is not provided for get item option it display
			 * all items
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ITEMS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Item item = new Item();
				item.setItemNo(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
				item.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				item.setCategory(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				item.setSize(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				item.setPrize(resultSet.getFloat(CommonConstants.COLUMN_INDEX_FIVE));
				item.setDesc(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				img =resultSet.getBlob(CommonConstants.COLUMN_INDEX_SEVEN);
				imgData = img.getBytes(1,(int)img.length());
				item.setPhoto_(imgData);
				itemList.add(item);
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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
		return itemList;
	}
	@Override
	public Item updateItem(String itemID, Item item) {

		/*
		 * Before fetching item it checks whether item ID is available
		 */
		if (itemID != null && !itemID.isEmpty()) {
			/*
			 * Update item query will be retrieved from ItemQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ITEM));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getCategory());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getSize());
				preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_FOUR, item.getPrize());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, item.getDesc());
				//preparedStatement.setBlob(CommonConstants.COLUMN_INDEX_SIX, item.getPhoto1());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THIRTY, item.getItemNo());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
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
		// Get the updated item
		return getItemByID(itemID);
	}
	
	private ArrayList<String> getItemIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of item IDs will be retrieved from ItemQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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
		return arrayList;
	}
	
	

}


