package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.PaymentDao;
import com.project.Theatre_Management_System.dto.Payment;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;
	public Payment savePayment (Payment payment) {
		return  paymentDao.savePayment(payment);		
	}

	public Payment fetchPaymentById(int paymentId) {
		return paymentDao.fetchPaymentById(paymentId);
	}

	public Payment deletePaymentById(int paymentId) {
		return paymentDao.deletePaymentById(paymentId);
		
		
	}

	public Payment  updatePaymentById(int oldPaymentId,Payment newPayment) {
		newPayment.setPaymentId(oldPaymentId);;
		return paymentDao.savePayment(newPayment);
	}

	public List<Payment> fetchAllPayment () {
		return paymentDao.fetchAllPayment();
	}
}
