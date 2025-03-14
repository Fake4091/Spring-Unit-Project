package com.example.Unit_Project.Airport;

import com.example.Unit_Project.Plane.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
  List<Airport> findAllByLatitude(double latitude);

  List<Airport> getAirportsByCallsign(String callsign);
}
