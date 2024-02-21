package com.booking.management.domain.booking;

public interface BookingService {

	boolean addBooking(Long checkInDate, Long checkOutDate, Long hotelId, Long userId) throws Exception;

	boolean cancelBooking(Long bookingId, Long checkInDate, Long hotelId, Long userId) throws Exception;

}
