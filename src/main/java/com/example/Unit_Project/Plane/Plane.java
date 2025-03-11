package com.example.Unit_Project.Plane;

import jakarta.persistence.*;

@Entity
@Table
public class Plane {
  @Id
  @SequenceGenerator(
      name = "plane_sequence",
      sequenceName = "plane_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "plane_sequence"
  )
  private Long id;
}
