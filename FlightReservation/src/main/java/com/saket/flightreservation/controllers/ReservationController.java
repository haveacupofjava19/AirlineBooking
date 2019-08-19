package com.saket.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saket.flightreservation.dto.ReservationRequest;
import com.saket.flightreservation.entities.Flight;
import com.saket.flightreservation.entities.Reservation;
import com.saket.flightreservation.repositories.FlightRepository;
import com.saket.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("inside showCompleteReservation(): flightId: "+flightId);
		Flight flight = flightRepo.findById(flightId).get();
		
		modelMap.addAttribute("flight", flight);
;		
		return "completeReservation";	
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("inside completeReservation(): request: "+request);
		Reservation bookFlight = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Booking done successfully! Your transaction ID is: "+
		bookFlight.getId());
		
		return "reservationConfirmation";
	}

}
