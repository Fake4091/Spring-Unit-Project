package com.example.Unit_Project.Airport;

import jakarta.persistence.*;

@Entity
@Table
public class Airport {
  @Id
  @SequenceGenerator(
      name = "airport_sequence",
      sequenceName = "airport_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "airport_sequence"
  )
  private Long id;
}
