package homahoma.controller;

import homahoma.model.pets.TypeOfPet;
import homahoma.service.TypeOfPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/typeOfPet")
public class TypeOfPetController {

    private static final Logger logger = Logger.getLogger(TypeOfPetController.class.getName());

    private final TypeOfPetService typeOfPetService;

    @Autowired
    public TypeOfPetController(TypeOfPetService typeOfPetService) {
        this.typeOfPetService = typeOfPetService;
    }

    @PostMapping("/create")
    public void addTypeOfPet(@RequestBody TypeOfPet typeOfPet) {
        typeOfPetService.addTypeOfPet(typeOfPet);
    }

    @GetMapping("/get/{id}")
    public TypeOfPet getTypeOfPetById(@PathVariable Long id) throws Exception {
        return typeOfPetService.getTypeOfPetById(id);
    }

    @GetMapping("/allTypeOfPets")
    public List<TypeOfPet> getAllTypeOfPet() {
        return typeOfPetService.getAllTypeOfPet();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypeOfPetById(@PathVariable Long id) {
        try {
            typeOfPetService.deleteTypeOfPetById(id);
            logger.info("TypeOfPet (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateTypeOfPet(@RequestBody TypeOfPet newTypeOfPet) throws Exception {
        typeOfPetService.updateTypeOfPet(newTypeOfPet);
    }
}
