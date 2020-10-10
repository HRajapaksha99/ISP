
package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Item;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class StockServiceImpl implements IStockService {

	/** Initialise logger */
	public static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createItemTable();
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
	public void addStock(Item stock) {

		String itemID = CommonUtil.generateuIDs(getItemIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in ItemQuery.xml file and use
			 * insert_item key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEMS));
			connection.setAutoCommit(false);
			
			//Generate item IDs
		
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, stock.getItemNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, stock.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, stock.getCategory());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, stock.getTname());
	
			// Add item
			preparedStatement.execute();
			connection.commit();

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
	}

	@Override
	public Item getItemByID(int itemID) {

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
				item.setTname(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
			
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
	public Item updateItem(String itemID, Item stock) {

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
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, stock.getItemNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, stock.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, stock.getCategory());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, stock.getTname());
			
			
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
	
	
	public ArrayList<Item> UserItems(String username) {

		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching item it checks whether item ID is
			 * available
			 */
			if (username != null ) {
				/*
				 * Get item by ID query will be retrieved from
				 * ItemQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants. QUERY_ID_GET_ITEMUSER ));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
			}
			/*
			 * If item ID is not provided for get item option it display
			 * all items
			 */
			else {
				 System.out.println("Error");
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Item stock= new Item();
				stock.setItemNo(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
				stock.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				stock.setCategory(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				stock.setTname(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
			
				itemList.add(stock);
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
	
}


