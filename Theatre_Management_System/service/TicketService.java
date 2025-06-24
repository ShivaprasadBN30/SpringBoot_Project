package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.TicketDao;
import com.project.Theatre_Management_System.dto.Ticket;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;
	public Ticket saveTicket(Ticket ticket) {
		return  ticketDao.saveTicket(ticket);		
	}

	public Ticket  fetchTicketById(int ticketId) {
		return ticketDao.fetchTicketById(ticketId);
	}

	public Ticket  deleteTicketById(int ticketId) {
		return ticketDao.deleteTicketById(ticketId);
		
	}

	public Ticket  updateTicketById(int oldTicketId, Ticket newTicket) {
		newTicket.setTicketId(oldTicketId);
		return ticketDao.saveTicket(newTicket);
	}

	public List<Ticket> fetchAllTicket() {
		return ticketDao.fetchAllTicket();
	}
	public Ticket addExistingPaymentToExistingTicket(int ticketId,int paymentId) {
		return ticketDao.addExistingPaymentToExistingTicket(ticketId, paymentId);
	}
}
