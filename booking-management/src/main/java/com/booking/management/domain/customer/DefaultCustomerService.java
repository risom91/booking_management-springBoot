package com.booking.management.domain.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.management.models.Customers;
import com.booking.management.repositories.CustomersRepository;

@Service
public class DefaultCustomerService implements CustomerService{

	private CustomersRepository customerRepository;
	
	@Autowired
	public DefaultCustomerService(CustomersRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	@Override
	public Customers addUser(String email, String name) {
		// verification logic to find if the user already exists pending
		Customers c = Customers.builder()
				.name(name)
				.email(email)
				.build();
		System.out.println(c.toString());
		return customerRepository.save(c);
	}

}
