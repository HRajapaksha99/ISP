package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.RegisterBean;

public interface IRegisterService {
	
	public static final Logger log = Logger.getLogger(IRegisterService.class.getName());
	
	public void addUser(RegisterBean registerBean);
	
	public RegisterBean getUserByID(String userID);
		
	public ArrayList<RegisterBean> getuUser();
	
	public RegisterBean updateUser(String userID, RegisterBean registerBean);
	
	public void removeUser(String userID);
	
	public String validateUser(RegisterBean registerBean);
	
	public RegisterBean getUserByName(String username);

}
