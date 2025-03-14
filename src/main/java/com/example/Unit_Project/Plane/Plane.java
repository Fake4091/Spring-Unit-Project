package com.example.Unit_Project.Plane;

import com.example.Unit_Project.Airport.Airport;
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

  @ManyToOne
  @JoinColumn(name = "airport_id", referencedColumnName = "id")
  @JsonProperty
  private Airport airport;

//  @OneToMany
//  private List<Passenger> passengers;

  // Constructors Area ---- ↓

  public Plane() {
  }

  public Plane(Long id, String model, Integer numberOfSeats, Airport airport) {
    this.id = id;
    this.model = model;
    this.numberOfSeats = numberOfSeats;
    this.airport = airport;
  }

  public Plane(String model, Integer numberOfSeats, Airport airport) {
    this.model = model;
    this.numberOfSeats = numberOfSeats;
    this.airport = airport;
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

  public Airport getAirport() {
    return airport;
  }

  public void setAirport(Airport airport) {
    this.airport = airport;
  }
}
