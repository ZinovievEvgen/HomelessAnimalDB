package homahoma.controller;

import homahoma.model.Shelter;
import homahoma.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/shelter")
public class ShelterController {

    @Autowired
    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    private Logger logger = Logger.getLogger(ShelterController.class.getName());

    @PostMapping("/create")
    public void addShelter(@RequestBody Shelter shelter) {
        shelterService.addShelter(shelter);
    }

    @GetMapping("/get/{id}")
    public Shelter getShelterById(@PathVariable Long id) throws Exception {
        return shelterService.getShelterById(id);
    }

    @GetMapping("/allShelters")
    public List<Shelter> getAllShelter() {
        return shelterService.getAllShelter();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteShelterById(@PathVariable Long id) {
        try {
            shelterService.deleteShelterById(id);
            logger.info("Shelter (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateShelter(@RequestBody Shelter newShelter) throws Exception {
        shelterService.updateShelter(newShelter);
    }
}
