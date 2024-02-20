package com.booking.management.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.management.domain.booking.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingsController {
	private BookingService bookingService;
	
	@Autowired
	public BookingsController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	// checkinInData and checkoutDate will be in epochmillis format
	public boolean addBooking(Long checkInDate, Long checkOutDate,Long hotelId, Long userId) throws Exception {
		return bookingService.addBooking(checkInDate, checkOutDate, hotelId, userId);
	}
}
