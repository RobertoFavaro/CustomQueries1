package co.develhope.customqueries1.services;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }
    public List<Flight> returnAllFlight(){
        return flightRepository.findAll();
    }
    public Flight returnFlightById(Long id){
        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isPresent()){
            return flight.get();
        }else return (Flight) Optional.empty().get();
    }
    public Flight updateFlight(Long id, Flight flight){
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()){
            flightOptional.get().setDescription(flight.getDescription());
            flightOptional.get().setFromAirport(flight.getFromAirport());
            flightOptional.get().setStatusEnum(flight.getStatusEnum());
            flightOptional.get().setToAirport(flight.getToAirport());
            flightRepository.save(flightOptional.get());
            return flightOptional.get();
        }else return (Flight) Optional.empty().get();
    }
    public Flight deleteFlight(Long id){
        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isPresent()){
            flightRepository.delete(flight.get());
            return flight.get();
        }else return (Flight) Optional.empty().get();
    }
}
