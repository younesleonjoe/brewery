package com.younesleonjoe.brewery.beer.v1;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import java.util.UUID;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

  @Null private UUID id;
  @NotBlank private String name;
  @NotBlank private String style;
  @Positive private Long upc;
}
