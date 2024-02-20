package com.booking.management.domain.hotel;

import org.springframework.stereotype.Service;

import com.booking.management.models.Hotels;
import com.booking.management.repositories.HotelsRepository;

@Service
public class DefaultHotelService implements HotelService {

	private HotelsRepository hotelsRepository;
	
	public DefaultHotelService(HotelsRepository hotelsRepository) {
		this.hotelsRepository = hotelsRepository;
	}
	@Override
	public Hotels addNewHotel(String name, Integer roomCount) {
		Hotels hotel = Hotels.builder()
				.name(name)
				.roomCount(roomCount)
				.build();
		return hotelsRepository.save(hotel);
	}

}
