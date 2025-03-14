package com.example.Unit_Project.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping(path = "get-passenger/{name}")
    public List<Passenger> getPassengerByName(@PathVariable String name) {
        return passengerService.getPassengerByName(name);
    }

    @PostMapping(path = "add-passenger")
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @PutMapping(path = "update-passenger/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        return passengerService.updatePassenger(id, passenger);
    }

    @DeleteMapping(path = "delete-passenger/{id}")
    public void removePassenger(@PathVariable Long id) {
        passengerService.removePassenger(id);
    }
}
