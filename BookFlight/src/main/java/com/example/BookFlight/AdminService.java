package com.example.BookFlight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
    AirlineRepository repoAirline;	
	@Autowired
	FlightRepository repoFlight;
	
	public void adminLogin(Admin admin) {
		System.out.println("Admin has logged in!");
	}
	
	public void addAirline(Airline airline) {
		repoAirline.save(airline);
		
		return;
	}
	
	public void addFlight(Flight flight) {
		repoFlight.save(flight);
		System.out.println("Adding this flight, in service!");
		
	}
}
