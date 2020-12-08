package homahoma.controller;

import homahoma.model.pets.TypeOfEar;
import homahoma.service.TypeOfEarService;
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
@RequestMapping(value = "api/typeOfEar")
public class TypeOfEarController {

    private static final Logger logger = Logger.getLogger(TypeOfEarController.class.getName());

    private final TypeOfEarService typeOfEarService;

    @Autowired
    public TypeOfEarController(TypeOfEarService typeOfEarService) {
        this.typeOfEarService = typeOfEarService;
    }

    @PostMapping("/create")
    public void createTypeOfEar(@RequestBody TypeOfEar typeOfEar) {
        typeOfEarService.addTypeOfEar(typeOfEar);
    }

    @GetMapping("/get/{id}")
    public TypeOfEar getTypeOfEarById(@PathVariable Long id) throws Exception {
        return typeOfEarService.getTypeOfEarById(id);
    }

    @GetMapping("/allTypeOfEars")
    public List<TypeOfEar> getAllTypeOfEar() {
        return typeOfEarService.getAllTypeOfEar();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypeOfEarById(@PathVariable Long id) {
        try {
            typeOfEarService.deleteTypeOfEarById(id);
            logger.info("TypeOfEar (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateTypeOfEar(@RequestBody TypeOfEar newTypeOfEar) throws Exception {
        typeOfEarService.updateTypeOfEar(newTypeOfEar);
    }
}
