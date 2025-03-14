package com.example.Unit_Project.Plane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/planes")
public class PlaneController {
    // Getting ahold of repository and service --- ↓
    private final PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService ) {
        this.planeService = planeService;
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

    // plane land @ airport ()
    @PutMapping(path="{planeId}/land/{airportId}")
    public Plane landPlane(@PathVariable Long planeId, @PathVariable Long airportId) {
        return planeService.landPlane(planeId, airportId);
    }

    // plane take off from airport ()
    @PutMapping(path="{planeId}/takeOff/")
    public Plane takeOffPlane(@PathVariable Long planeId) {
        return planeService.takeOff(planeId);
    }

    // Delete Data () --- ↓
    @DeleteMapping("delete/{id}")
    public void deletePlane(@PathVariable Long id) {
        planeService.deleteById(id);
    }

}
