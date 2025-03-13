package com.example.Unit_Project.Plane;

import com.example.Unit_Project.Airport.Airport;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/planes")
public class PlaneController {
    // Getting ahold of repository and service --- ↓
    private final PlaneService planeService;
    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneController(PlaneService planeService, PlaneRepository planeRepository) {
        this.planeService = planeService;
        this.planeRepository = planeRepository;
    }
    // Getting ahold of repository and service --- ↑

    // Read Data (ALL) --- ↓

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    // Read Data (ONE) --- ↓

    @GetMapping(path="{id}")
    public Plane getPlaneById(@PathVariable Long id) {
        return planeService.getPlaneById(id);
    }

    // Upload Data () --- ↓
    @PostMapping
    public Plane createPlane(@RequestBody Plane plane) {
        return planeService.createPlane(plane);
    }

    // Update Data () --- ↓
    @PutMapping("update/{id}")
    public Plane updatePlane(@PathVariable Long id, @RequestBody Plane newPlane) {
        return planeService.updatePlane(id, newPlane);
    }

    // Delete Data () --- ↓
    @DeleteMapping("delete/{id}")
    public void deletePlane(@PathVariable Long id) {
        planeService.deleteById(id);
    }

}
