package com.saket.flightcheckin.integration;

import com.saket.flightcheckin.integration.dto.Reservation;
import com.saket.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}

