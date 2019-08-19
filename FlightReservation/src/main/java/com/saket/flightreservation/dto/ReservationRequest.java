package com.saket.flightreservation.dto;

public class ReservationRequest {

	private Long flightId;
	private String travellerFirstName;
	private String travellerLastName;
	private String travellerEmail;
	private String travellerPhone;

	private String nameOnTheCard;
	private String cardNumber;
	private String expirationDate;
	private String sercutiyCode;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getTravellerFirstName() {
		return travellerFirstName;
	}

	public void setTravellerFirstName(String travellerFirstName) {
		this.travellerFirstName = travellerFirstName;
	}

	public String getTravellerLastName() {
		return travellerLastName;
	}

	public void setTravellerLastName(String travellerLastName) {
		this.travellerLastName = travellerLastName;
	}

	public String getTravellerEmail() {
		return travellerEmail;
	}

	public void setTravellerEmail(String travellerEmail) {
		this.travellerEmail = travellerEmail;
	}

	public String getTravellerPhone() {
		return travellerPhone;
	}

	public void setTravellerPhone(String travellerPhone) {
		this.travellerPhone = travellerPhone;
	}

	public String getNameOnTheCard() {
		return nameOnTheCard;
	}

	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSercutiyCode() {
		return sercutiyCode;
	}

	public void setSercutiyCode(String sercutiyCode) {
		this.sercutiyCode = sercutiyCode;
	}

	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", travellerFirstName=" + travellerFirstName
				+ ", travellerLastName=" + travellerLastName + ", travellerEmail=" + travellerEmail
				+ ", travellerPhone=" + travellerPhone + ", nameOnTheCard=" + nameOnTheCard + ", cardNumber="
				+ cardNumber + ", expirationDate=" + expirationDate + ", sercutiyCode=" + sercutiyCode + "]";
	}

}
