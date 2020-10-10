package com.oop.model;

public class Employee {
	private String EID;
	private String Name;
	private String SurName;
	private String Address;
	private String City;
	private String Gender;
	private String PNo;
	private String Email;
	private String Salary;
	private String Works;
	
	
	
	
	
	
/*	@Override
	public String toString() {
		return "Item [itemNo=" + E + ", title=" + title + ", category=" + category + ", condition=" + condition
				+ ", brand=" + brand + ", color=" + color + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", startPrice=" + startPrice + ", buyPrice=" + buyPrice + ", reservePrice=" + reservePrice + ", desc="
				+ desc + "]";
	}
*/





	public String getEID() {
		return EID;
	}

	public void setEID(String eID) {
		EID = eID;
	}






	public String getName() {
		return Name;
	}






	public void setName(String name) {
		Name = name;
	}






	public String getSurName() {
		return SurName;
	}






	public void setSurName(String surName) {
		SurName = surName;
	}






	public String getAddress() {
		return Address;
	}






	public void setAddress(String address) {
		Address = address;
	}






	public String getCity() {
		return City;
	}






	public void setCity(String city) {
		City = city;
	}






	public String getGender() {
		return Gender;
	}






	public void setGender(String gender) {
		Gender = gender;
	}






	public String getPNo() {
		return PNo;
	}






	public void setPNo(String pNo) {
		PNo = pNo;
	}






	public String getEmail() {
		return Email;
	}






	public void setEmail(String email) {
		Email = email;
	}






	public String getSalary() {
		return Salary;
	}






	public void setSalary(String salary) {
		Salary = salary;
	}






	public String getWorks() {
		return Works;
	}






	public void setWorks(String works) {
		Works = works;
	}
	
	
	@Override
	public String toString() {
		return Name +" "+ SurName ;
		
	}
}
