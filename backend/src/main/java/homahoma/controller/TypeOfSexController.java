package homahoma.controller;

import homahoma.model.pets.TypeOfSex;
import homahoma.service.TypeOfSexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/typeOfSex")
public class TypeOfSexController {

    private static final Logger logger = Logger.getLogger(TypeOfSexController.class.getName());

    private final TypeOfSexService typeOfSexService;

    @Autowired
    public TypeOfSexController(TypeOfSexService typeOfSexService) {
        this.typeOfSexService = typeOfSexService;
    }

    @PutMapping("/create")
    public void addTypeOfSex(@RequestBody TypeOfSex typeOfSex) {
        typeOfSexService.addTypeOfSex(typeOfSex);
    }

    @GetMapping("/get/{id}")
    public TypeOfSex getTypeOfSexById(@PathVariable Long id) throws Exception {
        return typeOfSexService.getTypeOfSexById(id);
    }

    @GetMapping("/allTypeOfSexes")
    public List<TypeOfSex> getAllTypeOfSex() {
        return typeOfSexService.getAllTypeOfSex();
    }

    @DeleteMapping("/delete")
    public void deleteTypeOfSexById(@PathVariable Long id) {
        try {
            typeOfSexService.deleteTypeOfSexById(id);
            logger.info("TypeOfSex (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateTypeOfSex(@RequestBody TypeOfSex newTypeOfSex) throws Exception {
        typeOfSexService.updateTypeOfSex(newTypeOfSex);
    }
}
