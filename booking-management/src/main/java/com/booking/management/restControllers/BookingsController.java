package com.booking.management.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	public boolean addBooking(@RequestBody Long checkInDate, @RequestBody Long checkOutDate,@RequestBody Long hotelId,@RequestBody Long userId) throws Exception {
		return bookingService.addBooking(checkInDate, checkOutDate, hotelId, userId);
	}
	
	public boolean cancelBooking(@RequestBody Long bookingId, @RequestBody Long hotelId, @RequestBody Long userId, @RequestBody Long checkInDate) throws Exception {
		return bookingService.cancelBooking(bookingId,checkInDate, hotelId, userId);
	}
}
