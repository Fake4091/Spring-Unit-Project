package com.example.Unit_Project.Passenger;

import com.example.Unit_Project.Plane.Plane;
import com.example.Unit_Project.Plane.PlaneRepository;
import com.example.Unit_Project.Plane.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/passengers")
public class PassengerController {
    private final PassengerService passengerService;
    private final PlaneService planeService;
    private final PlaneRepository planeRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerController(PassengerService passengerService, PlaneService planeService, PlaneRepository planeRepository, PassengerRepository passengerRepository) {
        this.passengerService = passengerService;
        this.planeService = planeService;
        this.planeRepository = planeRepository;
        this.passengerRepository = passengerRepository;
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

    @PutMapping("plane/{plane_id}/passenger/{passenger_id}")
    Plane boardPassengerToPlane(
            @PathVariable Long plane_id,
            @PathVariable Long passenger_id
    ) {

        Optional<Plane> planeOptional = planeRepository.findById(plane_id);
        Optional<Passenger> passengerOptional = passengerRepository.findById(plane_id);

        Plane plane = planeOptional.get();
        Passenger passenger = passengerOptional.get();

        plane.addPassenger(passenger);
        passenger.setPlane(plane);

        passengerRepository.save(passenger);
        return planeRepository.save(plane);
    }
}
