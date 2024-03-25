package com.younesleonjoe.brewery.beer.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {
  private UUID id;
  private String name;
  private String style;
  private Long upc;
}
