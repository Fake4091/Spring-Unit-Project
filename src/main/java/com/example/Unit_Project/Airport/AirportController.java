package com.example.Unit_Project.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/airports")
public class AirportController {
  private final AirportService airportService;

  @Autowired
  public AirportController(AirportService airportService) { this.airportService = airportService; }

  @GetMapping
  public List<Airport> getAllAirports() {
    return airportService.getAllAirports();
  }

  @GetMapping(path="{id}")
  public Airport getAirportById(@PathVariable Long id) {
    return airportService.getAirportById(id);
  }

  @PostMapping
  public Airport createAirport(@RequestBody Airport airport) {
    return airportService.createAirport(airport);
  }

  @PutMapping(path="update/{id}")
  public Airport updateAirport(@PathVariable Long id, @RequestBody Airport newAirport) {
    return airportService.updateAirport(id, newAirport);
  }

  @DeleteMapping(path="delete/{id}")
  public void deleteAirport(@PathVariable Long id) {
    airportService.deleteAirport(id);
  }
}
