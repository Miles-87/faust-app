package michonski.mateusz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import michonski.mateusz.model.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TouristDTO {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private String country;
    private String notes;
    private LocalDate birthDate;
}
