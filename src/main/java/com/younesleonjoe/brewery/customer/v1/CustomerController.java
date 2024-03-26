package com.younesleonjoe.brewery.customer.v1;

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
  public ResponseEntity<List<CustomerDTO>> findAll() {
    return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerDTO> findById(@PathVariable UUID id) {
    return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO) {
    return new ResponseEntity<>(customerService.create(customerDTO), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable("id") UUID id, @RequestBody CustomerDTO customerDTO) {
    customerService.update(id, customerDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") UUID id) {
    customerService.delete(id);
  }
}
