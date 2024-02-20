package com.booking.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.management.models.Hotels;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels, Long>{

}
