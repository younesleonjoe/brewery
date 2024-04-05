package com.younesleonjoe.brewery.beer.v2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
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
  @NotNull private BeerStyleEnum style;
  @Positive @NotNull private Long upc;

  private Long version;

  @Null private OffsetDateTime createdAt;
  @Null private OffsetDateTime updatedAt;

  @Positive @NotNull private BigDecimal price;

  private Integer quantityOnHand;
}
