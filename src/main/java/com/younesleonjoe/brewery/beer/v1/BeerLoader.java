package com.younesleonjoe.brewery.beer.v1;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {
  private final BeerRepository beerRepository;

  public BeerLoader(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (beerRepository.count() > 0) return;
    beerRepository.save(
        Beer.builder()
            .id(UUID.randomUUID())
            .name("Mango Bobs")
            .version(new Random().nextLong())
            .style("IPA")
            .quantityToBrew(200)
            .minOnHand(12)
            .upc(337010000001L)
            .price(new BigDecimal("123.45"))
            .build());

    beerRepository.save(
        Beer.builder()
            .id(UUID.randomUUID())
            .version(new Random().nextLong())
            .name("Galaxy Cat")
            .style("PALE_ALE")
            .quantityToBrew(200)
            .minOnHand(12)
            .upc(337010000002L)
            .price(new BigDecimal("111.25"))
            .build());

    System.out.println("Loaded Beers: " + beerRepository.count());
  }
}
