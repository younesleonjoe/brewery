package com.younesleonjoe.brewery.customer.v1;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(UUID id) {
		super(String.format("Customer with id %s not found", id));
	}
}
