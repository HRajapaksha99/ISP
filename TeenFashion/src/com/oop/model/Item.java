package com.oop.model;

import java.sql.Blob;

import javax.servlet.http.Part;

public class Item {
	private int itemNo;
	private String name;
	private String category;
	private String size;
	private float prize;
	private String desc_;
	private Part photo1;
	private Part photo2;
	private Part photo3;
	private Blob bp1;
	private Blob bp2;
	private Blob bp3;
	
	


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
	

	public String getDesc() {
		return desc_;
	}
	public void setDesc(String desc_) {
		this.desc_ = desc_;
	}
	
	
	@Override
	public String toString() {
		return "Item [itemNo=" + getItemNo() + ", name=" + name + ", category=" + category + ", size=" + getSize()
				+ ", prize=" + getPrize() + ", desc_=" + desc_ + "]";
	}
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public float getPrize() {
		return prize;
	}
	public void setPrize(float prize) {
		this.prize = prize;
	}
	public void setPhoto_(byte[] imgData) {
		// TODO Auto-generated method stub
		
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Part getPhoto3() {
		return photo3;
	}
	public void setPhoto3(Part photo3) {
		this.photo3 = photo3;
	}
	public Part getPhoto2() {
		return photo2;
	}
	public void setPhoto2(Part photo2) {
		this.photo2 = photo2;
	}
	public Part getPhoto1() {
		return photo1;
	}
	public void setPhoto1(Part photo1) {
		this.photo1 = photo1;
	}
	public Blob getBp1() {
		return bp1;
	}
	public void setBp1(Blob bp1) {
		this.bp1 = bp1;
	}
	public Blob getBp2() {
		return bp2;
	}
	public void setBp2(Blob bp2) {
		this.bp2 = bp2;
	}
	public Blob getBp3() {
		return bp3;
	}
	public void setBp3(Blob bp3) {
		this.bp3 = bp3;
	}
	
}
