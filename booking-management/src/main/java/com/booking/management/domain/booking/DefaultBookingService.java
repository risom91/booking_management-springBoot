package com.booking.management.domain.booking;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.management.models.Bookings;
import com.booking.management.models.Customers;
import com.booking.management.models.Hotels;
import com.booking.management.repositories.BookingsRepository;
import com.booking.management.repositories.CustomersRepository;
import com.booking.management.repositories.HotelsRepository;

@Service
public class DefaultBookingService implements BookingService {

	private BookingsRepository bookingsRepository;
	private CustomersRepository customerRepository;
	private HotelsRepository hotelsRepository;
	@Autowired
	public DefaultBookingService(BookingsRepository bookingsRepository, CustomersRepository customerRepository, HotelsRepository hotelsRepository) {
		this.bookingsRepository = bookingsRepository;
		this.customerRepository = customerRepository;
		this.hotelsRepository = hotelsRepository;
	}
	
	@Override
	public boolean addBooking(Long checkInDate, Long checkOutDate, Long hotelId, Long userId) throws Exception {
		Boolean result = false;
		Optional<Customers> customer = customerRepository.findById(userId);
		if(customer.isEmpty()) throw new Exception("invalid request");
		
		Optional<Hotels> hotel = hotelsRepository.findById(userId);
		if(hotel.isEmpty()) throw new Exception("invalid request");
		
		long roomsOccupied = bookingsRepository.bookingCountBetweenDate(checkInDate, checkOutDate, hotel.get());
		if(roomsOccupied <  hotel.get().getRoomCount()) {
			Bookings booking = Bookings.builder()
					.checkInDate(checkInDate)
					.checkOutDate(checkOutDate)
					.Customers(customer.get())
					.hotel(hotel.get())
					.build();
			booking = bookingsRepository.save(booking);
			result = true;
		}

		return result;
	}



}
