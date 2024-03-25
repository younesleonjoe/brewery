package com.younesleonjoe.brewery.beer.v2;

import java.util.List;
import java.util.UUID;

public interface BeerService {
  List<com.younesleonjoe.brewery.beer.v1.BeerDTO> findAll();

  com.younesleonjoe.brewery.beer.v1.BeerDTO findById(UUID id);

  com.younesleonjoe.brewery.beer.v1.BeerDTO create(
      com.younesleonjoe.brewery.beer.v1.BeerDTO beerRequest);

  void update(UUID id, BeerDTO beerRequest);

  void delete(UUID id);
}
