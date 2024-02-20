package com.booking.management.domain.customer;

import com.booking.management.models.Customers;

public interface CustomerService {

	Customers addUser(String email, String name);

}
