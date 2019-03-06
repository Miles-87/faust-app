package michonski.mateusz.service;

import michonski.mateusz.exceptions.MyException;
import michonski.mateusz.model.Flight;
import michonski.mateusz.model.dto.FlightDTO;
import michonski.mateusz.model.dto.mappers.ModelMapper;
import michonski.mateusz.repository.FlightRepository;
import michonski.mateusz.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private TouristRepository touristRepository;
    private FlightRepository flightRepository;
    private ModelMapper modelMapper;

    public FlightService(TouristRepository touristRepository, FlightRepository flightRepository, ModelMapper modelMapper) {
        this.touristRepository = touristRepository;
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    public FlightDTO addFlight(FlightDTO flightDTO) {
        try {
            Flight flight = flightRepository.save(modelMapper.fromFlightDTOToFlight(flightDTO));
            return modelMapper.fromFlightToFlightDTO(flight);
        } catch (Exception e) {
            throw new MyException("ADD FLIGHT EXCEPTION", LocalDateTime.now());
        }
    }

    public List<FlightDTO> getAllflights() {
        try {
            return flightRepository
                    .findAll()
                    .stream()
                    .map(modelMapper::fromFlightToFlightDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new MyException("GET ALL FLIGHTS EXCEPTION", LocalDateTime.now());
        }
    }

    public FlightDTO deleteFlight(Long id) {
        try {
            FlightDTO flightDTO = flightRepository
                    .findById(id)
                    .map(modelMapper::fromFlightToFlightDTO)
                    .orElseThrow(NullPointerException::new);
            flightRepository.deleteById(id);
            return flightDTO;
        } catch (Exception e) {
            throw new MyException("DELETE FLIGHT EXCEPTION", LocalDateTime.now());
        }
    }
}
