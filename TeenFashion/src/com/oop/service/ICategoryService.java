package com.oop.service;

import java.util.ArrayList;

import com.oop.model.Category;

public interface ICategoryService {

	void addCategory(Category category);
	
	public Category getCategoryByID(String categoryID);
	
	public ArrayList<Category> getCategory();
	
	public Category updateCategory(String categoryID, Category category);
	
	public void removeCategory(String categoryID);
	
}
