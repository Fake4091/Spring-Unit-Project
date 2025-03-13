package com.example.Unit_Project.Airport;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import com.example.Unit_Project.Plane.Plane;

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
  @JsonProperty
  private Long id;
  private String name;
  private String callsign;
  private double latitude;
  private double longitude;
  private boolean busy;

//  @ManyToOne
//  @JoinColumn(name = "plane_id")
//  private Plane plane;


  public Airport() {
  }

  public Airport(String name) {
    this.name = name;
  }

  public Airport(String name, String callsign) {
    this.name = name;
    this.callsign = callsign;
  }

  public Airport(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Airport(Long id, String name, String callsign, double latitude, double longitude) {
    this.id = id;
    this.name = name;
    this.callsign = callsign;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Airport(String name, String callsign, double latitude, double longitude) {
    this.name = name;
    this.callsign = callsign;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCallsign() {
    return callsign;
  }

  public void setCallsign(String callsign) {
    this.callsign = callsign;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public boolean isBusy() {
    return busy;
  }

  public void toggleBusy() {
    this.busy = !busy;
  }
}
