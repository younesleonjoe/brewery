package com.younesleonjoe.brewery.customer.v1;

import jakarta.validation.constraints.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
  private UUID id;

  @NotBlank
  @Size(min = 3, max = 100)
  private String name;
}
