package com.saket.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saket.flightreservation.dto.ReservationUpdateRequest;
import com.saket.flightreservation.entities.Reservation;
import com.saket.flightreservation.repositories.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	@Autowired
	private ReservationRepository reservationRepo;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("inside findReservation(): id: "+id);
		return reservationRepo.findById(id).get();
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("inside updateReservation(): request: "+request);
		Reservation reservation = reservationRepo.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepo.save(reservation);
	}
	
}
