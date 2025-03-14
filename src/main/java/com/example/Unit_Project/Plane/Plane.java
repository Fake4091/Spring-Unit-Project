package com.example.Unit_Project.Plane;

import com.example.Unit_Project.Passenger.Passenger;
import com.fasterxml.jackson.annotation.JsonProperty;
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
  @JsonProperty
  private Long id;

  @JsonProperty
  private String model;

  @JsonProperty
  private Integer numberOfSeats;

//  @OneToMany
//  private List<Passenger> passengers;

  // Constructors Area ---- ↓

  public Plane() {
  }

  public Plane(Long id, String model, Integer numberOfSeats) {
    this.id = id;
    this.model = model;
    this.numberOfSeats = numberOfSeats;
  }

  public Plane(String model, Integer numberOfSeats) {
    this.model = model;
    this.numberOfSeats = numberOfSeats;
  }

  // Set/Update Area --- ↓

    //  ID --- ↓

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

    //  MODEL --- ↓
  public void setModel(String model) {
    this.model = model;
  }

  public String getModel() {
    return model;
  }

    //  SEATS --- ↓

  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public Integer getNumberOfSeats() {
    return numberOfSeats;
  }

}
