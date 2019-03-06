package michonski.mateusz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "flights")
public class Flight {
    private Long id;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Integer places;
    private BigDecimal ticketPrice;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "flights", fetch = FetchType.EAGER)
    private Set<Tourist> tourists;
}
