package com.younesleonjoe.brewery.client;

import com.younesleonjoe.brewery.beer.v1.BeerDTO;
import com.younesleonjoe.brewery.customer.v1.CustomerDTO;
import java.net.URI;
import java.util.UUID;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(prefix = "brewery.client", ignoreUnknownFields = false)
public class BreweryClient {
  public final String BEER_PATH_V1 = "/api/v1/beers";
  public final String CUSTOMER_PATH_V1 = "/api/v1/customers";
  private final RestTemplate restTemplate;
  @Setter private String apiHost;

  @Autowired
  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDTO getBeerById(UUID id) {
    return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + id, BeerDTO.class);
  }

  public URI createBeer(BeerDTO beerDTO) {
    return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDTO);
  }

  public void updateBeer(UUID id, BeerDTO beerDTO) {
    restTemplate.put(apiHost + BEER_PATH_V1 + "/" + id, beerDTO);
  }

  public void deleteBeer(UUID id) {
    restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + id);
  }

  public CustomerDTO getCustomerById(UUID id) {
    return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + "/" + id, CustomerDTO.class);
  }

  public URI createCustomer(CustomerDTO customerDTO) {
    return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDTO);
  }

  public void updateCustomer(UUID id, CustomerDTO customerDTO) {
    restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" + id, customerDTO);
  }

  public void deleteCustomer(UUID id) {
    restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + "/" + id);
  }
}
