package homahoma.controller;

import homahoma.model.Pet;
import homahoma.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/pet")
public class PetController {

    @Autowired
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    private Logger logger = Logger.getLogger(PetController.class.getName());

    @PostMapping("/create")
    public void addPet(@RequestBody Pet pet) {
        petService.addPet(pet);
    }

    @GetMapping("/get/{id}")
    public Pet getPetById(@PathVariable Long id) throws Exception {
        return petService.getPetById(id);
    }

    @GetMapping("/allShelters")
    public List<Pet> getAllPet() {
        return petService.getAllPet();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePetById(@PathVariable Long id) {
        try {
            petService.deletePetById(id);
            logger.info("Pet (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updatePet(@RequestBody Pet newPet) throws Exception {
        petService.updatePet(newPet);
    }
}
