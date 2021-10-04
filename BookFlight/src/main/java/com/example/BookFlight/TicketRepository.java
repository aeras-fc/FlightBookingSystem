package com.example.BookFlight;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	

	
	List <Ticket> findByemailId(String emailId);

}
