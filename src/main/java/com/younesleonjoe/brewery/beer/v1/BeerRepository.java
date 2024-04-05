package com.younesleonjoe.brewery.beer.v1;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, UUID> {
}
