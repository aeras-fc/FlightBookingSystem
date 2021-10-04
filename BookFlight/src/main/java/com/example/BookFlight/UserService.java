package com.example.BookFlight;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	TicketRepository repoTicket;
	
	@Autowired
    FlightRepository repoFlight;
	
	
	public List<Flight> searchFlight(String mode, String value) {
		if(mode.equals("source")) {
			return repoFlight.findByflightFrom(value);
		}
		else if(mode.equals("dest")) {
			return repoFlight.findByflightTo(value);
		}
		
		else if(mode.equals("date")) {
			return repoFlight.findByDate(value);
		}
			
		else {
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
