package com.younesleonjoe.brewery.beer.v1;

import java.util.List;
import java.util.UUID;

public interface BeerService {
  List<BeerDTO> findAll();

  BeerDTO findById(UUID id);

  BeerDTO create(BeerDTO beerRequest);

  void update(UUID id, BeerDTO beerRequest);

  void delete(UUID id);
}
