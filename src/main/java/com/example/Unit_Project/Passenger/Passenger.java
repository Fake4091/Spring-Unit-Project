package com.example.Unit_Project.Passenger;

import jakarta.persistence.*;

@Entity
@Table
public class Passenger {
  @Id
  @SequenceGenerator(
      name = "passenger_sequence",
      sequenceName = "passenger_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "passenger_sequence"
  )
  private Long id;
}
