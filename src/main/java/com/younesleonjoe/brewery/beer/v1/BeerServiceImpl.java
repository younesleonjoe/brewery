package com.younesleonjoe.brewery.beer.v1;

import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("BeerServiceImplV1")
@Slf4j
public class BeerServiceImpl implements BeerService {

  private static BeerDTO getBeerResponseFromBeerRequest(BeerDTO beerRequest) {
    return BeerDTO.builder()
        .id(beerRequest.getId())
        .name(beerRequest.getName())
        .style(beerRequest.getStyle())
        .build();
  }

  private static List<BeerDTO> getBeerResponseList() {
    List<BeerDTO> beerResponseList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      beerResponseList.add(
          BeerDTO.builder()
              .id(UUID.randomUUID())
              .name("Beer-" + (i + 1))
              .style("Pale Ale")
              .build());
    }
    return beerResponseList;
  }

  @Override
  public List<BeerDTO> findAll() {
    return getBeerResponseList();
  }

  @Override
  public BeerDTO findById(UUID id) {
    return BeerDTO.builder().id(id).name("Not Weiser").style("Pale Ale").build();
  }

  @Override
  public BeerDTO create(BeerDTO beerRequest) {
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
