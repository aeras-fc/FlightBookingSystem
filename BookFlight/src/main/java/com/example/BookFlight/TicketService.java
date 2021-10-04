package com.example.BookFlight;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	@Autowired
	TicketRepository repoTicket;
	
	@Autowired
    FlightRepository repoFlight;
	
	
	public List<Flight> searchFlight(String mode, String value) {
		if(mode.equals("source")) {
			System.out.println("Inside Source");
			return repoFlight.findByflightFrom(value);
		}
		else if(mode.equals("dest")) {
			System.out.println("Inside Dest");
			return repoFlight.findByflightTo(value);
		}
		
		else if(mode.equals("date")) {
			System.out.println("Inside Date");
			return repoFlight.findByDate(value);
		}
			
		else {
			System.out.println("Inside Else");
			return repoFlight.findByflightFrom(value);
		}
			
	}
	
	public Integer saveBooking(Ticket ticket) {
		repoTicket.save(ticket);
		
		return ticket.getId();
	}
	
	public Optional<Ticket> searchTicket(Integer PNR) {
		return repoTicket.findById(PNR);
	}
	
	public List<Ticket> searchByEmail(String email){
		return repoTicket.findByemailId(email);
	}
	
	public void cancelTicket(Integer pnr) {
		repoTicket.deleteById(pnr);
		
		return;
	}
}
