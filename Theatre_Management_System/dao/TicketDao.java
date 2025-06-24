package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Payment;
import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.repo.TicketRepo;

@Repository
public class TicketDao {

	@Autowired
	TicketRepo ticketRepo;
	
	@Autowired
	PaymentDao paymentDao;
	public Ticket saveTicket(Ticket ticket) {
		return  ticketRepo.save(ticket);		
	}

	public Ticket  fetchTicketById(int ticketId) {
		return ticketRepo.findById(ticketId).get();
	}

	public Ticket  deleteTicketById(int ticketId) {
		Ticket ticket= ticketRepo.findById(ticketId).get();
		ticketRepo.delete(ticket);
		return ticket;
	}

	public Ticket  updateTicketById(int oldTicketId, Ticket newTicket) {
		newTicket.setTicketId(oldTicketId);
		return ticketRepo.save(newTicket);
	}

	public List<Ticket> fetchAllTicket() {
		return ticketRepo.findAll();
	}
	
	public Ticket addExistingPaymentToExistingTicket(int ticketId,int paymentId) {
		Ticket ticket=fetchTicketById(ticketId);
		Payment payment=paymentDao.fetchPaymentById(paymentId);
		ticket.setPayment(payment);
		return saveTicket(ticket);
		
	}
}
