package michonski.mateusz.controllers;

import michonski.mateusz.model.dto.FlightDTO;
import michonski.mateusz.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    private FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return service.getAllflights();
    }

    @PostMapping
    public FlightDTO addFlight(@RequestBody FlightDTO flightDTO) {
        return service.addFlight(flightDTO);
    }

    @DeleteMapping("/{id}")
    public FlightDTO deleteTourist(@PathVariable Long id) {
        return service.deleteFlight(id);
    }
}
