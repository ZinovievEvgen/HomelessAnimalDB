package homahoma.controller;

import homahoma.model.pets.TypeOfWool;
import homahoma.service.TypeOfWoolService;
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
@RequestMapping("/api/typeOfWool")
public class TypeOfWoolController {

    private static final Logger logger = Logger.getLogger(TypeOfWoolController.class.getName());

    private final TypeOfWoolService typeOfWoolService;

    @Autowired
    public TypeOfWoolController(TypeOfWoolService typeOfWoolService) {
        this.typeOfWoolService = typeOfWoolService;
    }

    @PutMapping("/create")
    public void addTypeOfWool(@RequestBody TypeOfWool typeOfWool) {
        typeOfWoolService.addTypeOfWool(typeOfWool);
    }

    @GetMapping("/get/{id}")
    public TypeOfWool getTypeOfWoolById(@PathVariable Long id) throws Exception {
        return typeOfWoolService.getTypeOfWoolById(id);
    }

    @GetMapping("/allTypeOfWools")
    public List<TypeOfWool> getAllTypeOfWool() {
        return typeOfWoolService.getAllTypeOfWool();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypeOfWoolById(@PathVariable Long id) {
        try {
            typeOfWoolService.deleteTypeOfWoolById(id);
            logger.info("TypeOfWool (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PostMapping("/update")
    public void updateTypeOfWool(@RequestBody TypeOfWool newTypeOfWool) throws Exception {
        typeOfWoolService.updateTypeOfWool(newTypeOfWool);
    }
}
