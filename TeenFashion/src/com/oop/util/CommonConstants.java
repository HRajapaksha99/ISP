
package com.oop.util;

public class CommonConstants {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in Query.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in Query.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for item id prefix */
	public static final String ITEM_ID_PREFIX = "E300";

	/** Constant for item id prefix */
	public static final String USER_ID_PREFIX = "U10";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_table in ItemQuery.xml */
	public static final String QUERY_ID_DROP_TABLE = "drop_table";

	/** Constant for query id of create_table in Query.xml */
	public static final String QUERY_ID_CREATE_TABLE = "create_item_table";

	/** Constant for query id of insert items in Query.xml */
	public static final String QUERY_ID_INSERT_ITEMS = "insert_item";

	/** Constant for query id of get an item in Query.xml */
	public static final String QUERY_ID_GET_ITEM = "item_by_id";
	
	
	/** Constant for query id of get all items in Query.xml */
	public static final String QUERY_ID_ALL_ITEMS = "all_items";

	/** Constant for query id of remove a item in Query.xml */
	public static final String QUERY_ID_REMOVE_ITEM = "remove_item";

	/** Constant for query id of update a item in Query.xml */
	public static final String QUERY_ID_UPDATE_ITEM = "update_item";

	/** Constant for query id of get all item ids in Query.xml */
	public static final String QUERY_ID_GET_ITEM_IDS = "item_ids";
	
	
//	NEW CATEGORY
	
	/** Constant for query id of create_table in Query.xml */
	public static final String QUERY_ID_CREATE_TABLE2 = "create_category_table";
	
	/** Constant for query id of insert items in Query.xml */
	public static final String QUERY_ID_INSERT_CATEGORYS = "insert_category";
	
	/** Constant for query id of get an item in Query.xml */
	public static final String QUERY_ID_GET_CATEGORY = "category_by_id";

	/** Constant for query id of get all items in Query.xml */
	public static final String QUERY_ID_ALL_CATEGORYS = "all_categorys";

	/** Constant for query id of remove a item in Query.xml */
	public static final String QUERY_ID_REMOVE_CATEGORY = "remove_category";

	/** Constant for query id of update a item in Query.xml */
	public static final String QUERY_ID_UPDATE_CATEGORY = "update_category";


	
//USERS	COMMAN CONSTANTS
	public static final String QUERY_ID_USERBY_NAME = "user_by_name";
	
	public static final String QUERY_ID_VALIDATE_NAME = "validate_user";
	
	public static final String QUERY_ID_CREATE_TABLE3 = "create_user_table";
	
	public static final String QUERY_ID_INSERT_USERS = "insert_user";
	
	public static final String QUERY_ID_REMOVE_USER = "remove_user";
	
	public static final String QUERY_ID_GET_USER = "user_by_id";
	
	public static final String QUERY_ID_ALL_USERS = "all_users";
	
	public static final String QUERY_ID_UPDATE_USER = "update_user";
	
	public static final String QUERY_ID_GET_USER_IDS = "user_ids";
	
	public static final String QUERY_ID_USER_DROP_TABLE = "drop_user_table";
	
//PAYMENT COMMON CONSTANTS
	
	public static final String QUERY_ID_CREATE_TABLE4 = "create_payment_table";
	
	public static final String QUERY_ID_INSERT_PAYMENT = "insert_payment";
	
	public static final String QUERY_ID_REMOVE_PAYMENT = "delete_payment";
	
	public static final String QUERY_ID_GET_PAYMENT = "payment_by_id";
	
	public static final String QUERY_ID_ALL_PAYMENTS = "all_payment";
	
	public static final String QUERY_ID_UPDATE_PAYMENT = "update_payment";
	
	public static final String QUERY_ID_GET_PAYMENT_IDS = "payment_ids";

//IMAGES(PROFILE PIC) COMMON CONSTANTS
	
	public static final String QUERY_ID_CREATE_IMAGE = "create_images_table";
	
	public static final String QUERY_ID_INSERT_IMAGE = "insert_images";
	
	public static final String QUERY_ID_REMOVE_IMAGE = "delete_images";
	
	public static final String QUERY_ID_GET_IMAGE = "image_by_username";
	
	public static final String QUERY_ID_UPDATE_IMAGE= "update_images";
	
	
	
	public static final int COLUMN_INDEX_ONE = 1;
	public static final int COLUMN_INDEX_TWO = 2;
	public static final int COLUMN_INDEX_THREE = 3;
	public static final int COLUMN_INDEX_FOUR = 4;
	public static final int COLUMN_INDEX_FIVE = 5;
	public static final int COLUMN_INDEX_SIX = 6;
	public static final int COLUMN_INDEX_SEVEN = 7;
	public static final int COLUMN_INDEX_EIGHT = 8;
	public static final int COLUMN_INDEX_NINE = 9;
	public static final int COLUMN_INDEX_TEN = 10;
	public static final int COLUMN_INDEX_ELEVEN = 11;
	public static final int COLUMN_INDEX_TWELVE = 12;
	public static final int COLUMN_INDEX_THIRTY = 13;

	//New Employee
	
	/** Constant for query id of create_table in Query.xml */
	public static final String QUERY_ID_CREATE_EMPLOYEE = "create_employee_table";
	
	/** Constant for query id of insert items in Query.xml */
	public static final String QUERY_ID_INSERT_EMPLOYEE = "insert_emp";
	
	/** Constant for query id of get an item in Query.xml */
	public static final String QUERY_ID_GET_EMPLOYEE = "emp_by_eid";

	/** Constant for query id of get all items in Query.xml */
	public static final String QUERY_ID_ALL_EMPLOYEE = "all_employee";

	/** Constant for query id of remove a item in Query.xml */
	public static final String QUERY_ID_REMOVE_EMPLOYEE = "remove_emp";

	/** Constant for query id of update a item in Query.xml */
	public static final String QUERY_ID_UPDATE_EMPLOYEE = "update_emp";


	//New Stock
	
		/** Constant for query id of create_table in Query.xml */
		public static final String QUERY_ID_CREATE_STOCK = "create_stock_table";
		
		/** Constant for query id of insert items in Query.xml */
		public static final String QUERY_ID_INSERT_STOCK = "insert_stock";
		
		/** Constant for query id of get an item in Query.xml */
		public static final String QUERY_ID_GET_STOCK= "emp_by_ItemNo";

		/** Constant for query id of get all items in Query.xml */
		public static final String QUERY_ID_ALL_STOCK = "all_stock";

		/** Constant for query id of remove a item in Query.xml */
		public static final String QUERY_ID_REMOVE_STOCK = "remove_stock";

		/** Constant for query id of update a item in Query.xml */
		public static final String QUERY_ID_UPDATE_STOCK = "update_stock";


}
