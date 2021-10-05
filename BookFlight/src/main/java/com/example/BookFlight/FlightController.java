package com.example.BookFlight;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1.0/flight/")
public class FlightController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("airline/register")
	public String newBooking(@RequestBody Airline airline) {
		System.out.println("Adding new airline...");
		
		adminService.addAirline(airline);
		return "Airline Added Successfully!";
	}
	
	
	@PostMapping("admin/login")
	public void adminLogin(Admin admin) {
		
		adminService.adminLogin(admin);
	}
	
	
	@PostMapping("airline/inventory/add")
	public String addInvetory(@RequestBody Flight flight) {
		
		System.out.println("ADDING FLIGHT...");
		System.out.println("No. of seats: " + flight.flightTo);
		adminService.addFlight(flight);
		
		return "Flight Successfully added!";
	}
	
	
	@GetMapping("flight/search/{mode}/{value}")
	public List<Flight> search(@PathVariable("mode") String mode, @PathVariable("value") String value) {
		
		System.out.println("Hang tight! While we fetch you the flights :)");
		return userService.searchFlight(mode, value);
	}
	
	
	@PostMapping("booking/")
	public String bookTicket(@RequestBody Ticket ticket) {
		
		Integer PNR = userService.saveBooking(ticket);
		System.out.println("Ticket booked successfully");
		
		return "Ticket booked with PNR: " +  PNR;
	}
	
	//Search for ticket.
	@GetMapping("ticket/{pnr}")
	public Optional<Ticket> getTicketFromPnr(@PathVariable("pnr") Integer pnr) {
		System.out.println("Searching ticket for PNR: " + pnr);
		
		return userService.searchTicket(pnr);
	}
	
	@GetMapping("/booking/history/{email}")
	public List<Ticket> getTicketHistoryBasedOnEmail(@PathVariable("email") String email){
		System.out.println("Searching history for email: " + email);
		
		return userService.searchByEmail(email);
	}
	
	@DeleteMapping("booking/cancel/{pnr}")
	public String cancelTicket(@PathVariable("pnr") Integer pnr) {
		System.out.println("Cancelling ticket with PNR: " + pnr);
		
		userService.cancelTicket(pnr);
		
		return "Ticket successfully deleted!";
		
	}
	
}