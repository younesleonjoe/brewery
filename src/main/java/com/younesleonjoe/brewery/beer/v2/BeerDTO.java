package com.younesleonjoe.brewery.beer.v2;

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
	private UUID id;
	private String name;
	private BeerStyleEnum style;
	private Long upc;
}
