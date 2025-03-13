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

    private static PlaneRepository planeRepository = null;
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
        List<Plane> planesWithId = planeRepository.getPlaneById(newPlane.getId());
        if(planesWithId.isEmpty()) {
            throw new IllegalStateException("Plane with ID " + newPlane.getId() + " doesn't exist!");
        }

        Optional<Plane> planeOptional = planeRepository.findById(id);
        Plane plane = planeOptional.get();

        plane.setModel(newPlane.getModel());
        plane.setNumberOfSeats(newPlane.getNumberOfSeats());

        return planeRepository.save(plane);
    }


    public void deleteById(Long id) {
        planeRepository.deleteById(id);
    }
}
