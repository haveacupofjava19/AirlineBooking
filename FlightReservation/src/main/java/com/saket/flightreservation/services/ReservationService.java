package com.saket.flightreservation.services;

import com.saket.flightreservation.dto.ReservationRequest;
import com.saket.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
