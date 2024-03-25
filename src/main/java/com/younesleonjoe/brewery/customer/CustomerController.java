package com.younesleonjoe.brewery.customer;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping
  public ResponseEntity<List<CustomerResponse>> findAll() {
    return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable UUID id) {
    return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest customerRequest) {
    return new ResponseEntity<>(customerService.create(customerRequest), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable("id") UUID id, @RequestBody CustomerRequest customerRequest) {
    customerService.update(id, customerRequest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") UUID id) {
    customerService.delete(id);
  }
}
