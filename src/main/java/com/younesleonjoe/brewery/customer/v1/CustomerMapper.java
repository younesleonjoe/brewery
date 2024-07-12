package com.younesleonjoe.brewery.customer.v1;

import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

  Customer customerDTOToCustomer(CustomerDTO customerDTO);

  CustomerDTO customerToCustomerDTO(Customer customer);
}
