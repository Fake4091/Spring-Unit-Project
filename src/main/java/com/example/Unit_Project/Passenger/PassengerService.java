package com.example.Unit_Project.Passenger;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> getPassengerByName(String name) {
        List<Passenger> passengers = findByName(name);
        if (passengers.isEmpty()) {
            throw new IllegalStateException("No passengers found with the name: " + name);
        }
        return passengers;
    }

    private List<Passenger> findByName(String name) {
        return passengerRepository.findByName(name);
    }

    @Transactional
    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Passenger existingPassenger = passengerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Passenger with id " + id + " not found"));

        existingPassenger.setName(passengerDetails.getName());
        existingPassenger.setPhoneNumber(passengerDetails.getPhoneNumber());
        existingPassenger.setTravelLocation(passengerDetails.getTravelLocation());
//        existingPassenger.setPlane(passengerDetails.getPlane());

        return passengerRepository.save(existingPassenger);
    }

    @Transactional
    public void removePassenger(Long id) {
        Optional<Passenger> passengerOptional = passengerRepository.findById(id);
        if (passengerOptional.isEmpty()) {
            throw new IllegalStateException("Passenger with id " + id + " not found");
        }
        passengerRepository.delete(passengerOptional.get());
    }
}
