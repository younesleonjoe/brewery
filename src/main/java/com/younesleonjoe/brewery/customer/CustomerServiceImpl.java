package com.younesleonjoe.brewery.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
  private static CustomerResponse getCustomerResponseFromCustomerRequest(
      CustomerRequest customerRequest) {
    return CustomerResponse.builder()
        .id(customerRequest.getId())
        .name(customerRequest.getName())
        .build();
  }

  private static List<CustomerResponse> getCustomerResponseList() {
    List<CustomerResponse> customerResponseList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      customerResponseList.add(
          CustomerResponse.builder().id(UUID.randomUUID()).name("Customer-" + (i + 1)).build());
    }
    return customerResponseList;
  }

  @Override
  public List<CustomerResponse> findAll() {
    return getCustomerResponseList();
  }

  @Override
  public CustomerResponse findById(UUID id) {
    return CustomerResponse.builder().id(id).name("Customer-" + id).build();
  }

  @Override
  public CustomerResponse create(CustomerRequest customerRequest) {
    return getCustomerResponseFromCustomerRequest(customerRequest);
  }

  @Override
  public void update(UUID id, CustomerRequest customerRequest) {
    log.debug("Updating customer with id {}", id);
  }

  @Override
  public void delete(UUID id) {
    log.debug("Deleting customer with id {}", id);
  }
}
