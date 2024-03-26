package com.younesleonjoe.brewery.customer.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
  private static CustomerDTO getCustomerResponseFromCustomerRequest(CustomerDTO customerDTO) {
    return CustomerDTO.builder().id(customerDTO.getId()).name(customerDTO.getName()).build();
  }

  private static List<CustomerDTO> getCustomerResponseList() {
    List<CustomerDTO> customerResponseList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      customerResponseList.add(
          CustomerDTO.builder().id(UUID.randomUUID()).name("Customer-" + (i + 1)).build());
    }
    return customerResponseList;
  }

  @Override
  public List<CustomerDTO> findAll() {
    return getCustomerResponseList();
  }

  @Override
  public CustomerDTO findById(UUID id) {
    return CustomerDTO.builder().id(id).name("Customer-" + id).build();
  }

  @Override
  public CustomerDTO create(CustomerDTO customerDTO) {
    return getCustomerResponseFromCustomerRequest(customerDTO);
  }

  @Override
  public void update(UUID id, CustomerDTO customerDTO) {
    log.debug("Updating customer with id {}", id);
  }

  @Override
  public void delete(UUID id) {
    log.debug("Deleting customer with id {}", id);
  }
}
