package com.younesleonjoe.brewery.beer.v2;

import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("BeerServiceImplV2")
@Slf4j
public class BeerServiceImpl implements BeerService {

  private static com.younesleonjoe.brewery.beer.v1.BeerDTO getBeerResponseFromBeerRequest(
      com.younesleonjoe.brewery.beer.v1.BeerDTO beerRequest) {
    return com.younesleonjoe.brewery.beer.v1.BeerDTO.builder()
        .id(beerRequest.getId())
        .name(beerRequest.getName())
        .style(beerRequest.getStyle())
        .build();
  }

  private static List<com.younesleonjoe.brewery.beer.v1.BeerDTO> getBeerResponseList() {
    List<com.younesleonjoe.brewery.beer.v1.BeerDTO> beerResponseList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      beerResponseList.add(
          com.younesleonjoe.brewery.beer.v1.BeerDTO.builder()
              .id(UUID.randomUUID())
              .name("Beer-" + (i + 1))
              .style("Pale Ale")
              .build());
    }
    return beerResponseList;
  }

  @Override
  public List<com.younesleonjoe.brewery.beer.v1.BeerDTO> findAll() {
    return getBeerResponseList();
  }

  @Override
  public com.younesleonjoe.brewery.beer.v1.BeerDTO findById(UUID id) {
    return com.younesleonjoe.brewery.beer.v1.BeerDTO.builder()
        .id(id)
        .name("Not Weiser")
        .style("Pale Ale")
        .build();
  }

  @Override
  public com.younesleonjoe.brewery.beer.v1.BeerDTO create(
      com.younesleonjoe.brewery.beer.v1.BeerDTO beerRequest) {
    return getBeerResponseFromBeerRequest(beerRequest);
  }

  @Override
  public void update(UUID id, BeerDTO beerRequest) {
    log.debug("Updating Beer with id: " + id);
  }

  @Override
  public void delete(UUID id) {
    log.debug("Deleting Beer with id: " + id);
  }
}
