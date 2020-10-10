package com.oop.model;

import java.sql.Blob;

import javax.servlet.http.Part;

public class Image {
	
	private String uName;
	private Part p;
	private Blob a;
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Part getP() {
		return p;
	}
	public void setP(Part p) {
		this.p = p;
	}
	
	public Blob getA() {
		return a;
	}
	public void setA(Blob a) {
		this.a = a;
	}
	
}
