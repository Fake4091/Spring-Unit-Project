package com.example.Unit_Project.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
  private final AirportRepository airportRepository;

  @Autowired
  public AirportService(AirportRepository airportRepository) { this.airportRepository = airportRepository; }

  public List<Airport> getAllAirports() {
    return airportRepository.findAll();
  }

  public Airport getAirportById(Long id) {
    Optional<Airport> airportOptional = airportRepository.findById(id);
    if (airportOptional.isEmpty()) {
      throw new IllegalStateException("Airport with id " + id + " not found");
    }
    return airportOptional.get();
  }

  public Airport createAirport(Airport airport) {
    List<Airport> airportsWithCallsign = airportRepository.getAirportsByCallsign(airport.getCallsign());
    if (!airportsWithCallsign.isEmpty()) {
      throw new IllegalStateException("Callsign already in use");
    }
    List<Airport> airports = airportRepository.findAllByLatitude(airport.getLatitude());
    if (airports.isEmpty()) {
      return airportRepository.save(airport);
    }
    boolean exists = false;
    for (Airport airport1 : airports) {
      if (airport1.getLongitude() == airport.getLongitude()) {
        exists = true;
        break;
      }
    }
    if (exists) {
      throw new IllegalStateException("Airport already exists. Please update existing airport.");
    }
    return airportRepository.save(airport);
  }

  public Airport updateAirport(Long id, Airport newAirport) {
    List<Airport> airportsWithCallsign = airportRepository.getAirportsByCallsign(newAirport.getCallsign());
    if (!airportsWithCallsign.isEmpty()) {
      throw new IllegalStateException("Callsign already in use");
    }
    Optional<Airport> airportOptional = airportRepository.findById(id);
    if (airportOptional.isEmpty()) {
      throw new IllegalStateException("Airport with id " + id + " not found");
    }
    Airport airport = airportOptional.get();
    if (newAirport.getLatitude() != 0 &&
        newAirport.getLatitude() != airport.getLatitude()) {
      airport.setLatitude(newAirport.getLatitude());
    }
    if (newAirport.getLongitude() != 0 &&
        newAirport.getLongitude() != airport.getLongitude()) {
      airport.setLongitude(newAirport.getLongitude());
    }
    if (!newAirport.getName().isEmpty() &&
        !newAirport.getName().equals(airport.getName())) {
      airport.setName(newAirport.getName());
    }
    if (!newAirport.getCallsign().isEmpty() &&
        !newAirport.getCallsign().equals(airport.getCallsign())) {
      airport.setCallsign(newAirport.getCallsign());
    }
    return airportRepository.save(airport);
  }

  public void deleteAirport(Long id) {
    Optional<Airport> airportOptional = airportRepository.findById(id);
    if (airportOptional.isEmpty()) {
      throw new IllegalStateException("Airport with id " + id + " not found");
    }
    airportRepository.delete(airportOptional.get());
  }
}
