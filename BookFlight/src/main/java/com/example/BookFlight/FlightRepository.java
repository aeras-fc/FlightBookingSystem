package com.example.BookFlight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	List <Flight> findByflightFrom(String flightFrom);
	

}