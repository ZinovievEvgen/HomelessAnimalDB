package homahoma.controller;

import homahoma.model.pets.TypeOfColor;
import homahoma.service.TypeOfColorService;
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
@RequestMapping(value = "/api/typeOfColor")
public class TypeOfColorController {

    private static final Logger logger = Logger.getLogger(TypeOfColorController.class.getName());

    private final TypeOfColorService typeOfColorService;

    @Autowired
    public TypeOfColorController(TypeOfColorService typeOfColorService) {
        this.typeOfColorService = typeOfColorService;
    }

    @PostMapping("/create")
    public void addTypeOfColor(@RequestBody TypeOfColor typeOfColor) {
        typeOfColorService.addTypeOfColor(typeOfColor);
    }

    @GetMapping("/get/{id}")
    public TypeOfColor getTypeOfColorById(@PathVariable Long id) throws Exception {
        return typeOfColorService.getTypeOfColorById(id);
    }

    @GetMapping("/allTypeOfColors")
    public List<TypeOfColor> getAllTypeOfColor() {
        return typeOfColorService.getAllTypeOfColor();
    }

    @DeleteMapping("delete/{id}")
    public void deleteTypeOfColorById(@PathVariable Long id) {
        try {
            typeOfColorService.deleteTypeOfColorById(id);
            logger.info("TypeOfColor (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateTypeOfColor(@RequestBody TypeOfColor newTypeOfColor) throws Exception {
        typeOfColorService.updateTypeOfColor(newTypeOfColor);
    }
}
