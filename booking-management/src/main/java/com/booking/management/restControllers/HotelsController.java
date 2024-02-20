package com.booking.management.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.management.domain.hotel.HotelService;
import com.booking.management.models.Hotels;

@RequestMapping("/hotels")
@RestController
public class HotelsController {
	private HotelService hotelService;
	
	@Autowired
	public HotelsController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	public Hotels addHotel(@RequestBody String name, @RequestBody Integer roomCount) {
		return hotelService.addNewHotel(name, roomCount);
	}
}
