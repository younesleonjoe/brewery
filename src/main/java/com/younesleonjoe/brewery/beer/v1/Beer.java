package com.younesleonjoe.brewery.beer.v1;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "beer")
public class Beer {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @GenericGenerator(name = "UUID", type = org.hibernate.id.uuid.UuidGenerator.class)
  @Column(columnDefinition = "varchar(36)", updatable = false, nullable = false)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;

  @Version private Long version;

  @CreationTimestamp
  @Column(updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp private Timestamp updatedAt;

  private String name;
  private String style;

  @Column(unique = true)
  private Long upc;

  private BigDecimal price;

  private Integer minOnHand;
  private Integer quantityToBrew;
}
