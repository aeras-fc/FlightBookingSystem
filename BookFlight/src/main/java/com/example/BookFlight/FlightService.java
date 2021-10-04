package com.example.BookFlight;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightService {
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
}