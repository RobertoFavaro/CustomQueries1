package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.services.FlightService;
import jakarta.persistence.Column;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @PostMapping("/create")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        Flight flightAdded = flightService.addFlight(flight);
        return ResponseEntity.ok().body(flightAdded);
    }
    @GetMapping("/read-all")
    public ResponseEntity<List<Flight>> returnAllFlights(){
        List<Flight> flights = flightService.returnAllFlight();
        return ResponseEntity.ok().body(flights);
    }
    @GetMapping("/read-single/{id}")
    public ResponseEntity<Flight> returnSingleFlight(@PathVariable Long id){
        Flight flight = flightService.returnFlightById(id);
        return ResponseEntity.ok().body(flight);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight){
        Flight flightUpdated = flightService.updateFlight(id, flight);
        return ResponseEntity.ok().body(flightUpdated);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Flight> deleteFlight(@PathVariable Long id){
        Flight flightDeleted = flightService.deleteFlight(id);
        return ResponseEntity.ok().body(flightDeleted);
    }

}
