package com.booking.management.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.management.domain.customer.CustomerService;
import com.booking.management.models.Customers;

@RestController
@RequestMapping("/customer")
public class CustomersController {
	private CustomerService customerService;
	
	@Autowired
	public CustomersController(CustomerService customerService) {
		this.customerService = customerService;
	}
	@GetMapping()
	public Customers get() {
		Customers customer = Customers.builder()
				.id(454354l)
				.name("dummy")
				.email("dummy@email.com")
				.build();
		return customer;
	}
	@GetMapping("/get")
	public Customers getProfile(@RequestParam Long id) {
		Customers customer = Customers.builder()
				.id(id)
				.name("dummy")
				.email("dummy@email.com")
				.build();
		return customer;
	}
	
	@PostMapping("/add")
	public Customers addCustomer(@RequestBody String email,@RequestBody String name) {
		System.out.println("in "+ name + email);
		return customerService.addUser(email,name);
	}

}
