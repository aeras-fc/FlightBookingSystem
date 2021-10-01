package com.example.BookFlight;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1.0/flight/")
public class FlightController {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("airline/register")
	public void newBooking(@RequestBody Booking booking) {
		
		bookingService.saveBooking(booking);;
		System.out.println("Booking created successfully");

	}
	
	
	@PostMapping("admin/login")
	public void adminLogin() {
		
		adminService.adminLogin();
	}
	
	
	@PostMapping("airline/inventory/add")
	public void addInvetory(@RequestBody Flight flight) {
		
		System.out.println("ADDING FLIGHT...");
		flightService.addFlight(flight);
	}
	
	
	@GetMapping("flight/search")
	public List<Flight> search(@RequestParam String source) {
		System.out.println("Getting flights from" + source);
		return flightService.searchFlight(source);
	}
	
	
	@PostMapping("booking/{flightd}")
	public void bookTicket() {
		
	}
	
	@GetMapping("ticket/{pnr}")
	public void getTicketFromPnr() {
		
	}
	
	@GetMapping("/booking/history")
	public String getTicketHistoryBasedOnEmail(@RequestParam String email) {
		System.out.println("Email found: " + email);
		
		return email;
		
	}
	
	@DeleteMapping("booking/cancel/{pnr}")
	public void cancelTicket() {
		
	}
}