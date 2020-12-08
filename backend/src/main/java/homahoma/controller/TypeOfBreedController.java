package homahoma.controller;

import homahoma.model.pets.TypeOfBreed;
import homahoma.service.TypeOfBreedService;
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
@RequestMapping(value = "api/typeOfBreed")
public class TypeOfBreedController {

    private static final Logger logger = Logger.getLogger(TypeOfBreedController.class.getName());

    private final TypeOfBreedService typeOfBreedService;

    @Autowired
    public TypeOfBreedController(TypeOfBreedService typeOfBreedService) {
        this.typeOfBreedService = typeOfBreedService;
    }

    @PostMapping("/create")
    public void addTypeOfBreed(@RequestBody TypeOfBreed typeOfBreed) {
        typeOfBreedService.addTypeOfBreed(typeOfBreed);
    }

    @GetMapping("/get/{id}")
    public TypeOfBreed getTypeOfBreedById(@PathVariable Long id) throws Exception {
        return typeOfBreedService.getTypeOfBreedById(id);
    }

    @GetMapping("/allTypeOfBreeds")
    public List<TypeOfBreed> getAllTypeOfBreed() {
        return typeOfBreedService.getAllTypeOfBreed();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypeOfBreedById(@PathVariable Long id) {
        try {
            typeOfBreedService.deleteTypeOfBreedById(id);
            logger.info("TypeOfBreed (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateTypeOfBreed(@RequestBody TypeOfBreed newTypeOfBreed) throws Exception {
        typeOfBreedService.updateTypeOfBreed(newTypeOfBreed);
    }
}
