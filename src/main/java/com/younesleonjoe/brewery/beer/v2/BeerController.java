package com.younesleonjoe.brewery.beer.v2;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("BeerControllerV2")
@RequestMapping("/api/v2/beers")
@RequiredArgsConstructor
public class BeerController {

  private final BeerService beerService;

  @GetMapping
  public ResponseEntity<List<com.younesleonjoe.brewery.beer.v1.BeerDTO>> findAll() {
    return new ResponseEntity<>(beerService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<com.younesleonjoe.brewery.beer.v1.BeerDTO> findById(@PathVariable UUID id) {
    return new ResponseEntity<>(beerService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<com.younesleonjoe.brewery.beer.v1.BeerDTO> create(
      @RequestBody com.younesleonjoe.brewery.beer.v1.BeerDTO beerDTO) {
    com.younesleonjoe.brewery.beer.v1.BeerDTO createdBeerDTO = beerService.create(beerDTO);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + createdBeerDTO.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable("id") UUID id, @RequestBody BeerDTO BeerDTO) {
    beerService.update(id, BeerDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    beerService.delete(id);
  }
}
