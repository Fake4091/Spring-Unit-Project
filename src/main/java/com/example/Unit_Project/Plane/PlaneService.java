package com.example.Unit_Project.Plane;

import java.util.List;
import java.util.Optional;

import com.example.Unit_Project.Airport.Airport;
import com.example.Unit_Project.Airport.AirportRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlaneService {

    // Setting up repository --- ↓

    private final PlaneRepository planeRepository;
    private final AirportRepository airportRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository, AirportRepository airportRepository) {
        this.planeRepository = planeRepository;
        this.airportRepository = airportRepository;
    }

    // Setting up repository --- ↑


    public List<Plane> getAllPlanes(){

        return planeRepository.findAll();
    }

    public Plane getPlaneById(Long id) {

        Optional<Plane> planeOptional = planeRepository.findById(id);
        if (planeOptional.isEmpty()) {
            throw new IllegalStateException("Plane with id " + id + " not found");
        }
        return planeOptional.get();

    }

    public Plane createPlane(Plane plane) {
        List<Plane> planesWithId = planeRepository.getPlaneById(plane.getId());
        if(!planesWithId.isEmpty()){
            throw new IllegalStateException("Plane with ID " + plane.getId() + " already exists");
        }
        return planeRepository.save(plane);
    }

    public Plane updatePlane(Long id, Plane newPlane) {
        Optional<Plane> planeOptional = planeRepository.findById(id);
        if (planeOptional.isEmpty()) {
            throw new IllegalStateException("Plane with ID " + id + " doesn't exist!");
        }
        Plane plane = planeOptional.get();

        plane.setModel(newPlane.getModel());
        plane.setNumberOfSeats(newPlane.getNumberOfSeats());

        return planeRepository.save(plane);
    }


    public void deleteById(Long id) {
        planeRepository.deleteById(id);
    }

    public Plane landPlane(Long planeId, Long airportId) {
        Plane plane = getPlaneById(planeId);
        if (plane.getAirport() != null) {
            throw new IllegalStateException("Plane with ID " + planeId + " is already at an airport");
        }
        Optional<Airport> airportOptional = airportRepository.findById(airportId);
        if(airportOptional.isEmpty()) {
            throw new IllegalStateException("Airport with ID " + airportId + " not found");
        }
        Airport airport = airportOptional.get();
//        if (airport.isBusy()) {
//            throw new IllegalStateException("Airport with ID " + airportId + " is busy");
//        }
//        airport.toggleBusy();
        airport.addPlane(plane);
        plane.setAirport(airport);
        airportRepository.save(airport);
        return planeRepository.save(plane);
    }

    public Plane takeOff(Long planeId) {
        Plane plane = getPlaneById(planeId);
        Airport airport = plane.getAirport();
        if (airport == null) {
            throw new IllegalStateException("Plane cannot take off when not at an airport");
        }
        airport.removePlane(plane);
        plane.setAirport(null);
        airportRepository.save(airport);
        return planeRepository.save(plane);
    }
}
