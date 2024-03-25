package com.younesleonjoe.brewery.customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
	List<CustomerResponse> findAll();
	CustomerResponse findById(UUID id);
	CustomerResponse create(CustomerRequest customerRequest);
	void update(UUID id, CustomerRequest customerRequest);
	void delete(UUID id);
}
