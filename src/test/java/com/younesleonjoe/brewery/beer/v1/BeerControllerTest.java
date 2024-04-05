package com.younesleonjoe.brewery.beer.v1;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @MockBean BeerService beerService;

  @Autowired MockMvc mockMvc;

  @Autowired ObjectMapper objectMapper;

  BeerDTO beerDTO;

  @BeforeEach
  public void setUp() {
    beerDTO =
        BeerDTO.builder()
            .id(UUID.randomUUID())
            .name("Beer1")
            .style("PALE_ALE")
            .upc(123456789012L)
            .build();
  }

  @Test
  void testFindAll() {}

  @Test
  void testFindById() throws Exception {
    given(beerService.findById(any(UUID.class))).willReturn(beerDTO);

    mockMvc
        .perform(
            get("/api/v1/beers/" + beerDTO.getId().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id", is(beerDTO.getId().toString())))
        .andExpect(jsonPath("$.name", is("Beer1")));
  }

  @Test
  void testCreate() throws Exception {
    beerDTO.setId(null);
    BeerDTO savedDto = BeerDTO.builder().id(UUID.randomUUID()).name("New Beer").build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

    given(beerService.create(any())).willReturn(savedDto);

    mockMvc
        .perform(post("/api/v1/beers").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
        .andExpect(status().isCreated());
  }

  @Test
  void testUpdate() throws Exception {
    beerDTO.setId(null);
    String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

    // when
    mockMvc
        .perform(
            put("/api/v1/beers/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
        .andExpect(status().isNoContent());

    then(beerService).should().update(any(), any());
  }

  @Test
  void testDelete() {}
}
