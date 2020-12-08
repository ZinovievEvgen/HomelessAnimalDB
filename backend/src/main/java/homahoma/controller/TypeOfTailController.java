package homahoma.controller;

import homahoma.model.pets.TypeOfTail;
import homahoma.service.TypeOfTailService;
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
@RequestMapping("/api/typeOfTail")
public class TypeOfTailController {

    private static final Logger logger = Logger.getLogger(TypeOfTailController.class.getName());

    private final TypeOfTailService typeOfTailService;

    @Autowired
    public TypeOfTailController(TypeOfTailService typeOfTailService) {
        this.typeOfTailService = typeOfTailService;
    }

    @PostMapping("/create")
    public void addTypeOfTail(@RequestBody TypeOfTail typeOfTail) {
        typeOfTailService.addTypeOfTail(typeOfTail);
    }

    @GetMapping("/get/{id}")
    public TypeOfTail getTypeOfTailById(@PathVariable Long id) throws Exception {
        return typeOfTailService.getTypeOfTailById(id);
    }

    @GetMapping("/allTypeOfTails")
    public List<TypeOfTail> getAllTypeOfTail() {
        return typeOfTailService.getAllTypeOfTail();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypeOfTailById(@PathVariable Long id) {
        try {
            typeOfTailService.deleteTypeOfTailById(id);
            logger.info("TypeOfTail (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateTypeOfTail(@RequestBody TypeOfTail newTypeOfTail) throws Exception {
        typeOfTailService.updateTypeOfTail(newTypeOfTail);
    }
}
