package com.booking.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.management.models.Bookings;
import com.booking.management.models.Hotels;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    @Query("SELECT COUNT(b) FROM Bookings b WHERE b.checkInDate BETWEEN :checkInDate AND :checkOutDate AND b.hotels = :hotel")
    int bookingCountBetweenDate(@Param("checkInDate") long checkInDate, @Param("checkOutDate") long checkOutDate,@Param("hotel") Hotels hotel);

}
