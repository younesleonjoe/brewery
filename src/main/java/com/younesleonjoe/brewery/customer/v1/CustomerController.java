package com.younesleonjoe.brewery.customer.v1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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
  public ResponseEntity<CustomerDTO> findById(@NotNull @PathVariable UUID id) {
    return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO customerDTO) {
    CustomerDTO created = customerService.create(customerDTO);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customers/" + created.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(
      @NotNull @PathVariable("id") UUID id, @Valid @RequestBody CustomerDTO customerDTO) {
    customerService.update(id, customerDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@NotNull @PathVariable("id") UUID id) {
    customerService.delete(id);
  }
}
