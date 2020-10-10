
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

import com.oop.model.Employee;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class EmployeeServiceImpl implements IEmployeeService {

	/** Initialise logger */
	public static final Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		//createEmployeeTable();
	}

	private PreparedStatement preparedStatement;


	public static void createEmployeeTable() throws IOException, SAXException, ParserConfigurationException {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			
			 //statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_EMP));
			 //Create new items table as per SQL query available in
			
			//statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_EMPLOYEE));

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public boolean addEmployee(Employee emp) {
		boolean status = true;
		
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in ItemQuery.xml file and use
			 * insert_item key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_EMPLOYEE));
			connection.setAutoCommit(false);
			
			//Generate item IDs
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, emp.getEID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, emp.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, emp.getSurName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, emp.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, emp.getCity());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, emp.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, emp.getPNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, emp.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, emp.getSalary());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, emp.getWorks());
		
			// Add employee
			boolean result= preparedStatement.execute();
			status = result;
			
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
		
		return status;
	}



	@Override
	public Employee getEmployeeByID(String EID) {

		return actionOnEmployee(EID).get(0);
	}

	@Override
	public ArrayList<Employee>getEmployees() {
		
		return actionOnEmployee(null);
	}

	@Override
	public boolean removeEmployee(String EID) {
		boolean status = true;
		// Before deleting check whether  EID is available
		if (EID != null && !EID.isEmpty()) {
			/*
			 * Remove employee query will be retrieved from Query.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_EMPLOYEE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EID);
			    status =preparedStatement.execute();
				
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
		return status;
	}

	private ArrayList<Employee> actionOnEmployee(String EID) {

		ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching item it checks whether item ID is
			 * available
			 */
			if (EID != null && !EID.isEmpty()) {
				/*
				 * Get item by ID query will be retrieved from
				 * ItemQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_EMPLOYEE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EID);
			}
			/*
			 * If item ID is not provided for get item option it display
			 * all items
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_EMPLOYEE));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee emp = new Employee();
				emp.setEID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				emp.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				emp.setSurName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				emp.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				emp.setCity(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				emp.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				emp.setPNo(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				emp.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				emp.setSalary(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				emp.setWorks(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				
				EmployeeList.add(emp);
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
		return EmployeeList;
	}
	@Override
	public Employee updateEmp(String EID, Employee emp) {

		/*
		 * Before fetching item it checks whether item ID is available
		 */
		if (EID != null && !EID.isEmpty()) {
			
			/*
			 *
			 * Update item query will be retrieved from ItemQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_EMPLOYEE));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, emp.getEID());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, emp.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, emp.getSurName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, emp.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, emp.getCity());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, emp.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, emp.getPNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, emp.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, emp.getSalary());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, emp.getWorks());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, emp.getEID());
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
		return getEmployeeByID(EID);
	}
	


	public ArrayList<Employee> Employees(String username) {

		ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
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
						.prepareStatement(QueryUtil.queryByID(CommonConstants.  QUERY_ID_GET_EMPLOYEE ));
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
				Employee emp = new Employee();
				emp.setEID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				emp.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				emp.setSurName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				emp.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				emp.setCity(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				emp.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				emp.setPNo(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				emp.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				emp.setSalary(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				emp.setWorks(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
			
				EmployeeList.add(emp);
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
		return EmployeeList;
	}
	
}


