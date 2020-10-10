package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.Employee;

public interface IEmployeeService {

	/** Initialise logger */
	public static final Logger log = Logger.getLogger(IEmployeeService.class.getName());

	boolean addEmployee(Employee emp);

	Employee getEmployeeByID(String EID);

	boolean removeEmployee(String EID);

	ArrayList<Employee> getEmployees();

	Employee updateEmp(String EID, Employee emp);




}
