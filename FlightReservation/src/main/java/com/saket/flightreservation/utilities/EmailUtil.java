package com.saket.flightreservation.utilities;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.saket.flightreservation.services.ReservationServiceImpl;

@Component
public class EmailUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

	@Autowired
	public JavaMailSender sender;
	
	public void sendItinerary(String toAddress, String filePath) {
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject("Flight Itinerary");
			mimeMessageHelper.setText("PFA Itineary");
			mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
			sender.send(mimeMessage);
		} catch (MessagingException e) {
			LOGGER.error("Exception inside sendItinerary() "+e);
		}
		
	}
	
}
