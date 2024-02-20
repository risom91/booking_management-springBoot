package com.booking.management.domain.hotel;

import com.booking.management.models.Hotels;

public interface HotelService {

	Hotels addNewHotel(String name, Integer roomCount);

}
