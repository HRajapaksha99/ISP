package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.Item;

public interface IStockService {

	/** Initialise logger */
	public static final Logger log = Logger.getLogger(IStockService.class.getName());


	/**
	 * Add items for item table
	 * @param item
	 */
	public void addItem(Item stock);

	/**
	 * Get a particular Item
	 * 
	 * @param empoyeeID
	 * @return Item
	 */
	public Item getItemByID(String itemID);
	
	/**
	 * Get all list of items
	 * 
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getItems();
	
	/**
	 * Update existing item
	 * @param itemID
	 * @param item
	 * 
	 * @return
	 */
	public Item updateItem(String itemID, Item item);

	/**
	 * Remove existing item
	 * 
	 * @param itemID
	 */
	public void removeItem(String itemID);


}
