package michonski.mateusz.model.dto.mappers;

import michonski.mateusz.model.Flight;
import michonski.mateusz.model.Tourist;
import michonski.mateusz.model.dto.FlightDTO;
import michonski.mateusz.model.dto.TouristDTO;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class ModelMapper {
    public TouristDTO fromTouristToTouristDTO(Tourist tourist) {
        return tourist == null ? null : TouristDTO.builder()
                .id(tourist.getId())
                .name(tourist.getName())
                .surname(tourist.getSurname())
                .gender(tourist.getGender())
                .country(tourist.getCountry())
                .notes(tourist.getNotes())
                .birthDate(tourist.getBirthDate())
                .build();
    }

    public Tourist fromTouristDTOToTourist(TouristDTO touristDTO) {
        return touristDTO == null ? null : Tourist.builder()
                .id(touristDTO.getId())
                .name(touristDTO.getName())
                .surname(touristDTO.getSurname())
                .gender(touristDTO.getGender())
                .country(touristDTO.getCountry())
                .notes(touristDTO.getNotes())
                .birthDate(touristDTO.getBirthDate())
                .flights(new HashSet<>())
                .build();
    }

    public FlightDTO fromFlightToFlightDTO(Flight flight) {
        return flight == null ? null : FlightDTO.builder()
                .id(flight.getId())
                .departureDateTime(flight.getDepartureDateTime())
                .arrivalDateTime(flight.getArrivalDateTime())
                .ticketPrice(flight.getTicketPrice())
                .places(flight.getPlaces())
                .build();
    }

    public Flight fromFlightDTOToFlight(FlightDTO flightDTO) {
        return flightDTO == null ? null : Flight.builder()
                .id(flightDTO.getId())
                .departureDateTime(flightDTO.getDepartureDateTime())
                .arrivalDateTime(flightDTO.getArrivalDateTime())
                .ticketPrice(flightDTO.getTicketPrice())
                .places(flightDTO.getPlaces())
                .tourists(new HashSet<>())
                .build();
    }
}
