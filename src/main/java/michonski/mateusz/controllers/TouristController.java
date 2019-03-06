package michonski.mateusz.controllers;

import michonski.mateusz.model.dto.TouristDTO;
import michonski.mateusz.service.TouristService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourists")
public class TouristController {
    private TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping
    public List<TouristDTO> getAllTourists() {
        return service.getAllTourists();
    }

    @PostMapping
    public TouristDTO addTourist(@RequestBody TouristDTO touristDTO) {
        return service.addTourist(touristDTO);
    }

    @DeleteMapping("/{id}")
    public TouristDTO deleteTourist(@PathVariable Long id) {
        return service.deleteTourist(id);
    }
}
