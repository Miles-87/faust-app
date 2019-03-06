package michonski.mateusz.service;

import michonski.mateusz.exceptions.MyException;
import michonski.mateusz.model.Flight;
import michonski.mateusz.model.Tourist;
import michonski.mateusz.model.dto.TouristDTO;
import michonski.mateusz.model.dto.mappers.ModelMapper;
import michonski.mateusz.repository.FlightRepository;
import michonski.mateusz.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TouristService {
    private TouristRepository touristRepository;
    private FlightRepository flightRepository;
    private ModelMapper modelMapper;

    public TouristService(TouristRepository touristRepository, FlightRepository flightRepository, ModelMapper modelMapper) {
        this.touristRepository = touristRepository;
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    public TouristDTO addTourist(TouristDTO touristDTO) {
        try {
            Tourist tourist = touristRepository.save(modelMapper.fromTouristDTOToTourist(touristDTO));
            return modelMapper.fromTouristToTouristDTO(tourist);
        } catch (Exception e) {
            throw new MyException("ADD TOURIST EXCEPTION", LocalDateTime.now());
        }
    }

    public List<TouristDTO> getAllTourists() {
        try {
            return touristRepository
                    .findAll()
                    .stream()
                    .map(modelMapper::fromTouristToTouristDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new MyException("GET ALL TOURISTS EXCEPTION", LocalDateTime.now());
        }
    }

    public TouristDTO deleteTourist(Long id) {
        try {
            TouristDTO touristDTO = touristRepository
                    .findById(id)
                    .map(modelMapper::fromTouristToTouristDTO)
                    .orElseThrow(NullPointerException::new);
            touristRepository.deleteById(id);
            return touristDTO;
        } catch (Exception e) {
            throw new MyException("DELETE TOURIST EXCEPTION", LocalDateTime.now());
        }
    }

    // check if tourist already has chosen flight
    public boolean hasTouristFlight(Long touristId, Long flightId) {
        try {
            Tourist tourist = touristRepository.findById(touristId).orElseThrow(NullPointerException::new);
            Flight flight = flightRepository.findById(flightId).orElseThrow(NullPointerException::new);
            return tourist.getFlights().contains(flight);
        } catch (Exception e) {
            throw new MyException("HAS TOURIST FLIGHT EXCEPTION", LocalDateTime.now());
        }
    }

    // check if chosen flight has free places
    public boolean hasFlightFreePlaces(Long flightId) {
        try {
            Flight flight = flightRepository.findById(flightId).orElseThrow(NullPointerException::new);
            return flight.getPlaces() > 0;
        } catch (Exception e) {
            throw new MyException("HAS FLIGHT FREE PLACES EXCEPTION", LocalDateTime.now());
        }
    }

    public void addFlightForTourist(Long flightId, Long touristId) {
        try {

            if (hasTouristFlight(touristId, flightId)) {
                throw new IllegalArgumentException("TOURIST HAS ALREADY THIS FLIGHT");
            }

            if (!hasFlightFreePlaces(flightId)) {
                throw new IllegalArgumentException("FLIGHT HAS NOT GOT ANY FREE PLACES");
            }

            Tourist tourist = touristRepository.findById(touristId).orElseThrow(NullPointerException::new);
            Flight flight = flightRepository.findById(flightId).orElseThrow(NullPointerException::new);
            tourist.getFlights().add(flight);

        } catch (Exception e) {
            throw new MyException("ADD FLIGHT FOR TOURIST EXCEPTION", LocalDateTime.now());
        }
    }
}
