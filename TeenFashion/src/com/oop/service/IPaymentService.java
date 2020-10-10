package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.Payment;

public interface IPaymentService {

	public static final Logger log = Logger.getLogger(IPaymentService.class.getName(), null);
	
	void addPayment(Payment payment);
	
	public Payment getPaymentByID(String paymentID);
	
	public ArrayList<Payment> getPayment();
	
	public Payment updatePayment(String paymentID, Payment payment);
	
	public void removePayment(String paymentID);

}
