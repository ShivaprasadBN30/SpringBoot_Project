package com.project.Theatre_Management_System.dto;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String modeOfPayment;
	private String transcationId;
	private Time  paymentTime;
	private double  paymentAmount;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getTranscationId() {
		return transcationId;
	}
	public void setTranscationId(String transcationId) {
		this.transcationId = transcationId;
	}
	public Time getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Time paymentTime) {
		this.paymentTime = paymentTime;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	
}
