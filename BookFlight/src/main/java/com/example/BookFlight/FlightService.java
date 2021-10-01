package com.example.BookFlight;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightService {
	@Autowired
    FlightRepository repository;
	
	public void addFlight(Flight flight) {
		repository.save(flight);
		System.out.println("Adding this flight, in service!");
		
	}
	
	public void schedulFlight() {
		
	}
	
	public List<Flight> searchFlight(String source) {
		return repository.findByflightFrom(source);
	}
}