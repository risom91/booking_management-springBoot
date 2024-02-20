package com.booking.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.management.models.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
