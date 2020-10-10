package com.oop.model;





public class stock {
	private int itemNo;
	private String name;
	private String category;
	private String tname;
	
	


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

	
	
	
	@Override
	public String toString() {
		return "Stock [itemNo=" + itemNo + ", name=" + name + ", category=" + category + ",  tname=" + tname + "]";
	}
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
