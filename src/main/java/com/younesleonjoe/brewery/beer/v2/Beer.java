package com.younesleonjoe.brewery.beer.v2;

import java.sql.Timestamp;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
  private UUID id;
  private String name;
  private BeerStyleEnum style;
  private Long upc;

  private Timestamp createdAt;
  private Timestamp updatedAt;
}
