package com.younesleonjoe.brewery.beer.v1;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/beers")
public class BeerController {

  private final BeerService beerService;

  @GetMapping
  public ResponseEntity<List<BeerDTO>> findAll() {
    return new ResponseEntity<>(beerService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BeerDTO> findById(@PathVariable UUID id) {
    return new ResponseEntity<>(beerService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<BeerDTO> create(@RequestBody BeerDTO beerDTO) {
    BeerDTO createdBeerDTO = beerService.create(beerDTO);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + createdBeerDTO.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody BeerDTO BeerDTO) {
    beerService.update(id, BeerDTO);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    beerService.delete(id);
  }
}
