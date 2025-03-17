package com.example.Unit_Project.Passenger;

import com.example.Unit_Project.Plane.Plane;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
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

    private String name;
    private String phoneNumber;
    private String travelLocation;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    public Passenger() {}

    public Passenger(String name, String phoneNumber, String travelLocation) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.travelLocation = travelLocation;
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

    public String getPhoneNumber() {
      return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
    }

    public String getTravelLocation() {
      return travelLocation;
    }

    public void setTravelLocation(String travelLocation) {
      this.travelLocation = travelLocation;
    }

    public Plane getPlane() {
      return plane;
    }

    public void setPlane(Plane plane) {
      this.plane = plane;
    }

}
