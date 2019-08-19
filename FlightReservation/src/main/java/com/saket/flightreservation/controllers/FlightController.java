package com.saket.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saket.flightreservation.entities.Flight;
import com.saket.flightreservation.repositories.FlightRepository;

@Controller
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	FlightRepository flightRepo;
	
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("departureDate") 
	@DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap modelMap) {
		LOGGER.info("inside findFlights(): from "+from+" to "+to);
		List<Flight> flights = flightRepo.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		return "displayFlights";
	}

}
