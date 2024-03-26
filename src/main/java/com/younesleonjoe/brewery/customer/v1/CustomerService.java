package com.younesleonjoe.brewery.customer.v1;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
  List<CustomerDTO> findAll();

  CustomerDTO findById(UUID id);

  CustomerDTO create(CustomerDTO customerRequest);

  void update(UUID id, CustomerDTO customerRequest);

  void delete(UUID id);
}
