package com.younesleonjoe.brewery.beer.v2;

import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
  BeerDTO beerToBeerDTO(Beer beer);

  Beer beerDTOToBeer(BeerDTO beerDTO);
}
